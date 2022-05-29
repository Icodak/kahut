package fr.isep.arlara.kahut.service.data;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.database.Housing;
import fr.isep.arlara.kahut.model.request.*;
import fr.isep.arlara.kahut.repository.AppUserRepository;
import fr.isep.arlara.kahut.repository.HousingRepository;
import fr.isep.arlara.kahut.service.utils.KahutUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HousingService {

    private final HousingRepository housingRepository;
    private final AppUserRepository appUserRepository;

    private final MessageService messageService;

    public ResponseEntity<LogementRequest> getLogement(String id) {
        Housing housing = getHousing(id);
        if (housing != null) {
            return ResponseEntity.ok().body(housing.toLogementRequest());
        }
        return ResponseEntity.notFound().build();
    }

    public Housing getHousing(String id) {
        if (KahutUtils.isValidUUID(id)) {
            Optional<Housing> optHousing = housingRepository.findById(UUID.fromString(id));
            return optHousing.orElse(null);
        }
        return null;
    }

    public ResponseEntity<List<Housing>> getHousing() {
        Optional<List<Housing>> housings = Optional.of(housingRepository.findAll());
        return ResponseEntity.of(housings);
    }

    public ResponseEntity<Housing> postHousing(@RequestBody Housing housing) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/housing").toUriString());
        return ResponseEntity.created(uri).body(housingRepository.save(housing));
    }

    public ResponseEntity<List<QueryResponse>> findAllByRequest(QueryRequest queryrequest) {
        List<Housing> housingList = housingRepository.findAllByRequest(
                queryrequest.getDestination());
        if (housingList.size() > 0)
            return ResponseEntity.ok().body(housingList.stream().map(Housing::toQueryResponse).collect(Collectors.toList()));
        return ResponseEntity.notFound().build();

    }

    public ResponseEntity<String> bookmark(String id, AppUser requester) {
        System.out.println(id);
        Housing recipientHousing = getHousing(id);
        if (recipientHousing != null) {
            //On ne s'auto bookmark pas
            if (requester == recipientHousing.getAuthor()) return ResponseEntity.badRequest().build();

            recipientHousing.getBookmarks().add(requester);

            Optional<Housing> optRequesterHousing = requester.getHousingsToBook().stream().filter(h -> h.getBookmarks().contains(recipientHousing.getAuthor())).findFirst();
            //Si déjà bookmarked
            if (optRequesterHousing.isPresent()) {
                Housing requesterHousing = optRequesterHousing.get();
                recipientHousing.setIsReserved(true);
                requesterHousing.setIsReserved(true);
                housingRepository.save(recipientHousing);
                housingRepository.save(requesterHousing);
                messageService.sendMessage(new MessageRequest(recipientHousing.getAuthor().getEmail(), "Proposition acceptée"), requester);

            } else {
                messageService.sendMessage(new MessageRequest(recipientHousing.getAuthor().getEmail(), "Votre logement " + recipientHousing.getTitle() + " m'intéresse, que diriez vous d'un échange?"), requester);
            }
            return ResponseEntity.ok().body("Bookmarked");
        }
        return ResponseEntity.badRequest().build();
    }
}
