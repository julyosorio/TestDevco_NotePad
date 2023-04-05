package co.com.iris.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.SPINNER;
import static co.com.iris.certification.userinterfaces.payments.ManualPaymentUI.BTN_SAVE_PAY;
import static co.com.iris.certification.userinterfaces.payments.SuccessfulPaySavedUI.LABEL_WITH_CONTENT_OF_MESSAGE_ABOUT_PAY_SAVED_SUCCESSFULL;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class SavePaymentChanges implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_SAVE_PAY),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Scroll.to(LABEL_WITH_CONTENT_OF_MESSAGE_ABOUT_PAY_SAVED_SUCCESSFULL)
        );
    }
    public static SavePaymentChanges forCompletePayEdition(){
        return Tasks.instrumented(SavePaymentChanges.class);
    }
}
