package co.com.iris.certification.tasks.payments.paymentssaved;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.SPINNER;
import static co.com.iris.certification.userinterfaces.payments.paymentssaved.PaymentsSavedUI.COL_CREATE_DATE;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class OrderSavedPaymentsList implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(COL_CREATE_DATE, isPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(COL_CREATE_DATE),
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(COL_CREATE_DATE),
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds());
    }

    public static OrderSavedPaymentsList forFindTheCorrectRecord() {
        return Tasks.instrumented(OrderSavedPaymentsList.class);
    }
}
