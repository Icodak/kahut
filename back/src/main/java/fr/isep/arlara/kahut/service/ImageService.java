package fr.isep.arlara.kahut.service;

import fr.isep.arlara.kahut.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private ImageRepository repository;

}
