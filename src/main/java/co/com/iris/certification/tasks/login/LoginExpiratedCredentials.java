package co.com.iris.certification.tasks.login;

import co.com.iris.certification.models.login.LoginUsers;
import co.com.iris.certification.userinterfaces.login.LoginUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.login.LoginUI.*;
import static co.com.iris.certification.userinterfaces.passwordrecovery.ChangePasswordUI.TEXT_PASSWORD;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginExpiratedCredentials implements Task {

    private LoginUsers loginUsers;

    public LoginExpiratedCredentials(LoginUsers loginUsers){
        this.loginUsers = loginUsers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TEXT_NIT_LOGIN, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Enter.theValue(loginUsers.getNit()).into(TEXT_NIT_LOGIN),
                Enter.theValue(loginUsers.getUsername()).into(TEXT_USER_LOGIN),
                Enter.theValue(loginUsers.getExpiratedPass()).into(TEXT_PASSWORD_LOGIN),
                Click.on(LoginUI.BTN_NEXT_LOGIN),
                WaitUntil.the(TEXT_PASSWORD, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))
        );
    }
    public static LoginExpiratedCredentials with(LoginUsers loginUsers){
        return Tasks.instrumented(LoginExpiratedCredentials.class, loginUsers);
    }
}
