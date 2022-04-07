package fr.isep.arlara.kahut.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private Boolean isActive;
    private Integer lowLimit;
    private Integer highLimit;


}