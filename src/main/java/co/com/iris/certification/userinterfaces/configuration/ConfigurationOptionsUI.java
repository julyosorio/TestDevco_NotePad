package co.com.iris.certification.userinterfaces.configuration;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfigurationOptionsUI {

    public static final Target BTN_TAG_OPTION = Target.the("button to access to the tag option")
            .located(By.xpath("//label[contains(.,'Etiquetas')]/parent::div"));
}
