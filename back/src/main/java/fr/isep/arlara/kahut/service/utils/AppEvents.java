package fr.isep.arlara.kahut.service.utils;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.database.AppUserRole;
import fr.isep.arlara.kahut.repository.AppUserRepository;
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

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("hello world, I have just started up");
        AppUser adminAppUser = new AppUser("Admin", "ADMIN", "admin@kahut.com", bCryptPasswordEncoder.encode("password"), AppUserRole.ADMIN);
        AppUser userAppUser = new AppUser("User", "USER", "user@kahut.com", bCryptPasswordEncoder.encode("password"), AppUserRole.USER);
        appUserRepository.save(adminAppUser);
        appUserRepository.save(userAppUser);

    }
}
