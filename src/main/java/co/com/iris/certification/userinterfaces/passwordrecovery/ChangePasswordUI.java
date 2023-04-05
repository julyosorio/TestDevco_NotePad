package co.com.iris.certification.userinterfaces.passwordrecovery;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ChangePasswordUI {

    public static final Target TEXT_USERNAME = Target.the("field to enter the username").located(By.xpath("//input[@type='email']"));
    public static final Target TEXT_PASSWORD = Target.the("field to enter the new password").located(By.id("password-new"));
    public static final Target TEXT_CONFIRM_PASSWORD = Target.the("field to confirm the new password").located(By.id("confirm-password"));
    public static final Target BTN_SAVE_NEW_PASSWORD = Target.the("button to save the new password").located(By.tagName("button"));

    public static final Target LABEL_FIELD_PASSWORD_NEW = Target.the("message that shows label for renew password").located(By.xpath("//label[@for='password-new']"));

    public static final Target LABEL_FIELD_CONFIRM_PASSWORD = Target.the("message that shows label for confirm renew password").located(By.xpath("//label[@for='confirm-password']"));

    private ChangePasswordUI(){
    }
}
