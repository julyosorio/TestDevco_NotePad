package co.com.iris.certification.models.roles;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InfoRole {

    private String roleName;
    private String roleDescription;
    private String productsList;
    private String complementsList;
    private String permitsGroupsList;
    private String emailUser;
}
