package co.com.iris.certification.tasks.payments.paymentssaved;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.MENU_PAYMENTS;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.SPINNER;
import static co.com.iris.certification.userinterfaces.payments.PaymentOptionsUI.SAVED_PAYMENTS;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectPaymentsSavedOption implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(MENU_PAYMENTS),
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(SAVED_PAYMENTS, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(SAVED_PAYMENTS)
        );
    }

    public static SelectPaymentsSavedOption fromMainMenu(){
        return Tasks.instrumented(SelectPaymentsSavedOption.class);
    }
}
