package fr.isep.arlara.kahut.model.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;


@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class QueryRequest {
    private String destination ;
    private Date dateGo ;
    private Date dateBack ;
    private Integer numberTravellers;


}
