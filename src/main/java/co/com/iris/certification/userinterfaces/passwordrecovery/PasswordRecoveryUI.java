package co.com.iris.certification.userinterfaces.passwordrecovery;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PasswordRecoveryUI {

    public static final Target TEXT_NIT = Target.the("input nit").located(By.id("nit"));

    public static final Target TEXT_DOCUMENT = Target.the("input document").located(By.id("documentId"));

    public static final Target TEXT_USER = Target.the("input user").located(By.id("username"));

    public static final Target TEXT_EMAIL = Target.the("input email").located(By.id("email"));

    public static final Target BTN_REQUEST_PASSWORD = Target.the("button that send the link for recovery password").located(By.xpath("//button[contains(.,'Siguiente')]"));

    public static final Target LABEL_EMAIL_SEND = Target.the("message popup that confirm the email has been send").located(By.id("toast-container"));

    public static final Target LABEL_MESSAGE_RECOVERY_PASSWORD = Target.the("message that confirm the email has been send").located(By.tagName("h5"));

    public static final Target LABEL_MESSAGE_ERROR = Target.the("message that show general error").located(By.xpath("//div[@role='alertdialog']"));

    public static final Target LABEL_MESSAGE_ERROR_FIELD = Target.the("message that show error below of each field").located(By.cssSelector("div.invalid-feedback"));
    private PasswordRecoveryUI(){

    }
}
