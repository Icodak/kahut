package fr.isep.arlara.kahut.repository;

import fr.isep.arlara.kahut.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {
}