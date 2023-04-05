package co.com.iris.certification.userinterfaces.transactions.otherbanks;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OtherBanksUI {
    public static final Target BTN_NEXT_STEP = Target.the("button to push when all transaction data is filled").located(By.xpath("//button[contains(text(),'Siguiente')]"));
    private OtherBanksUI() {

    }
}
