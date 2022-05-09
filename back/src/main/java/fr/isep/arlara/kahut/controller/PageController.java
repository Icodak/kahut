package fr.isep.arlara.kahut.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/page")
public class PageController {

    @GetMapping("/home")
    public String getHome()
    {
        return "Home";
    }
}
