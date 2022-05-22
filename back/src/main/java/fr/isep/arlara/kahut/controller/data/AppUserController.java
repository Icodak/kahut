package fr.isep.arlara.kahut.controller.data;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.service.data.AppUserService;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.desktop.SystemEventListener;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@AllArgsConstructor
public class AppUserController {

    private AppUserService userService;

    @GetMapping
    public JsonObject hello(Authentication authentication) {
        JsonObject object = new JsonObject();
        AppUser user = (AppUser) userService.loadUserByUsername(authentication.getName());
        object.put("name", user.getFullName()).put("email", user.getEmail());
        return object;
    }
}
