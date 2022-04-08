package fr.isep.arlara.kahut.service;

import fr.isep.arlara.kahut.model.Housing;
import fr.isep.arlara.kahut.repository.HousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousingServiceImpl implements HousingService {

    @Autowired
    private HousingRepository repository;

    @Override
    public Housing saveHousing(Housing housing){
        return repository.save(housing);
    }

    @Override
    public List<Housing> listHousing() {
        return repository.findAll();
    }


}
