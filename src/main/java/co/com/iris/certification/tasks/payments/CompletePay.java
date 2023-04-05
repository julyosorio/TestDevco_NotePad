package co.com.iris.certification.tasks.payments;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.payments.ManualPaymentUI.BTN_SEND_BATCH;
import static co.com.iris.certification.userinterfaces.payments.SuccessfulPayCompletedUI.LABEL_TOTAL_VALUE_PAY;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class CompletePay implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(LOADSCREEN_SPINNER.isVisibleFor(actor))
                        .andIfSo(WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()),
                Click.on(BTN_SEND_BATCH),
                WaitUntil.the(LABEL_TOTAL_VALUE_PAY, isPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    public static CompletePay byTotalValueEnteredInPayList() {
        return Tasks.instrumented(CompletePay.class);
    }
}
