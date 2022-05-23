package fr.isep.arlara.kahut.controller.data;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.request.UserRequest;
import fr.isep.arlara.kahut.service.data.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@AllArgsConstructor
public class AppUserController {

    private AppUserService userService;

    @GetMapping
        public ResponseEntity<UserRequest> hello(Authentication authentication) {
        AppUser user = (AppUser) userService.loadUserByUsername(authentication.getName());
        UserRequest userRequest = new UserRequest(user.getFullName(), user.getDescription(), user.getEmail(), user.getPhone());
        return ResponseEntity.ok().body(userRequest);
    }
}
