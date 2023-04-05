package co.com.iris.certification.tasks.transactions;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.transactions.TransactionSummaryUI.BTN_EXECUTE_TRANSACTION;
import static co.com.iris.certification.userinterfaces.transactions.TransactionSummaryUI.LABEL_SUCCESSFUL_TRANSACTION;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Execute implements Task {

    private InfoTrx infoTrx;

    public Execute(InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(LOADSCREEN_SPINNER.isVisibleFor(actor))
                        .andIfSo(WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds())
                        .otherwise(WaitUntil.the(BTN_EXECUTE_TRANSACTION, isVisible()).forNoMoreThan(WAITING_TIME).seconds()),
                Scroll.to(BTN_EXECUTE_TRANSACTION),
                Click.on(BTN_EXECUTE_TRANSACTION),
                // GetOtp.byEmail(infoTrx.getEmailUser()),
                // SendCorrectOtp.with(),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(LABEL_SUCCESSFUL_TRANSACTION, isVisible()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    public static Execute theTransaction(InfoTrx infoTrx) {
        return Tasks.instrumented(Execute.class, infoTrx);
    }
}
