package fr.isep.arlara.kahut.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "appuser")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String firstName;
    private String lastName;
    private String description;
    private String email;
    //TODO implement password encryption
    private String password;
    private Boolean enabled;

    @OneToMany
    @ToString.Exclude
    private List<Housing> housingsToBook = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Housing> bookedHousings = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Housing> pendingBook = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Housing> bookmark = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Conversation> conversations = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Message> messages = new ArrayList<>();


}