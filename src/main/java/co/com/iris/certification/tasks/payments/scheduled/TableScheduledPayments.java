package co.com.iris.certification.tasks.payments.scheduled;

import co.com.iris.certification.models.transactions.Payment;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.payments.scheduledpayments.ScheduledPaymentsTableUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class TableScheduledPayments implements Task {
    private Payment payment;

    public TableScheduledPayments(Payment payment){
        this.payment=payment;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                WaitUntil.the(BTN_FILTERS, isClickable()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(BTN_FILTERS),
                Enter.theValue(payment.getPayId()).into(TEXT_PAYMENT_ID),
                Click.on(BTN_APPLY_FILTERS),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))
                );
    }
    public static TableScheduledPayments applyFilters(Payment payment){
        return Tasks.instrumented(TableScheduledPayments.class, payment);
    }
}
