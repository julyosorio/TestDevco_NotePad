package co.com.iris.certification.userinterfaces.authorization;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DetailRegisterMyAuthorizationsUI {

    public static final Target LABEL_ORIGIN_ACCOUNT = Target.the("").located(By.xpath("//small[contains(.,'Producto')]//following-sibling::h6"));
    public static final Target LABEL_DESTINATION_BANK = Target.the("").located(By.xpath("//small[contains(.,'Banco destino')]//following-sibling::h6"));
    public static final Target LABEL_DESTINATION_ACCOUNT = Target.the("").located(By.xpath("//small[contains(.,'Número de cuenta')]//following-sibling::h6"));

    private DetailRegisterMyAuthorizationsUI(){

    }
}
