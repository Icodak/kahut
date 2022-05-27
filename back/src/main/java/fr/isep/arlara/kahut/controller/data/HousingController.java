package fr.isep.arlara.kahut.controller.data;

import fr.isep.arlara.kahut.model.database.Housing;
import fr.isep.arlara.kahut.model.request.BookmarkRequest;
import fr.isep.arlara.kahut.model.request.LogementRequest;
import fr.isep.arlara.kahut.service.data.HousingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/housing")
@CrossOrigin
@AllArgsConstructor
public class HousingController {

    private HousingService housingService;

    @GetMapping
    public ResponseEntity<List<Housing>> getHousings() {
        return housingService.getHousing();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogementRequest> getLogement(@PathVariable String id) {
        return housingService.getLogement(id);
    }

    @PostMapping("/bookmark")
    public void bookmarkHousing(@RequestBody BookmarkRequest bookmarkRequest) {
        housingService.bookmark(bookmarkRequest);
    }

    @PostMapping
    public ResponseEntity<Housing> postHousing(@RequestBody Housing housing) {
        return housingService.postHousing(housing);
    }



}
