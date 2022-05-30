package fr.isep.arlara.kahut.service.data;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.database.Conversation;
import fr.isep.arlara.kahut.model.request.ConversationResponse;
import fr.isep.arlara.kahut.model.request.ConversationReturn;
import fr.isep.arlara.kahut.repository.ConversationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static fr.isep.arlara.kahut.service.utils.KahutUtils.isValidUUID;

@Service
@RequiredArgsConstructor
public class ConversationService {


    private final ConversationRepository conversationRepository;

    public ResponseEntity<ConversationReturn> getConversationById(String id) {
        if (isValidUUID(id)) {
            UUID uuid = UUID.fromString(id);
            Optional<Conversation> optConversation = conversationRepository.findById(uuid);
            if (optConversation.isPresent()) {
                return ResponseEntity.ok().body(optConversation.get().toConversationRequest());
            }
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<ConversationResponse>> getConversations(AppUser user) {

        return ResponseEntity.ok()
                .body(conversationRepository.getByAuthor(user)
                        .stream().map(conversation ->
                                new ConversationResponse(
                                        conversation.getId(),
                                        conversation.getTitle(),
                                        conversation.getSender() == user? conversation.getRecipient().getEmail() : conversation.getSender().getEmail()))
                        .collect(Collectors.toList()));
    }
}
