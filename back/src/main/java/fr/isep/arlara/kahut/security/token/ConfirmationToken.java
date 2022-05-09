package fr.isep.arlara.kahut.security.token;

import fr.isep.arlara.kahut.model.database.AppUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="confirmation_token")
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private  LocalDateTime expiresAt;
    private  LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(nullable = false,name="app_user_id")
    private AppUser appUser;



    public ConfirmationToken(String token, LocalDateTime createdAt,LocalDateTime expiresAt, AppUser appUser){
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.appUser = appUser;
    }


}
