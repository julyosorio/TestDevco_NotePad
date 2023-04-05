package co.com.iris.certification.userinterfaces.usermanagement.roles;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SummaryCreateNewRoleUI {
    public static final Target BTN_CREATE_ROLE = Target.the("button to create the new role")
            .located(By.xpath("//button[contains(.,'Finalizar')]"));

    private SummaryCreateNewRoleUI(){}
}
