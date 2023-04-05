package co.com.iris.certification.userinterfaces.irispay;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IrisPayUI {

    public static final Target BTN_NEW_COLLECTION_LINK = Target.the("button to open the form to create a new payment link")
            .located(By.xpath("//button[contains(.,'Crear nuevo link de cobro')]"));

    private IrisPayUI(){

    }
}
