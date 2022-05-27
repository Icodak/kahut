package fr.isep.arlara.kahut.model.database;

import fr.isep.arlara.kahut.model.request.UserRequest;
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
    private String city;
    private String description;
    private Integer bookmarkCount;
    private Float longitude;
    private Float latitude;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AppUser author;


    public Housing(String title, String city, String description, Float longitude, Float latitude,AppUser author) {
        this.title = title;
        this.city = city;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.author = author;
    }

    @OneToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<Image> images = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<Rating> ratings = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<Tag> tags = new ArrayList<>();

    public Double getStars() {
        return ratings.stream().filter(rating -> rating.getStars() != null).mapToDouble(Rating::getStars).sum();
    }

    public String getLocation() {
        return city + " : " + longitude + "; " + latitude;
    }


}