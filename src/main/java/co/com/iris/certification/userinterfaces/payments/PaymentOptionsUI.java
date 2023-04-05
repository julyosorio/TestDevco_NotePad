package co.com.iris.certification.userinterfaces.payments;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentOptionsUI {
    public static final Target MANUAL_PAYMENT = Target.the("option manual payment of payment menu")
            .located(By.xpath("//label[contains(.,'manuales')]/parent::div"));

    public static final Target PAYMENT_IN_BATCH = Target.the("option payment in batch of payment menu")
            .located(By.xpath("//label[contains(.,'lote')]/parent::div"));
    public static final Target SAVED_PAYMENTS = Target.the("option saved payments of payment menu")
            .located(By.xpath("//label[contains(.,'guardados')]/parent::div"));

    private PaymentOptionsUI(){}
}
