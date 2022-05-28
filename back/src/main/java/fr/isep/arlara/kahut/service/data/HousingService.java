package fr.isep.arlara.kahut.service.data;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.database.Housing;
import fr.isep.arlara.kahut.model.request.BookmarkRequest;
import fr.isep.arlara.kahut.model.request.LogementRequest;
import fr.isep.arlara.kahut.model.request.QueryRequest;
import fr.isep.arlara.kahut.repository.AppUserRepository;
import fr.isep.arlara.kahut.repository.HousingRepository;
import fr.isep.arlara.kahut.service.utils.KahutUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public ResponseEntity<List<Housing>> findAllByRequest(QueryRequest queryrequest) {
        Optional<List<Housing>> housingList = housingRepository.findAllByRequest(
                queryrequest.getDestination()
                //queryrequest.getDateBack(),
                //queryrequest.getDateGo(),
                //queryrequest.getNumberTravellers()
        );
        return ResponseEntity.ok(housingList.orElse(new ArrayList<>()));
    }

    public void bookmark(BookmarkRequest bookmarkRequest) {
        Housing recipientHousing = getHousing(bookmarkRequest.getHousingId());
        String requesterEmail = bookmarkRequest.getRequester();
        if (recipientHousing != null) {

            Optional<AppUser> optRequester = appUserRepository.findByEmail(requesterEmail);
            if (optRequester.isEmpty()) return;
            AppUser requester = optRequester.get();

            //On ne s'auto bookmark pas
            if (requester == recipientHousing.getAuthor()) return;

            recipientHousing.getBookmarks().add(requester);

            Optional<Housing> optRequesterHousing = requester.getHousingsToBook().stream().filter(h -> h.getBookmarks().contains(recipientHousing.getAuthor())).findFirst();
            //Si déjà bookmarked
            if (optRequesterHousing.isPresent()) {
                Housing requesterHousing = optRequesterHousing.get();
                recipientHousing.setIsReserved(true);
                requesterHousing.setIsReserved(true);
                housingRepository.save(recipientHousing);
                housingRepository.save(requesterHousing);
                messageService.sendMessage(requester, recipientHousing.getAuthor(), "Proposition acceptée");
            } else {
                messageService.sendMessage(
                        requester,
                        recipientHousing.getAuthor(),
                        "Votre logement " + recipientHousing.getTitle() + " m'intéresse, que diriez vous d'un échange?");
            }

        }
    }
}
