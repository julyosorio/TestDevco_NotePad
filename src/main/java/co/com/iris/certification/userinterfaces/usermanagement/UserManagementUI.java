package co.com.iris.certification.userinterfaces.usermanagement;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserManagementUI {
    public static final Target BTN_ROLES_AND_LIMITS = Target.the("button to enter to roles and limits option")
            .located(By.xpath("//label[contains(text(),'Roles')]/parent::div"));
    public static final Target BTN_USER_PROFILE = Target.the("button to enter to user profile option")
            .located(By.xpath("//label[contains(text(),'Perfiles')]/parent::div"));

    private UserManagementUI(){}
}
