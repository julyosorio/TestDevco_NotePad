package co.com.iris.certification.tasks.transactions.transactionhistory;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.transactions.voucher.SuccessfulVoucherUI.BTN_CLOSE_VOUCHER;
import static co.com.iris.certification.userinterfaces.transactionshistory.transactions.TransactionHistoryTableUI.*;
import static co.com.iris.certification.utils.Constants.DATE_CURRENT;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class SelectTheRegisterCorrect implements Task {

    private InfoTrx infoTrx;
    private String typeTrx;

    public SelectTheRegisterCorrect(InfoTrx infoTrx, String typeTrx) {
        this.infoTrx = infoTrx;
        this.typeTrx = typeTrx;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String amountTable = COL_AMOUNT_TRANSACTION.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", "");

        actor.attemptsTo(
                Check.whether(isCorrectRow(actor, DATE_CURRENT,amountTable)
                ).andIfSo(
                        WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                        MoveMouse.to(ROW_TRANSACTION_HISTORY_TABLE),
                        Scroll.to(ROW_TRANSACTION_HISTORY_TABLE),
                        Click.on(ROW_TRANSACTION_HISTORY_TABLE),
                        WaitUntil.the(BTN_CLOSE_VOUCHER, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))
                )
        );
    }

    private <T extends Actor> boolean isCorrectRow
            (T actor, String voucherDate, String amountTable) {
        return isCorrectDate(actor, voucherDate)
                && isCorrectTransactionData(actor, amountTable);
    }

    private <T extends Actor> boolean isCorrectDate(T actor, String voucherDate) {
        return COL_DATE_CREATE.resolveFor(actor).getText().startsWith(voucherDate);
    }

    private <T extends Actor> boolean isCorrectTransactionData(T actor, String amountTable) {
        return COL_TRANSFERS.resolveFor(actor).getText().contains(typeTrx)
                && COL_ORIGIN_PRODUCT.resolveFor(actor).getText().contains(infoTrx.getOriginAccountNumber())
                && COL_DEST_ACCOUNT.resolveFor(actor).getText().contains(infoTrx.getDestinationAccountNumber())
                && COL_TAG_TRANSACTION.resolveFor(actor).getText().contains(infoTrx.getTag())
                && amountTable.contains(infoTrx.getTransferValue());
    }

    public static SelectTheRegisterCorrect transactionHistoryTable(InfoTrx infoTrx, String typeTrx) {
        return Tasks.instrumented(SelectTheRegisterCorrect.class, infoTrx, typeTrx);
    }
}
