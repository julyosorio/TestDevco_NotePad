package co.com.iris.certification.userinterfaces.payments;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SuccessfulPayCompletedUI {
    public static final Target LABEL_SUCCESS_MESSAGE_PAY = Target.the("label with success message of pay")
            .located(By.xpath("//h5[@class[contains(.,'transfer-success')]]"));
    public static final Target LABEL_TOTAL_VALUE_PAY = Target.the("label with total value pay")
            .located(By.xpath("//b[contains(.,'$')]"));
    public static final Target LABEL_TOTAL_VALUE_SCHEDULED_PAY = Target.the("label with total value pay")
            .located(By.xpath("//b[contains(.,'$')]/parent::p"));

    public static final Target BTN_GO_HISTORIC_PAYMENTS_AND_BATCHES_TABLE = Target.the("redirecting button to payments and batches historic table")
            .located(By.xpath("//button[contains(.,'lote en proceso')]"));

    private SuccessfulPayCompletedUI(){}
}
