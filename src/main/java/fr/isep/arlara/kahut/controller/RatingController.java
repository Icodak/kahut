package fr.isep.arlara.kahut.controller;

import fr.isep.arlara.kahut.repository.RatingRepository;
import org.springframework.stereotype.Controller;

@Controller
public class RatingController {

    private final RatingRepository repository;

    public RatingController(RatingRepository repository) {
        this.repository = repository;
    }

}
