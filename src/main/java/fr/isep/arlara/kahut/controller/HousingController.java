package fr.isep.arlara.kahut.controller;

import fr.isep.arlara.kahut.repository.HousingRepository;
import org.springframework.stereotype.Controller;

@Controller
public class HousingController {

    private final HousingRepository repository;

    public HousingController(HousingRepository repository) {
        this.repository = repository;
    }

}
