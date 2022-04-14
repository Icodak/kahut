package fr.isep.arlara.kahut.repository;

import fr.isep.arlara.kahut.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
}