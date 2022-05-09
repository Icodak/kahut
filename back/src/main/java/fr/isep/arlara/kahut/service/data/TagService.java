package fr.isep.arlara.kahut.service.data;


import fr.isep.arlara.kahut.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {


    private final TagRepository repository;

}
