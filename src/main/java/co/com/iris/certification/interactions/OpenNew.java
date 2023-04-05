package co.com.iris.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class OpenNew implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver webDriver = BrowseTheWeb.as(actor).getDriver();
        ((JavascriptExecutor)webDriver).executeScript("window.open()");
    }

    public static OpenNew tab(){
        return Tasks.instrumented(OpenNew.class);
    }
}
