package co.com.iris.certification.userinterfaces.yopmail;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class YopMailUI {
    public static final Target TEXT_EMAIL = Target.the("field to enter email").located(By.id("login"));
    public static final Target AMOUNT_MAILS = Target.the("field that shows the amount of mails received").located(By.id("nbmail"));
    public static final Target BTN_REFRESH = Target.the("button refresh page").located(By.id("refresh"));
    public static final Target FRM_INBOX = Target.the("frame to views the email box").located(By.id("ifinbox"));
    public static final Target FRM_DETAIL_EMAIL = Target.the("frame to shows the detail email").located(By.id("ifmail"));
    public static final Target LABEL_EMAIL_PASSWORD_RESET = Target.the("message received to change the password").located(By.xpath("(//div/button/div[contains(.,'Ha solicitado resetear la clave')])[1]"));
    public static final Target LABEL_EMAIL_OTP_CODE = Target.the("message received  with the otp code").located(By.xpath("(//div/button/div[contains(.,'Código de verificación')])[1]"));
    public static final Target BTN_RECOVERY_PASSWORD = Target.the("button to go to the change password page").located(By.xpath("//span[contains(text(),'Reiniciar')]"));
    public static final Target VALUE_OTP_CODE = Target.the("text that contains the otp code sent").located(By.xpath("(//span/span[@style])[1]"));
    public static final Target LABEL_EMAIL_SUBJETC = Target.the("label where the email subject is shown").located(By.xpath("//*[@class='lms']"));
    public static final Target LABEL_EMAIL_MESSAGE_BODY = Target.the("body of the message received to see the transaction voucher").located(By.xpath("//strong"));
    private YopMailUI(){

    }
}
