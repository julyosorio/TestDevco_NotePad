package co.com.iris.certification.userinterfaces.usermanagement.roles;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateNewRoleUI {
    public static final Target BTN_CREATE_NEW_ROLE = Target.the("button to create new role in the banking")
            .located(By.xpath("//h5[contains(text(),rol)]"));
    public static final Target TEXT_NAME_ROLE = Target.the("text to enter name role")
            .located(By.id("role-name"));
    public static final Target TEXT_DESCRIPTION_ROLE = Target.the("text to enter description role")
            .located(By.id("role-description"));

    public static final Target BTN_NEXT = Target.the("button to continue with the next page")
            .located(By.xpath("//button[contains(text(),'Siguiente')]"));

    public static final Target LABEL_MESSAGE_TITLE_CREATION_NEW_ROLE_SUCCESSFUL = Target.the("label with the message that indicates the new role was created successful")
            .located(By.xpath("//div[contains(text(),'Rol creado')]"));

    public static final Target LABEL_MESSAGE_CONTENT_CREATION_NEW_ROLE_SUCCESSFUL = Target.the("label with the message that indicates the new role was created successful")
            .located(By.xpath("//div[@role='alertdialog']"));

    private CreateNewRoleUI(){}
}
