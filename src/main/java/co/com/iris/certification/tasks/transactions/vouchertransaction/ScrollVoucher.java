package co.com.iris.certification.tasks.transactions.vouchertransaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.iris.certification.userinterfaces.transactions.voucher.SuccessfulVoucherUI.LABEL_AMOUNT;

public class ScrollVoucher implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MoveMouse.to(LABEL_AMOUNT),
                Scroll.to(LABEL_AMOUNT)
        );

    }
    public static ScrollVoucher goTo(){
        return Tasks.instrumented(ScrollVoucher.class);
    }
}
