package fr.isep.arlara.kahut.model.request;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ConversationResponse {
    UUID id;
    String title;
    String recipient;

}
