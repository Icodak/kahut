package fr.isep.arlara.kahut.service.registration;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.database.AppUserRole;
import fr.isep.arlara.kahut.model.request.RegistrationRequest;
import fr.isep.arlara.kahut.security.token.ConfirmationToken;
import fr.isep.arlara.kahut.security.token.ConfirmationTokenService;
import fr.isep.arlara.kahut.service.data.AppUserService;
import fr.isep.arlara.kahut.service.utils.UtilsService;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final ConfirmationTokenService confirmationTokenService;


    public String register(RegistrationRequest request) throws MessagingException {

        boolean isValidEmail = EmailValidator.getInstance().isValid(request.getEmail());
        if (!isValidEmail) throw new IllegalStateException("Email not valid");
        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }

    @Transactional
    public String confirmToken(String token){
        if (!UtilsService.isValidUUID(token)) throw new IllegalStateException("Invalid Token format");
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token).orElseThrow(()-> new IllegalStateException("Token not found"));
        if (confirmationToken.getConfirmedAt() != null) throw  new IllegalStateException("Email already confirmed");
        LocalDateTime expiresAt = confirmationToken.getExpiresAt();
        if (expiresAt.isBefore((LocalDateTime.now()))) throw new IllegalStateException("Token expired");
        confirmationToken.setConfirmedAt(LocalDateTime.now());
        appUserService.enableAppUser(confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }


}
