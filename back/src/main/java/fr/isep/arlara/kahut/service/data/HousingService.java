package fr.isep.arlara.kahut.service.data;

import fr.isep.arlara.kahut.model.database.Housing;
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

@Service
@RequiredArgsConstructor
public class HousingService {

    private final HousingRepository repository;

    public ResponseEntity<Housing> getHousing(String id) {
        if (KahutUtils.isValidUUID(id)) {
            Optional<Housing> housing = repository.findById(UUID.fromString(id));
            return ResponseEntity.of(housing);
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


}
