package fr.isep.arlara.kahut.controller;

import fr.isep.arlara.kahut.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class AppUserController {
   @Autowired
    private AppUserService appUserService;

}
