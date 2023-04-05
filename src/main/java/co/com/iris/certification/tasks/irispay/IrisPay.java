package co.com.iris.certification.tasks.irispay;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.MENU_IRISPAY;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class IrisPay implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOADSCREEN_SPINNER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(MENU_IRISPAY,isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(MENU_IRISPAY),
                WaitUntil.the(LOADSCREEN_SPINNER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }
    public static IrisPay goToMenu(){
        return Tasks.instrumented(IrisPay.class);
    }

}
