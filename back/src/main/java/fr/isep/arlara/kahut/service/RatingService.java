package fr.isep.arlara.kahut.service;

import fr.isep.arlara.kahut.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository repository;

}
