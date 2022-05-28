package fr.isep.arlara.kahut.model.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class MessageRequest {
    String author;
    String recipient;
    String message;
}
