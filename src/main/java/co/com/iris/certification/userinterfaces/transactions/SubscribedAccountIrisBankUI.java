package co.com.iris.certification.userinterfaces.transactions;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SubscribedAccountIrisBankUI {
    public static final Target TEXT_ACCOUNT_NUMBER = Target.the("field to enter the number account for account that requieres subscribe")
            .located(By.xpath("//input[@formcontrolname='accountId']"));
    public static final Target BTN_VALIDATE_ACCOUNT = Target.the("button to validate the number account entered")
            .located(By.xpath("//button[contains(.,'Validar')]"));
    public static final Target TEXT_EMAIL_SUBSCRIBED_ACCOUNT = Target.the("field to enter email of account to be subscribed")
            .located(By.xpath("//input[@formcontrolname='email']"));
    public static final Target TEXT_DESCRIPTION_SUBSCRIBED_ACCOUNT = Target.the("field to enter account description of account to be subscribed")
            .located(By.id("details"));
    public static final Target RADIO_SAVE_SUSCRIBED_ACCOUNT = Target.the("option to indicate that must to save the information account's entered in this form as a suscribed account")
            .located(By.xpath("(//span[@class='c-switch-slider'])[1]"));
    public static final Target BTN_COMPLETE_SUBSCRIPTION_ACCOUNT = Target.the("button to save the information of a new destination account")
            .located(By.xpath("//button[contains(.,'Finalizar')]"));

    public static final Target LABEL_POP_UP_MESSAGE_TITLE = Target.the("Text in the pop-up with the title of the message")
            .located(By.xpath("//div[@class='ng-tns-c14-0 toast-title ng-star-inserted']"));
    public static final Target LABEL_POP_UP_MESSAGE_BODY = Target.the("Text in the pop-up with the body of the message")
            .located(By.xpath("//div[@class='ng-tns-c14-0 toast-message ng-star-inserted']"));

    private SubscribedAccountIrisBankUI(){}
}
