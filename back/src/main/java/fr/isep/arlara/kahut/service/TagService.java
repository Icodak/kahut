package fr.isep.arlara.kahut.service;


import fr.isep.arlara.kahut.model.Tag;
import fr.isep.arlara.kahut.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository repository;

}
