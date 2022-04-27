package fr.isep.arlara.kahut.service;

import fr.isep.arlara.kahut.model.Housing;
import fr.isep.arlara.kahut.repository.HousingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class HousingService {

    //TODO headers

    private final HousingRepository repository;


    public ResponseEntity<Housing> saveHousing(@RequestBody Housing housing){
        return ResponseEntity.ok().body(repository.save(housing));
    }


    public List<Housing> listHousing() {
        return repository.findAll();
    }

    public Housing listHousing(UUID id) {
        Optional<Housing> housing = repository.findById(id);
        return housing.orElse(new Housing());
    }
}
