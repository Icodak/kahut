package fr.isep.arlara.kahut.repository;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.database.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, UUID> {

    @Query( value = "SELECT * FROM conversation c WHERE (c.sender_id = :sender AND c.recipient_id = :recipient) OR (c.sender_id = :recipient AND c.recipient_id = :sender) LIMIT 1", nativeQuery = true)
    Optional<Conversation> getByEmail(@Param("sender") AppUser sender, @Param("recipient") AppUser recipient );



}