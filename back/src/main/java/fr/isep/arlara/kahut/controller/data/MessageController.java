package fr.isep.arlara.kahut.controller.data;

import fr.isep.arlara.kahut.service.data.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
@CrossOrigin
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

}
