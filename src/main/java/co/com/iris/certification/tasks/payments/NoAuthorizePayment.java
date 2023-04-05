package co.com.iris.certification.tasks.payments;

import co.com.iris.certification.models.transactions.Payment;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.authorization.MyAuthorizationsUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class NoAuthorizePayment implements Task {
    private Payment payment;

    public NoAuthorizePayment(Payment payment){
        this.payment=payment;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOADSCREEN_SPINNER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(BTN_NO_AUTHORIZE, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                MoveMouse.to(BTN_NO_AUTHORIZE),
                Scroll.to(BTN_NO_AUTHORIZE),
                Click.on(BTN_NO_AUTHORIZE),
                Enter.theValue("No autorizado por automatizacion").into(TEXT_REASON),
                Click.on(BTN_NO_AUTHORIZE_POP_UP),
                WaitUntil.the(LOADSCREEN_SPINNER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
                //,GetOtp.byEmail(infoTrx.getEmailUser()),
                //SendCorrectOtp.with()
        );
    }

    public static NoAuthorizePayment fromTableDetailMyAuthorizations (Payment payment){
        return Tasks.instrumented(NoAuthorizePayment.class, payment);
    }
}
