package fr.isep.arlara.kahut.model.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class MessageReturn {
    String author;
    LocalTime date;
    String message;



    public String toJSON() {
        return "{\"author\":\""+author+"\",\"date\": \""+date+"\", \"message\":\""+message+"\"}";
    }
}
