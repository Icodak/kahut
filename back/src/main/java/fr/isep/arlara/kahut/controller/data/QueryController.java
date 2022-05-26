package fr.isep.arlara.kahut.controller.data;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.database.Housing;
import fr.isep.arlara.kahut.model.request.QueryRequest;
import fr.isep.arlara.kahut.repository.HousingRepository;
import fr.isep.arlara.kahut.service.data.HousingService;
import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/query")
@CrossOrigin
@AllArgsConstructor


public class QueryController {

    private HousingService housingservice ;

    @PostMapping
    public ResponseEntity<List<Housing>> search (@RequestBody QueryRequest queryrequest) {
        return housingservice.findAllByRequest(queryrequest);

    }

}
