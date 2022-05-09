package fr.isep.arlara.kahut.service.data;

import fr.isep.arlara.kahut.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {


    private final ImageRepository repository;

}
