package co.com.iris.certification.userinterfaces.validateotp;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ValidateOtpUI {
    public static final Target LABEL_SELECTED_CHANNEL = Target.the("Text that indicate the selected channel to receive OTP code to execute a transaction").located(By.xpath("//b[contains(.,'correo')]"));
    public static final Target LINK_CHANGE_CHANNEL = Target.the("Link to change channel").located(By.xpath("//p[contains(.,'Cambiar')]"));
    public static final Target LABEL_SEND_CODE_BY_MAIL = Target.the("option to choose code by email").located(By.xpath("(//div[contains(@class,'option')])[2]"));
    public static final Target BTN_CONFIRM_CHANNEL = Target.the("button to confirm the channel changed").located(By.xpath("//button[contains(.,'Enviar')]"));
    public static final Target TEXT_OTP_CODE = Target.the("Field to enter OTP code").located(By.xpath("//input[@pattern]"));

    public static final Target LABEL_MSG_ERROR_OTP = Target.the("Error message by OTP ").located(By.xpath("//div[@role='alertdialog']"));
    public static final Target LABEL_MSG_ERROR_CREDENTIALS = Target.the("Error message by credentials ").located(By.xpath("//div[@class='row']/div/h6"));
    public static final Target LABEL_CANCEL = Target.the("Cancel OTP request").located(By.xpath("//div[@class='col text-center' ]/a[contains(text(),'Cancelar')]"));

    private ValidateOtpUI() {
    }


}
