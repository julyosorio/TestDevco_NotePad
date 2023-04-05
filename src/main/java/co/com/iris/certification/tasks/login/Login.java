package co.com.iris.certification.tasks.login;

import co.com.iris.certification.models.login.LoginUsers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.SPINNER;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.WAIT_LOADER;
import static co.com.iris.certification.userinterfaces.login.LoginUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class Login implements Task {

    private LoginUsers loginUsers;

    public Login(LoginUsers loginUsers) {
        this.loginUsers = loginUsers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(WAIT_LOADER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(TEXT_NIT_LOGIN, isPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Enter.theValue(loginUsers.getNit()).into(TEXT_NIT_LOGIN),
                Enter.theValue(loginUsers.getUsername()).into(TEXT_USER_LOGIN),
                Enter.theValue(loginUsers.getPassword()).into(TEXT_PASSWORD_LOGIN),
                Click.on(BTN_NEXT_LOGIN),
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    public static Login withCredencials(LoginUsers loginUsers) {
        return Tasks.instrumented(Login.class, loginUsers);
    }
}
