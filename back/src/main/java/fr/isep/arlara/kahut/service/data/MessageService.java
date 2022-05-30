package fr.isep.arlara.kahut.service.data;


import com.pusher.rest.Pusher;
import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.database.Conversation;
import fr.isep.arlara.kahut.model.database.Message;
import fr.isep.arlara.kahut.model.request.ConversationReturn;
import fr.isep.arlara.kahut.model.request.MessageRequest;
import fr.isep.arlara.kahut.repository.AppUserRepository;
import fr.isep.arlara.kahut.repository.ConversationRepository;
import fr.isep.arlara.kahut.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final AppUserRepository appUserRepository;
    private final ConversationRepository conversationRepository;
    private  final Pusher pusher = new Pusher("1415798", "0e78550231dc32a00604", "7969058ec28ebe9b88e0");

    public ResponseEntity<ConversationReturn> sendMessage(MessageRequest messageRequest, AppUser author) {
        Optional<AppUser> optRecipient = appUserRepository.findByEmail(messageRequest.getRecipient());
        if (optRecipient.isPresent() && optRecipient.get() != author) {
            AppUser recipient = optRecipient.get();
            Conversation conversation = conversationRepository.getByEmail(author, recipient);
            System.out.println(conversation);
            if (conversation == null) {
                conversation = createConversation(author, recipient);
            }
            //.orElse(createConversation(author,recipient));
            Message message = messageRepository.save(new Message(author, LocalTime.now(), messageRequest.getMessage()));
            conversation.getMessages().add(message);
            Conversation updatedConversation = conversationRepository.save(conversation);
            pusher.setCluster("eu");
            pusher.setEncrypted(true);
            pusher.trigger("kahut", "message",
                    Collections.singletonMap("message", message.toMessageReturn().toJSON()));
            return ResponseEntity.ok().body(updatedConversation.toConversationRequest());
        }
        return ResponseEntity.badRequest().body(null);
    }

    private Conversation createConversation(AppUser author, AppUser recipient) {
        System.out.println("created");
        Conversation conversation = new Conversation("HomeExchange", author, recipient);
        return conversationRepository.save(conversation);
    }
}
