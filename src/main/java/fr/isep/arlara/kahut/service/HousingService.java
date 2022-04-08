package fr.isep.arlara.kahut.service;

import fr.isep.arlara.kahut.model.Housing;

import java.util.List;

public interface HousingService {
    Housing saveHousing(Housing housing);

    List<Housing> listHousing();
}
