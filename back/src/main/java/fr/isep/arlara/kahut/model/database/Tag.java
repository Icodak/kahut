package fr.isep.arlara.kahut.model.database;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    private TagType tagType;
    private Boolean isActive;
    private Integer lowLimit;
    private Integer highLimit;
    private Date startDate ;
    private Date endDate ;

}