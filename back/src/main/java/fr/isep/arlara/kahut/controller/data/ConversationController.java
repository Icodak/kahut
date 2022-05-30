package fr.isep.arlara.kahut.controller.data;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.request.ConversationResponse;
import fr.isep.arlara.kahut.model.request.ConversationReturn;
import fr.isep.arlara.kahut.service.data.AppUserService;
import fr.isep.arlara.kahut.service.data.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversation")
@CrossOrigin
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;
    private final AppUserService userService;
    @GetMapping
    public ResponseEntity<List<ConversationResponse>> getConversations(Authentication authentication){
        AppUser user = (AppUser) userService.loadUserByUsername(authentication.getName());
        return conversationService.getConversations(user);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ConversationReturn> getConversation(@PathVariable String id) {
        return conversationService.getConversationById(id);
    }

}
