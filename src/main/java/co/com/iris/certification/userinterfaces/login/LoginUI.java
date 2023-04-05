package co.com.iris.certification.userinterfaces.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {

    public static final Target TEXT_NIT_LOGIN = Target.the("field to enter nit").located(By.id("user-name"));
    public static final Target LINK_FORGOT_PASSWORD = Target.the("link forgot password").located(By.xpath("//a[contains(.,'Olvidaste')]"));
    public static final Target LABEL_CONFIRM_PASSWORD_CHANGE = Target.the("message that confirm the successful password change").located(By.xpath("//h6[contains(text(),'actualizada')]"));
    public static final Target LABEL_CONFIRM_PASSWORD_RENEWED = Target.the("message that confirm the password was renewed").located(By.xpath("//div[@role='alertdialog']"));
    public static final Target TEXT_USER_LOGIN = Target.the("input text user").located(By.id("account"));
    public static final Target TEXT_PASSWORD_LOGIN = Target.the("input text password").located(By.id("password"));
    public static final Target BTN_NEXT_LOGIN = Target.the("Next button").located(By.xpath("//button[@type='submit']"));

    private LoginUI(){}

}
