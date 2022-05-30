package fr.isep.arlara.kahut.controller.data;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.database.Housing;
import fr.isep.arlara.kahut.model.request.LogementRequest;
import fr.isep.arlara.kahut.service.data.AppUserService;
import fr.isep.arlara.kahut.service.data.HousingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/housing")
@CrossOrigin
@AllArgsConstructor
public class HousingController {

    private HousingService housingService;
    private AppUserService userService;

    @GetMapping
    public ResponseEntity<List<Housing>> getHousings() {
        return housingService.getHousing();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogementRequest> getLogement(@PathVariable String id) {
        return housingService.getLogement(id);
    }

    @PostMapping("/{id}/bookmark")
    public ResponseEntity<String> bookmarkHousing(@PathVariable String id, Authentication authentication) {
        AppUser user = (AppUser) userService.loadUserByUsername(authentication.getName());
        return housingService.bookmark(id,user);
    }

    @PostMapping
    public ResponseEntity<LogementRequest> postHousing(Authentication authentication, @RequestBody Housing housing) {
        AppUser author = (AppUser) userService.loadUserByUsername(authentication.getName());
        return housingService.postHousing(housing,author);
    }



}
