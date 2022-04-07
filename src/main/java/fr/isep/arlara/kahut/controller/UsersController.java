package fr.isep.arlara.kahut.controller;

import fr.isep.arlara.kahut.repository.UsersRepository;
import org.springframework.stereotype.Controller;

@Controller
public class UsersController {

    private final UsersRepository repository;

    public UsersController(UsersRepository repository) {
        this.repository = repository;
    }

}
