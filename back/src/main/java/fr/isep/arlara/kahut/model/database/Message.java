package fr.isep.arlara.kahut.model.database;

import fr.isep.arlara.kahut.model.request.MessageReturn;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AppUser author;
    private LocalTime date;
    private String msg;

    public Message(AppUser author, LocalTime date, String msg){
        this.author = author;
        this.date = date;
        this.msg = msg;
    }

    public MessageReturn toMessageReturn() {
        return new MessageReturn(author.getFullName(),date,msg);
    }
}