package fr.isep.arlara.kahut.service.utils;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.database.AppUserRole;
import fr.isep.arlara.kahut.model.database.Housing;
import fr.isep.arlara.kahut.repository.AppUserRepository;
import fr.isep.arlara.kahut.repository.HousingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AppEvents {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AppUserRepository appUserRepository;
    private final HousingRepository housingRepository;
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        AppUser adminAppUser = new AppUser("Admin", "ADMIN", null, "admin@kahut.com", "0174926592", bCryptPasswordEncoder.encode("password"), AppUserRole.ADMIN);
        AppUser userAppUser = new AppUser("User", "USER", "Hey, I'm a kahut user !", "user@kahut.com", "0649205739", bCryptPasswordEncoder.encode("password"), AppUserRole.USER);
        appUserRepository.save(adminAppUser);
        appUserRepository.save(userAppUser);
        appUserRepository.enableAppUser("admin@kahut.com");
        appUserRepository.enableAppUser("user@kahut.com");

        Housing housingParis = new Housing("Génial logement", "Paris", "genial", 125.22f, 122.1212f);
        Housing housingLyon = new Housing("Génial logement", "Lyon", "genial", 125.22f, 122.1212f);
        Housing housingTokyo = new Housing("Génial logement", "Tokyo", "genial", 125.22f, 122.1212f);
        Housing housingAlbi = new Housing("Génial logement", "Albi", "genial", 125.22f, 122.1212f);
        Housing housingBordeaux = new Housing("Génial logement", "Bordeaux", "genial", 125.22f, 122.1212f);

        housingRepository.save(housingBordeaux);
        housingRepository.save(housingParis);
        housingRepository.save(housingAlbi);
        housingRepository.save(housingTokyo);
        housingRepository.save(housingLyon);


        System.out.println("Initialisation finished");

    }
}
