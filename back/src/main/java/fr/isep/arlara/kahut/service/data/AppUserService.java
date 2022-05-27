package fr.isep.arlara.kahut.service.data;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.database.ConfirmationToken;
import fr.isep.arlara.kahut.model.database.Housing;
import fr.isep.arlara.kahut.model.request.UserRequest;
import fr.isep.arlara.kahut.repository.AppUserRepository;
import fr.isep.arlara.kahut.repository.ConfirmationTokenRepository;
import fr.isep.arlara.kahut.repository.HousingRepository;
import fr.isep.arlara.kahut.service.security.registration.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {

    private final HousingRepository housingRepository;

    private final static String USER_NOT_FOUND = "User with email %s not found";


    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final EmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }

    public String signUpUser(AppUser appUser) throws MessagingException {
        if (appUserRepository.findByEmail(appUser.getEmail()).isPresent())
            throw new IllegalStateException("Email already taken");
        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();
        int CONFIRMATION_TOKEN_EXPIRATION_DELAY = 15;
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(CONFIRMATION_TOKEN_EXPIRATION_DELAY), appUser
        );
        confirmationTokenRepository.save(confirmationToken);

        emailService.sendConfirmationEmailWithToken(appUser.getEmail(), appUser.getFirstName(),token);

        return token;
    }

    public void enableAppUser(String email) {
        appUserRepository.enableAppUser(email);
    }

    public ResponseEntity<List<Housing>> findUserHousing(UserRequest request) {
        Optional<List<Housing>> housingList = housingRepository.findHousingByUserId(
                request.getEmail()
        );
        return ResponseEntity.of(housingList);
    }


}
