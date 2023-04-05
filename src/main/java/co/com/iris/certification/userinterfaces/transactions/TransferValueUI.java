package co.com.iris.certification.userinterfaces.transactions;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransferValueUI {
    public static final Target LABEL_WRONG_AMOUNT = Target.the("that the error label invalid amount,").located(By.cssSelector("div.invalid-feedback > a"));
    public static final Target TEXT_TRX_AMOUNT = Target.the("input to enter the transaction value").located(By.id("amount"));
    public static final Target LABEL_TEXT_AMOUNT = Target.the("the label that indicate to input amount").located(By.xpath("//h5[contains(text(),'Ingresar el valor')]"));

    private TransferValueUI(){

    }
}
