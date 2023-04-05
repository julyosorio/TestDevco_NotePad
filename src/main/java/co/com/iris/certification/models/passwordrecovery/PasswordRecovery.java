package co.com.iris.certification.models.passwordrecovery;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PasswordRecovery {

    private String nit;
    private String documentUser;
    private String username;
    private String email;
    private String password;
    private String scenario;
}
