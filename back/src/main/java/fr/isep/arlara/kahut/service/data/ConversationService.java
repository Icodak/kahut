package fr.isep.arlara.kahut.service.data;

import fr.isep.arlara.kahut.repository.ConversationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConversationService {


    private final ConversationRepository repository;

}
