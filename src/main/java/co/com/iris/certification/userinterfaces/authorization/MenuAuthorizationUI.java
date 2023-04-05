package co.com.iris.certification.userinterfaces.authorization;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuAuthorizationUI {

    public static final Target MENU_MY_AUTHORIZATIONS = Target.the("menu to go to the table my authorizations")
            .located(By.xpath("//ul/li[contains(.,'Mis autorizaciones')]"));

    private MenuAuthorizationUI(){

    }
}
