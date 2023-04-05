package co.com.iris.certification.userinterfaces.payments;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SuccessfulPaySavedUI {
    public static final Target LABEL_WITH_TITLE_OF_MESSAGE_ABOUT_PAY_SAVED_SUCCESSFULL = Target.the("label with title message of pay saved successfull")
            .located(By.xpath("//h5[@class[contains(.,'transfer-success')]]"));
    public static final Target LABEL_WITH_CONTENT_OF_MESSAGE_ABOUT_PAY_SAVED_SUCCESSFULL = Target.the("label with description message of pay saved successfull")
            .located(By.xpath("//p[contains(.,'Puedes acceder y completar tu pago')]"));

    private SuccessfulPaySavedUI(){}
}
