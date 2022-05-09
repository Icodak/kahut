package fr.isep.arlara.kahut.controller;

import fr.isep.arlara.kahut.service.data.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tag")
@CrossOrigin
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

}
