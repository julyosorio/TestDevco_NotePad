package co.com.iris.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SpinnerUI {
    public static final Target LOADSCREEN_SPINNER =Target.the("loading page")
            .located(By.id("spinner"));

    private SpinnerUI(){

    }
}
