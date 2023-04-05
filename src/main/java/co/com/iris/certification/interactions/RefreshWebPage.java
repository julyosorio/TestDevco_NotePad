package co.com.iris.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class RefreshWebPage implements Task {
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.navigate().refresh();
    }
    
    public static RefreshWebPage refresh(){
        return Tasks.instrumented(RefreshWebPage.class);
    }
}
