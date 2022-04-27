package fr.isep.arlara.kahut.service;

import fr.isep.arlara.kahut.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository repository;

}
