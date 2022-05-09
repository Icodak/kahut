package fr.isep.arlara.kahut.controller;

import fr.isep.arlara.kahut.service.data.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/image")
@CrossOrigin
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

}
