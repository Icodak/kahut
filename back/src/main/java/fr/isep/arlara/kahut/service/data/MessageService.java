package fr.isep.arlara.kahut.service.data;

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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final AppUserRepository appUserRepository;
    private final ConversationRepository conversationRepository;


    public ResponseEntity<ConversationReturn> sendMessage(MessageRequest messageRequest) {
        Optional<AppUser> author = appUserRepository.findByEmail(messageRequest.getAuthor());
        Optional<AppUser> recipient = appUserRepository.findByEmail(messageRequest.getRecipient());
        if (author.isPresent() && recipient.isPresent()) {
            Conversation conversation = conversationRepository.getByEmail(author.get(),recipient.get())
                    .orElse(createConversation(author.get(),recipient.get()));
            Message message = messageRepository.save(new Message(author.get(), LocalTime.now(), messageRequest.getMessage()));
            conversation.getMessages().add(message);
            Conversation updatedConversation = conversationRepository.save(conversation);

            return ResponseEntity.ok().body(updatedConversation.toConversationRequest());
        }
        return ResponseEntity.badRequest().body(null);
    }

    public void sendMessage(AppUser author, AppUser recipient, String msg) {
            Conversation conversation = conversationRepository.getByEmail(author,recipient)
                    .orElse(createConversation(author,recipient));
            Message message = messageRepository.save(new Message(author, LocalTime.now(), msg));
            conversation.getMessages().add(message);
            Conversation updatedConversation = conversationRepository.save(conversation);
    }

    private Conversation createConversation(AppUser author, AppUser recipient){
        Conversation conversation = new Conversation("HomeExchange", author, recipient);
        return conversationRepository.save(conversation);
    }
}
