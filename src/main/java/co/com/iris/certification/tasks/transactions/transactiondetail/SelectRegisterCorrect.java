package co.com.iris.certification.tasks.transactions.transactiondetail;

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
import static co.com.iris.certification.userinterfaces.transactions.transactiondetail.TransactionDetailTableUI.*;
import static co.com.iris.certification.userinterfaces.transactions.voucher.SuccessfulVoucherUI.BTN_CLOSE_VOUCHER;
import static co.com.iris.certification.utils.Constants.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class SelectRegisterCorrect implements Task {

    private InfoTrx infoTrx;
    private String destinationBank;
    private String typeTrx;

    public SelectRegisterCorrect(InfoTrx infoTrx, String typeTrx) {
        this.infoTrx = infoTrx;
        this.typeTrx = typeTrx;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String amountTable = COL_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", "");
        if (typeTrx.equals(OTHER_BANKS)){
            destinationBank = infoTrx.getDestinationBank();
        }else{
            destinationBank = "Iris";
        }

        actor.attemptsTo(
                Check.whether(isCorrectRow(actor, DATE_CURRENT, amountTable))
                        .andIfSo(Check.whether(LOADSCREEN_SPINNER.isVisibleFor(actor))
                                        .andIfSo(WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))),
                                MoveMouse.to(ROW_TRANSACTION_DETAIL_TABLE),
                                Scroll.to(ROW_TRANSACTION_DETAIL_TABLE),
                                Click.on(ROW_TRANSACTION_DETAIL_TABLE),
                                WaitUntil.the(BTN_CLOSE_VOUCHER, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))
                        )
        );
    }

    private <T extends Actor> boolean isCorrectRow
            (T actor, String voucherDate,  String amountTable) {
        return isCorrectDate(actor, voucherDate)
                && isCorrectTransactionData(actor, amountTable);
    }
    private <T extends Actor> boolean isCorrectDate(T actor, String voucherDate) {
        return COL_DATE_EXECUTE.resolveFor(actor).getText().startsWith(voucherDate);
    }
    private <T extends Actor> boolean isCorrectTransactionData(T actor, String amountTable) {
        return COL_PRODUCT.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains(infoTrx.getOriginAccountNumber())
                && COL_DESTINATION_BANK.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains(destinationBank)
                && COL_TAG.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains(infoTrx.getTag())
                && amountTable.contains(infoTrx.getTransferValue());
    }
    public static SelectRegisterCorrect transactionDetailTable(InfoTrx infoTrx, String typeTrx) {
        return Tasks.instrumented(SelectRegisterCorrect.class, infoTrx, typeTrx);
    }
}
