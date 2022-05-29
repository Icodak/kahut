package fr.isep.arlara.kahut.service.data;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.database.Conversation;
import fr.isep.arlara.kahut.model.request.ConversationReturn;
import fr.isep.arlara.kahut.repository.ConversationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static fr.isep.arlara.kahut.service.utils.KahutUtils.isValidUUID;

@Service
@RequiredArgsConstructor
public class ConversationService {


    private final ConversationRepository conversationRepository;

    public ResponseEntity<ConversationReturn> getConversationById(String id) {
        if (isValidUUID(id)){
        UUID uuid = UUID.fromString(id);
        Optional<Conversation> optConversation = conversationRepository.findById(uuid);
        if (optConversation.isPresent()){
            return ResponseEntity.ok().body(optConversation.get().toConversationRequest());
        }
    }
    return  ResponseEntity.notFound().build();
    }
}
