package fr.isep.arlara.kahut.service.utils;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.database.AppUserRole;
import fr.isep.arlara.kahut.model.database.Housing;
import fr.isep.arlara.kahut.model.database.Image;
import fr.isep.arlara.kahut.repository.AppUserRepository;
import fr.isep.arlara.kahut.repository.HousingRepository;
import fr.isep.arlara.kahut.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class AppEvents {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AppUserRepository appUserRepository;
    private final ImageRepository imageRepository;
    private final HousingRepository housingRepository;
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() throws IOException {
        AppUser adminAppUser = new AppUser("Admin", "ADMIN", null, "admin@kahut.com", "0174926592", bCryptPasswordEncoder.encode("password"), AppUserRole.ADMIN);
        AppUser userAppUser = new AppUser("User", "USER", "Hey, I'm a kahut user !", "user@kahut.com", "0649205739", bCryptPasswordEncoder.encode("password"), AppUserRole.USER);
        AppUser createdAdmin = appUserRepository.save(adminAppUser);
        AppUser createdUser = appUserRepository.save(userAppUser);
        appUserRepository.enableAppUser("admin@kahut.com");
        appUserRepository.enableAppUser("user@kahut.com");


       Image savedImg1 = new Image("titre",Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/back/src/main/resources/static/k1.jpg")));
       Image savedImg2 = new Image("titre",Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/back/src/main/resources/static/k2.jpg")));
       Image savedImg3 = new Image("titre",Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/back/src/main/resources/static/k3.jpg")));
       Image savedImg4 = new Image("titre",Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/back/src/main/resources/static/k4.jpg")));

        Housing housingParis = new Housing("Logement parisien", "Paris", "Beau logement en plein centre de paris",createdUser,List.of(savedImg1));
        Housing housingLyon = new Housing("Logement à Lyon", "Lyon", "Situé dans la ville des tacos français", createdAdmin,List.of(savedImg2));
        Housing housingTokyo = new Housing("Tokyo apartment", "Tokyo", "そろそろ日本語を見直す時期です", createdAdmin,List.of(savedImg3));
        Housing housingAlbi = new Housing("Logement au coeur de l'ancienne ville", "Albi", "Venez vivre au centre d'une des plus belles villes de France", createdUser,List.of(savedImg4));


        housingRepository.save(housingParis);
       housingRepository.save(housingAlbi);
       housingRepository.save(housingTokyo);
       housingRepository.save(housingLyon);





        System.out.println("Initialisation finished");

    }
}
