package co.com.iris.certification.tasks.transactions.vouchertransaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.transactions.TransactionSummaryUI.BTN_VOUCHER;
import static co.com.iris.certification.userinterfaces.transactions.TransactionSummaryUI.OPTLST_CHECK_VOUCHER;
import static co.com.iris.certification.userinterfaces.transactions.voucher.SuccessfulVoucherUI.LABEL_AMOUNT;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ShowInitialVoucher implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_VOUCHER, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(BTN_VOUCHER),
                Click.on(OPTLST_CHECK_VOUCHER),
                WaitUntil.the(LABEL_AMOUNT, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))
        );
    }
    public static ShowInitialVoucher goTo() {
        return Tasks.instrumented(ShowInitialVoucher.class);
    }
}
