package fr.isep.arlara.kahut.model.database;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "appuser")
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String firstName;
    private String lastName;
    private String description;
    private String email;
    private String phone;
    private String password;
    private Boolean enabled = false;
    private Boolean locked = false;
    @Enumerated(EnumType.STRING)
    private AppUserRole role;

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

    public AppUser(String firstName, String lastName, String description, String email, String phone, String password, AppUserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);
    }

    public String getFullName(){
        return firstName + " " +  lastName;
    }

    //Email is used as username to ensure uniqueness
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}