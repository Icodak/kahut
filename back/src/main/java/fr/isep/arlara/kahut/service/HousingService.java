package fr.isep.arlara.kahut.service;

import fr.isep.arlara.kahut.model.Housing;

import java.util.List;
import java.util.UUID;

public interface HousingService {
    Housing saveHousing(Housing housing);

    List<Housing> listHousing();

    Housing listHousing(UUID id);
}
