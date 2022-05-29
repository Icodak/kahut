package fr.isep.arlara.kahut.controller.data;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.request.ConversationReturn;
import fr.isep.arlara.kahut.model.request.MessageRequest;
import fr.isep.arlara.kahut.service.data.AppUserService;
import fr.isep.arlara.kahut.service.data.MessageService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
@CrossOrigin
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final AppUserService userService;

    @PostMapping
    public ResponseEntity<ConversationReturn> sendMessage(@RequestBody MessageRequest messageRequest, Authentication authentication) {
        AppUser user = (AppUser) userService.loadUserByUsername(authentication.getName());
        return messageService.sendMessage(messageRequest,user);
    }


}
