package fr.isep.arlara.kahut.service;

import fr.isep.arlara.kahut.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository repository;

}
