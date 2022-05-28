package fr.isep.arlara.kahut.model.database;

import fr.isep.arlara.kahut.model.request.ConversationReturn;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "conversation")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String title;
    @OneToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<Message> messages = new ArrayList<>();

    @ManyToOne
    private AppUser sender;

    @ManyToOne
    private AppUser recipient;

    public Conversation(String title, AppUser sender, AppUser recipient){
        this.title = title;
        this.sender = sender;
        this.recipient = recipient;
    }

    public ConversationReturn toConversationRequest() {
        return new ConversationReturn(
                sender.getFullName(),
                recipient.getFullName(),
                messages.stream().map(Message::toMessageReturn).collect(Collectors.toList()));
    }
}
