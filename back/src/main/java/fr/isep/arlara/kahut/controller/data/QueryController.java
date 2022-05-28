package fr.isep.arlara.kahut.controller.data;

import fr.isep.arlara.kahut.model.database.Housing;
import fr.isep.arlara.kahut.model.request.QueryRequest;
import fr.isep.arlara.kahut.service.data.HousingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
