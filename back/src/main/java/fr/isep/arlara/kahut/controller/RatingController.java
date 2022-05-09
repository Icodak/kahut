package fr.isep.arlara.kahut.controller;

import fr.isep.arlara.kahut.service.data.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rating")
@CrossOrigin
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

}
