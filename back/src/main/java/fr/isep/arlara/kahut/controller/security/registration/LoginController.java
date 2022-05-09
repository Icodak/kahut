package fr.isep.arlara.kahut.controller.security.registration;

import fr.isep.arlara.kahut.model.request.LoginRequest;
import fr.isep.arlara.kahut.service.security.login.loginService;
import fr.isep.arlara.kahut.service.security.registration.RegistrationService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody LoginRequest request) throws MessagingException {
        return loginService.login(request);
    }

}
