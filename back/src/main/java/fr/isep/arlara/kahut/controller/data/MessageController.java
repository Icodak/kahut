package fr.isep.arlara.kahut.controller.data;

import fr.isep.arlara.kahut.model.request.ConversationReturn;
import fr.isep.arlara.kahut.model.request.MessageRequest;
import fr.isep.arlara.kahut.service.data.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
@CrossOrigin
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<ConversationReturn> sendMessage(@RequestBody MessageRequest messageRequest) {
        return messageService.sendMessage(messageRequest);
    }


}
