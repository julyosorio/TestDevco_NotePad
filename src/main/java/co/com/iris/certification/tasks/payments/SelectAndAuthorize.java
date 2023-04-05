package co.com.iris.certification.tasks.payments;

import co.com.iris.certification.models.transactions.Payment;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.authorization.MyAuthorizationsUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class SelectAndAuthorize implements Task {
    private Payment payment;

    public SelectAndAuthorize(Payment payment){
        this.payment=payment;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CHECK_SELECT),
                MoveMouse.to(BTN_AUTHORIZE_MAIN),
                Scroll.to(BTN_AUTHORIZE_MAIN),
                Click.on(BTN_AUTHORIZE_MAIN),
                Click.on(BTN_AUTHORIZE_POP_UP),
                WaitUntil.the(LOADSCREEN_SPINNER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
                //,GetOtp.byEmail(payment.getEmailUser()),
                //SendCorrectOtp.with()
        );
    }

    public static SelectAndAuthorize pendingPayment(Payment payment){
        return Tasks.instrumented(SelectAndAuthorize.class, payment);
    }

}
