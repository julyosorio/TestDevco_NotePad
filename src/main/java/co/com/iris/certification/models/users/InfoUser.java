package co.com.iris.certification.models.users;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InfoUser {

    private String nameUser;
    private String lastnameUser;
    private String documentType;
    private String documentNumber;
    private String cellphone;
    private String emailNewUser;
    private String role;
    private String updateRole;
}
