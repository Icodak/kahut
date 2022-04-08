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
@Table(name = "users")
public class Users {
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

    @OneToMany
    @ToString.Exclude
    private List<Housing> housingsForRent = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Housing> rentedHousings = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Housing> bookmark = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    private List<Message> sentMessages;

    @OneToMany
    @ToString.Exclude
    private List<Message> backMessages;


}