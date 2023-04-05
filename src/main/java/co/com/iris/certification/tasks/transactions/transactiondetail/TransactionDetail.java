package co.com.iris.certification.tasks.transactions.transactiondetail;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.BTN_TRANSACTION_DETAIL;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.MENU_SUMMARY;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TransactionDetail implements Task {
    private InfoTrx infoTrx;

    public TransactionDetail(InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MENU_SUMMARY, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Scroll.to(MENU_SUMMARY),
                Click.on(MENU_SUMMARY),
                WaitUntil.the(BTN_TRANSACTION_DETAIL, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Scroll.to(BTN_TRANSACTION_DETAIL),
                Click.on(BTN_TRANSACTION_DETAIL),
                SearchFilterTransactionDetail.withDetails(infoTrx),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))
        );
    }

    public static TransactionDetail goTo(InfoTrx infoTrx) {
        return Tasks.instrumented(TransactionDetail.class, infoTrx);
    }
}
