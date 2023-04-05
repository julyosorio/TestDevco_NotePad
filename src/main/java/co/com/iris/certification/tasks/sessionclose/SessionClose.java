package co.com.iris.certification.tasks.sessionclose;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.BTN_CONFIRM_EXIT;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.BTN_INIT_EXIT;
import static co.com.iris.certification.userinterfaces.login.LoginUI.TEXT_USER_LOGIN;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SessionClose implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_INIT_EXIT, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(BTN_INIT_EXIT),
                WaitUntil.the(BTN_CONFIRM_EXIT, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(BTN_CONFIRM_EXIT),
                WaitUntil.the(TEXT_USER_LOGIN, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))
        );
    }

    public static SessionClose logout(){
        return Tasks.instrumented(SessionClose.class);
    }
}
