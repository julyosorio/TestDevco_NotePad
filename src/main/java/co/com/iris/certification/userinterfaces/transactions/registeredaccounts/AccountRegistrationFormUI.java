package co.com.iris.certification.userinterfaces.transactions.registeredaccounts;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccountRegistrationFormUI {

    public static final Target BTN_IRIS_ACCOUNT = Target.the("button to go to the iris account registration form").located(By.xpath("//button[contains(.,'Cuentas Iris')]"));
    public static final Target BTN_OTHER_BANKS = Target.the("button to go to the other banks registration form").located(By.xpath("//button[contains(.,'Otros bancos')]"));

private AccountRegistrationFormUI(){

}


}

