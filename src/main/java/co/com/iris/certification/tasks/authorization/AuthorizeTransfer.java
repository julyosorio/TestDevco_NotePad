package co.com.iris.certification.tasks.authorization;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.authorization.MyAuthorizationsUI.BTN_AUTHORIZE;
import static co.com.iris.certification.userinterfaces.authorization.MyAuthorizationsUI.BTN_AUTHORIZE_POP_UP;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class AuthorizeTransfer implements Task {

    private InfoTrx infoTrx;

    public AuthorizeTransfer(InfoTrx infoTrx){
        this.infoTrx=infoTrx;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOADSCREEN_SPINNER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(BTN_AUTHORIZE, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                MoveMouse.to(BTN_AUTHORIZE),
                Scroll.to(BTN_AUTHORIZE),
                Click.on(BTN_AUTHORIZE),
                Click.on(BTN_AUTHORIZE_POP_UP),
                WaitUntil.the(LOADSCREEN_SPINNER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
               //,GetOtp.byEmail(infoTrx.getEmailUser()),
               //SendCorrectOtp.with()
        );
    }

    public static AuthorizeTransfer fromTheRecordDetail(InfoTrx infoTrx){
        return Tasks.instrumented(AuthorizeTransfer.class,infoTrx);
    }
}
