package co.com.iris.certification.models.login;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginUsers {

    private String nit;
    private String username;
    private String password;
    private String email;
    private String otp;
    private String expiratedPass;
    private String newPass;
}
