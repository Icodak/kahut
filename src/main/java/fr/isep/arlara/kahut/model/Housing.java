package fr.isep.arlara.kahut.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor

@Entity
@Table(name = "housing")
public class Housing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String title;
    private String description;
    private Integer bookmarkCount;

    @OneToMany
    private List<Image> images = new ArrayList<>();
    @OneToMany
    private List<Rating> ratings = new ArrayList<>();
    @OneToMany
    private List<Tag> tags = new ArrayList<>();



//TODO implement location
    //TODO implement calendar


}