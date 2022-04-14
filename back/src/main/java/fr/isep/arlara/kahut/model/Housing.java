package fr.isep.arlara.kahut.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.*;

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
    private Float longitude;
    private Float latitude;


    @OneToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<Image> images = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<Rating> ratings = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<Tag> tags = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private Map<LocalTime, AppUser> calendar = new TreeMap<>();

}