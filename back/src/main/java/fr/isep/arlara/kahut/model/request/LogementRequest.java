package fr.isep.arlara.kahut.model.request;

import fr.isep.arlara.kahut.model.database.Image;
import fr.isep.arlara.kahut.model.database.Rating;
import fr.isep.arlara.kahut.model.database.Tag;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LogementRequest {
    String title;
    String description;
    List<Image> images;
    UserRequest author;
    List<Tag> tags;
    Double stars;
    String location;
    List<Rating> lastRatings;
}
