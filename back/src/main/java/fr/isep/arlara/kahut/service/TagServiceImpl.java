package fr.isep.arlara.kahut.service;


import fr.isep.arlara.kahut.model.Tag;
import fr.isep.arlara.kahut.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository repository;

    @Override
    public Tag saveTag(Tag tag){
        return repository.save(tag);
    }

    @Override
    public List<Tag> listTag() {
        return repository.findAll();
    }


}
