package fr.isep.arlara.kahut.controller;

import fr.isep.arlara.kahut.service.data.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

}
