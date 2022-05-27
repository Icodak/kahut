package fr.isep.arlara.kahut.service.data;

import fr.isep.arlara.kahut.model.database.Housing;
import fr.isep.arlara.kahut.model.request.LogementRequest;
import fr.isep.arlara.kahut.model.request.QueryRequest;
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
public class HousingService{

    private final HousingRepository repository;

    public ResponseEntity<LogementRequest> getHousing(String id) {
        if (KahutUtils.isValidUUID(id)) {
            Optional<Housing> optHousing = repository.findById(UUID.fromString(id));
            if (optHousing.isPresent()) {
                Housing housing = optHousing.get();
                LogementRequest logementRequest = new LogementRequest(
                        housing.getTitle(),
                        housing.getDescription(),
                        housing.getImages(),
                        housing.getAuthor().toUserRequest(),
                        housing.getTags(),
                        housing.getStars(),
                        housing.getLocation(),
                        housing.getRatings()
                );
                return ResponseEntity.ok().body(logementRequest);
            }
        }
        return ResponseEntity.badRequest().body(null);
    }

    public ResponseEntity<List<Housing>> getHousing() {
        Optional<List<Housing>> housings = Optional.of(repository.findAll());
        return ResponseEntity.of(housings);
    }

    public ResponseEntity<Housing> postHousing(@RequestBody Housing housing) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/housing").toUriString());
        return ResponseEntity.created(uri).body(repository.save(housing));
    }

    public ResponseEntity <List<Housing>> findAllByRequest(QueryRequest queryrequest) {
        Optional <List<Housing>> housingList = repository.findAllByRequest(
                queryrequest.getDestination()
                //queryrequest.getDateBack(),
                //queryrequest.getDateGo(),
                //queryrequest.getNumberTravellers()
        );
        return ResponseEntity.ok(housingList.orElse(new ArrayList<>()));
    }
}
