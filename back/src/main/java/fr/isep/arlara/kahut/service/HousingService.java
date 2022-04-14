package fr.isep.arlara.kahut.service;

import fr.isep.arlara.kahut.model.Housing;
import fr.isep.arlara.kahut.repository.HousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HousingService {

    @Autowired
    private HousingRepository repository;


    public Housing saveHousing(Housing housing){
        return repository.save(housing);
    }


    public List<Housing> listHousing() {
        return repository.findAll();
    }

    public Housing listHousing(UUID id) {
        Optional<Housing> housing = repository.findById(id);
        return housing.orElse(new Housing());
    }
}
