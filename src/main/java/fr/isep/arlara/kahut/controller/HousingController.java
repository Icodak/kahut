package fr.isep.arlara.kahut.controller;

import fr.isep.arlara.kahut.model.Housing;
import fr.isep.arlara.kahut.repository.HousingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HousingController {

    private final HousingRepository repository;

    public HousingController(HousingRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/housing")
    public String listAll() {
        List<Housing> listStudents = repository.findAll();
        System.out.println(listStudents);
        return "housingTest";
    }
}
