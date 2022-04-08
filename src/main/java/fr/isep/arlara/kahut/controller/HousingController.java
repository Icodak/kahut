package fr.isep.arlara.kahut.controller;

import fr.isep.arlara.kahut.model.Housing;
import fr.isep.arlara.kahut.service.HousingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/housing")
@CrossOrigin
public class HousingController {

    @Autowired
    private HousingServiceImpl housingServiceImpl;

    @PostMapping("/add")
    public String add(@RequestBody Housing housing){
        Housing house = housingServiceImpl.saveHousing(housing);
        return "Housing "+ house.toString() +"has been added to DB";
    }

    @GetMapping
    public String list(){
        return housingServiceImpl.listHousing().toString();
    }

}
