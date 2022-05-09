package fr.isep.arlara.kahut.repository;

import fr.isep.arlara.kahut.model.database.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ImageRepository extends JpaRepository<Image, UUID> {
}