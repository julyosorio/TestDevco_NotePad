package co.com.iris.certification.tasks.login;

import co.com.iris.certification.models.login.LoginUsers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.passwordrecovery.ChangePasswordUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RenewPass implements Task {

    private LoginUsers loginUsers;

    public RenewPass(LoginUsers loginUsers){
        this.loginUsers = loginUsers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TEXT_PASSWORD, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Enter.theValue(loginUsers.getNewPass()).into(TEXT_PASSWORD),
                Enter.theValue(loginUsers.getNewPass()).into(TEXT_CONFIRM_PASSWORD),
                Click.on(BTN_SAVE_NEW_PASSWORD)
        );
        actor.remember("newPass", loginUsers.getNewPass());
    }

    public static RenewPass with(LoginUsers loginUsers){
        return Tasks.instrumented(RenewPass.class, loginUsers);
    }
}
