package co.com.iris.certification.userinterfaces.payments;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PayWithPendingAuthorizationUI {
    public static final Target LABEL_PENDING_MESSAGE_PAY = Target.the("label with title of message pending pay by authorization")
            .located(By.xpath("//h5[@class[contains(.,'transfer-success')]]"));
    public static final Target LABEL_TOTAL_VALUE_PAY = Target.the("label with total value pending authorization pay")
            .located(By.xpath("//b[contains(.,'$')]/parent::p"));
    private PayWithPendingAuthorizationUI(){}
}
