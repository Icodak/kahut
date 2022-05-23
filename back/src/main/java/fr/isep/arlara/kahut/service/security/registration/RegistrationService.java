package fr.isep.arlara.kahut.service.security.registration;

import fr.isep.arlara.kahut.model.database.AppUser;
import fr.isep.arlara.kahut.model.database.AppUserRole;
import fr.isep.arlara.kahut.model.database.ConfirmationToken;
import fr.isep.arlara.kahut.model.request.RegistrationRequest;
import fr.isep.arlara.kahut.service.data.AppUserService;
import fr.isep.arlara.kahut.service.utils.KahutUtils;
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
        System.out.println(request);
        if (!isValidEmail) throw new IllegalStateException("Email not valid");
        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getDescription(),
                        request.getEmail(),
                        request.getPhone(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }

    @Transactional
    public String confirmToken(String token){
        if (!KahutUtils.isValidUUID(token)) throw new IllegalStateException("Invalid Token format");
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token).orElseThrow(()-> new IllegalStateException("Token not found"));
        if (confirmationToken.getConfirmedAt() != null) throw  new IllegalStateException("Email already confirmed");
        LocalDateTime expiresAt = confirmationToken.getExpiresAt();
        if (expiresAt.isBefore((LocalDateTime.now()))) throw new IllegalStateException("Token expired");
        confirmationToken.setConfirmedAt(LocalDateTime.now());
        appUserService.enableAppUser(confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }


}
