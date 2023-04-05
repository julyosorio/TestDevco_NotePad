package co.com.iris.certification.tasks.payments;

import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.transactions.Payment;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.payments.ManualPaymentUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;


public class SelectOriginProduct implements Task {
    private Payment infoPay;

    public SelectOriginProduct(Payment infoPay) {
        this.infoPay = infoPay;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LIST_ORIGIN_ACCOUNT),
                SelectOption.fromList(OPTLST_ORIGIN_ACCOUNT, infoPay.getOriginAccountNumber()),
                Click.on(BTN_NEXT)
        );
    }

    public static SelectOriginProduct forExecutePayTransaction(Payment infoPay) {
        return Tasks.instrumented(SelectOriginProduct.class, infoPay);
    }
}
