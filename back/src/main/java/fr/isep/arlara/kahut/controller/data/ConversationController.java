package fr.isep.arlara.kahut.controller.data;

import fr.isep.arlara.kahut.service.data.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conversation")
@CrossOrigin
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;

}
