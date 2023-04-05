package co.com.iris.certification.tasks.transactions.transactionhistory;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.MENU_TRX_HISTORY;
import static co.com.iris.certification.userinterfaces.transactionshistory.transactions.TransactionHistoryTableUI.COL_DATE_CREATE;
import static co.com.iris.certification.userinterfaces.transactionshistory.transactions.TransactionHistoryUI.BTN_CREATION_DATE_ORDER_DSCD;
import static co.com.iris.certification.utils.Constants.OTHER_BANKS;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class GoToTransactionHistoric implements Task {

    private InfoTrx infoTrx;
    private String typeTrx;

    public GoToTransactionHistoric(InfoTrx infoTrx, String typeTrx) {
        this.infoTrx = infoTrx;
        this.typeTrx = typeTrx;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!typeTrx.equalsIgnoreCase(OTHER_BANKS)) {
            infoTrx.setDestinationBank("Iris");
        }
        if(typeTrx.equals("Cuentas iris")){
            typeTrx = "Cuentas Iris";
        }
        actor.attemptsTo(
                WaitUntil.the(MENU_TRX_HISTORY,isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(MENU_TRX_HISTORY),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Applyfilters.transactionHistoryTable(infoTrx,typeTrx),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                MoveMouse.to(BTN_CREATION_DATE_ORDER_DSCD),
                Scroll.to(BTN_CREATION_DATE_ORDER_DSCD).andAlignToTop(),
                Click.on(BTN_CREATION_DATE_ORDER_DSCD),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Scroll.to(COL_DATE_CREATE)
        );
    }

    public static GoToTransactionHistoric forAppliesSearchFilters(InfoTrx infoTrx, String typeTrx) {
        return Tasks.instrumented(GoToTransactionHistoric.class, infoTrx, typeTrx);
    }
}
