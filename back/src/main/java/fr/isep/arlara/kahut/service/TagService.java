package fr.isep.arlara.kahut.service;

import fr.isep.arlara.kahut.model.Tag;

import java.util.List;

public interface TagService {
    Tag saveTag(Tag tag);

    List<Tag> listTag();
}
