package fr.isep.arlara.kahut.model.database;

import fr.isep.arlara.kahut.model.request.LogementRequest;
import fr.isep.arlara.kahut.model.request.QueryResponse;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.ArrayList;
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
    private String city;
    private String description;
    private Boolean isReserved = false;

    @ManyToMany
    @JoinColumn(name = "bookmarks_id", table = "housing_appuser")
    @ToString.Exclude
    private List<AppUser> bookmarks;
    private Float longitude;
    private Float latitude;

    @JoinColumn(name = "author_id")
    @ManyToOne(cascade = {CascadeType.ALL})
    private AppUser author;


    public Housing(String title, String city, String description, Float longitude, Float latitude, AppUser author) {
        this.title = title;
        this.city = city;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.author = author;
    }

    @RestResource(exported = false)
    @OneToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<Image> images = new ArrayList<>();

    @RestResource(exported = false)
    @OneToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<Rating> ratings = new ArrayList<>();

    @RestResource(exported = false)
    @OneToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<Tag> tags = new ArrayList<>();

    public Double getStars() {
        return ratings.stream().filter(rating -> rating.getStars() != null).mapToDouble(Rating::getStars).sum();
    }

    public String getLocation() {
        return city;
    }


    public LogementRequest toLogementRequest() {
        return new LogementRequest(title, description, images, author.toUserRequest(), tags, getStars(), getLocation(), ratings,isReserved);
    }

    public QueryResponse toQueryResponse() {
        return new QueryResponse(title,description,images,author.toUserRequest(),getStars(),getLocation());
    }
}