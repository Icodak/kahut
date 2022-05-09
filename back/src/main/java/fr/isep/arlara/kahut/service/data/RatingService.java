package fr.isep.arlara.kahut.service.data;

import fr.isep.arlara.kahut.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingService {


    private final RatingRepository repository;

}
