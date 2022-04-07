package fr.isep.arlara.kahut.controller;

import fr.isep.arlara.kahut.repository.ImageRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ImageController {

    private final ImageRepository repository;

    public ImageController(ImageRepository repository) {
        this.repository = repository;
    }

}
