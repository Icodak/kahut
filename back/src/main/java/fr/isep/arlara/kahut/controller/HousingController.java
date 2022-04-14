package fr.isep.arlara.kahut.controller;

import fr.isep.arlara.kahut.model.Housing;
import fr.isep.arlara.kahut.service.HousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/housing")
@CrossOrigin
public class HousingController {

    @Autowired
    private HousingService housingService;

    @PostMapping
    public String add(@RequestBody Housing housing){
        Housing house = housingService.saveHousing(housing);
        return "Housing "+ house.toString() +"has been added to DB";
    }

    @GetMapping
    public String list(){
        return housingService.listHousing().toString();
    }

    @GetMapping("/{id}")
    public String listOne(@PathVariable UUID id) {return housingService.listHousing(id).toString();}

}
