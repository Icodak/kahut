package fr.isep.arlara.kahut.service.data;

import fr.isep.arlara.kahut.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {


    private final MessageRepository repository;

}
