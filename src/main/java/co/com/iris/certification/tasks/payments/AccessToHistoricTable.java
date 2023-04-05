package co.com.iris.certification.tasks.payments;

import co.com.iris.certification.userinterfaces.dashboard.DashboardUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.MENU_TRX_HISTORY;
import static co.com.iris.certification.userinterfaces.transactionshistory.HistoricTableUI.LINK_PAYMENTS_AND_BATCHES;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class AccessToHistoricTable implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MENU_TRX_HISTORY,isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(MENU_TRX_HISTORY),
                WaitUntil.the(LOADSCREEN_SPINNER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(LINK_PAYMENTS_AND_BATCHES,isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LINK_PAYMENTS_AND_BATCHES),
                WaitUntil.the(DashboardUI.WAIT_LOADER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    public static AccessToHistoricTable forLookForThePayDone() {
        return Tasks.instrumented(AccessToHistoricTable.class);
    }
}
