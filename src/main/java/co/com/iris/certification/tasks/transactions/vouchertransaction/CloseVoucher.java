package co.com.iris.certification.tasks.transactions.vouchertransaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.iris.certification.userinterfaces.transactions.voucher.SuccessfulVoucherUI.BTN_CLOSE_VOUCHER;

public class CloseVoucher implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CLOSE_VOUCHER)
        );
    }
    public static CloseVoucher onClick(){
        return Tasks.instrumented(CloseVoucher.class);
    }
}
