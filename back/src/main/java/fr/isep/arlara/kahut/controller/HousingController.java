package fr.isep.arlara.kahut.controller;

import fr.isep.arlara.kahut.model.Housing;
import fr.isep.arlara.kahut.service.HousingService;
import fr.isep.arlara.kahut.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/housing")
@CrossOrigin
public class HousingController {

    @Autowired
    private HousingService housingService;

    @GetMapping
    public ResponseEntity<List<Housing>> getHousings() {
        return ResponseEntity.ok().body(housingService.listHousing());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Housing> getHousing(@PathVariable String id) {
        if (UtilsService.isValidUUID(id)){
            return ResponseEntity.ok().body(housingService.listHousing(UUID.fromString(id)));
        }
            return ResponseEntity.badRequest().body(new Housing());

    }

    @PostMapping
    public ResponseEntity<Housing> saveHousing(@RequestBody Housing housing) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/housing").toUriString());
        return ResponseEntity.created(uri).body(housingService.saveHousing(housing));
    }


}
