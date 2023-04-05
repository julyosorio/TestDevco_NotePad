package co.com.iris.certification.tasks.configuration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.configuration.ConfigurationOptionsUI.BTN_TAG_OPTION;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.MENU_CONFIGURATION;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.SPINNER;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SelectTagOption implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(MENU_CONFIGURATION, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(MENU_CONFIGURATION),
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(BTN_TAG_OPTION,isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_TAG_OPTION)
        );
    }

    public static SelectTagOption fromConfigurationMenu(){
        return Tasks.instrumented(SelectTagOption.class);
    }
}
