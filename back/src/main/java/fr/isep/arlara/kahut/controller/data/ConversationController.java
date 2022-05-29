package fr.isep.arlara.kahut.controller.data;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.request.ConversationReturn;
import fr.isep.arlara.kahut.model.request.LogementRequest;
import fr.isep.arlara.kahut.service.data.AppUserService;
import fr.isep.arlara.kahut.service.data.ConversationService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversation")
@CrossOrigin
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;
    @GetMapping("/{id}")
    public ResponseEntity<ConversationReturn> getConversation(@PathVariable String id) {
        return conversationService.getConversationById(id);
    }

}
