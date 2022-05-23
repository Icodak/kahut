package fr.isep.arlara.kahut.repository;

import fr.isep.arlara.kahut.model.database.Housing;
import fr.isep.arlara.kahut.model.request.QueryRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface HousingRepository extends JpaRepository<Housing, UUID> {
    @Query( value = "SELECT * FROM Housing h WHERE h.city = :city", nativeQuery = true)
    Optional<List<Housing>> findAllByRequest(
            @Param("city")
            String city
            //Date dateBack,
            //Date dateGo,
            // Integer numberTravellers
    );

    @Query( value = "SELECT first_name, last_name, bookmart_count, city, description, latitude, longitude, title FROM AppUser u INNER JOIN Housing h ON u.id = h.app_user_id WHERE email = :email", nativeQuery = true)
    Optional<List<Housing>> findHousingByUserId(
            @Param("email")
            String email
    );

}