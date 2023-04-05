package co.com.iris.certification.tasks.passwordrecovery;

import co.com.iris.certification.models.passwordrecovery.PasswordRecovery;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.login.LoginUI.LINK_FORGOT_PASSWORD;
import static co.com.iris.certification.userinterfaces.passwordrecovery.PasswordRecoveryUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RequestPasswordChangeFailed implements Task {

    private PasswordRecovery passwordRecovery;

    public RequestPasswordChangeFailed(PasswordRecovery passwordRecovery){
        this.passwordRecovery = passwordRecovery;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LINK_FORGOT_PASSWORD, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                DoubleClick.on(LINK_FORGOT_PASSWORD),
                Click.on(LINK_FORGOT_PASSWORD),
                WaitUntil.the(TEXT_NIT, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Enter.theValue(passwordRecovery.getNit()).into(TEXT_NIT),
                Enter.theValue(passwordRecovery.getDocumentUser()).into(TEXT_DOCUMENT),
                Enter.theValue(passwordRecovery.getUsername()).into(TEXT_USER),
                Enter.theValue(passwordRecovery.getEmail()).into(TEXT_EMAIL),
                Click.on(BTN_REQUEST_PASSWORD));
    }

    public static RequestPasswordChangeFailed with(PasswordRecovery passwordRecovery){
        return Tasks.instrumented(RequestPasswordChangeFailed.class,passwordRecovery);
    }
}
