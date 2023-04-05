package co.com.iris.certification.tasks.passwordrecovery;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.passwordrecovery.ChangePasswordUI.TEXT_PASSWORD;
import static co.com.iris.certification.userinterfaces.yopmail.YopMailUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfirmPasswordChange implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toFrame(FRM_INBOX.resolveFor(actor)),
                WaitUntil.the(LABEL_EMAIL_PASSWORD_RESET, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(LABEL_EMAIL_PASSWORD_RESET),
                Switch.toParentFrame(),
                Switch.toFrame(FRM_DETAIL_EMAIL.resolveFor(actor)),
                WaitUntil.the(BTN_RECOVERY_PASSWORD, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(BTN_RECOVERY_PASSWORD),
                Switch.toTheOtherWindow(),
                WaitUntil.the(TEXT_PASSWORD, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))
        );
    }

    public static ConfirmPasswordChange from(){
        return Tasks.instrumented(ConfirmPasswordChange.class);
    }
}
