package co.com.iris.certification.userinterfaces.payments;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentsAddedListUI {
    public static final Target BTN_OPTION_PAY_IN_LIST = Target.the("list with the button options for the payments added to the list")
            .located(By.id("dropdownOptions"));
    public static final Target BTN_DELETE_PAY_FROM_LIST = Target.the("button for delete the pay from payments list")
            .located(By.xpath("//div[contains(@class,'show')]/button[contains(.,'Eliminar')]"));

    private PaymentsAddedListUI(){}
}
