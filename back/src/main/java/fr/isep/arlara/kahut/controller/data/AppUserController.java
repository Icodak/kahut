package fr.isep.arlara.kahut.controller.data;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@RequiredArgsConstructor
public class AppUserController {

    @GetMapping
    public String hello(Authentication authentication) {

        return "Hello, " + authentication.getName() + "!";
    }
}
