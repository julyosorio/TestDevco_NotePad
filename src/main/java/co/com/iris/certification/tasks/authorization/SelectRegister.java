package co.com.iris.certification.tasks.authorization;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.authorization.MyAuthorizationsUI.ROW_CORRECT;
import static co.com.iris.certification.userinterfaces.transactions.voucher.SuccessfulVoucherUI.BTN_CLOSE_VOUCHER;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectRegister implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MoveMouse.to(ROW_CORRECT),
                Scroll.to(ROW_CORRECT),
                Click.on(ROW_CORRECT),
                WaitUntil.the(BTN_CLOSE_VOUCHER, isVisible()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    public static SelectRegister click() {
        return Tasks.instrumented(SelectRegister.class);
    }
}
