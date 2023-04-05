package co.com.iris.certification.userinterfaces.usermanagement.users;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TableUserProfileUI {
    public static final Target BTN_CREATE_NEW_USER = Target.the("button to create a new user in banking")
            .located(By.xpath("//button[contains(.,'Crear nuevo')]"));
    public static final Target ROW_TABLE_USER_PROFILE = Target.the("Row or record of the user profile table")
            .located(By.xpath("//table/tbody/tr"));
    public static final Target COL_NAME_USER = Target.the("column to show name user")
            .located(By.xpath("//tbody/tr/td[1]"));
    public static final Target COL_ROLE_USER = Target.the("column to show role user")
            .located(By.xpath("//tbody/tr/td[2]"));
    public static final Target COL_STATUS_USER = Target.the("column to show status user")
            .located(By.xpath("//tbody/tr/td[4]"));
    public static final Target LABEL_MESSAGE_TITLE_USER_CREATED = Target.the("label with the title of message that indicates the user was created successfully")
            .located(By.xpath("//div[contains(@aria-label,'Usuario invitado')]"));

    public static final Target LABEL_MESSAGE_CONTENT_USER_CREATED = Target.the("label with the content of message that indicates the user was created successfully")
            .located(By.xpath("//div[contains(text(),'Se ha enviado un correo electrónico al usuario')]"));
    private TableUserProfileUI(){
    }
}
