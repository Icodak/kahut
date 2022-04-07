package fr.isep.arlara.kahut.controller;

import fr.isep.arlara.kahut.model.Housing;
import fr.isep.arlara.kahut.service.HousingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/housing")
public class HousingController {

    @Autowired
    private HousingServiceImpl housingServiceImpl;

    @PostMapping("/add")
    public String add(@RequestBody Housing housing){
        housingServiceImpl.saveHousing(housing);
        return "Housing has been added to DB";
    }

}
