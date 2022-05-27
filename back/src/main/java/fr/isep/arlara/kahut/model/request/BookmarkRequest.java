package fr.isep.arlara.kahut.model.request;

import fr.isep.arlara.kahut.model.database.Image;
import fr.isep.arlara.kahut.model.database.Rating;
import fr.isep.arlara.kahut.model.database.Tag;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BookmarkRequest {
    String housingId;
    String requester;
}
