package fr.isep.arlara.kahut.controller;

import fr.isep.arlara.kahut.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/image")
@CrossOrigin
public class ImageController {
    @Autowired
    private ImageService imageService;

}
