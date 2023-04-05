package co.com.iris.certification.tasks.transactions.scheduledtransaction;

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
import static co.com.iris.certification.userinterfaces.transactions.scheduledtransaction.ScheduledTransactionTableUI.*;
import static co.com.iris.certification.userinterfaces.transactions.voucher.SuccessfulVoucherUI.BTN_CLOSE_VOUCHER;
import static co.com.iris.certification.utils.Constants.OTHER_BANKS;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class SelectARegisterCorrect implements Task {

    private InfoTrx infoTrx;
    private String destinationBank;
    private String typeTrx;


    public SelectARegisterCorrect(InfoTrx infoTrx, String typeTrx){
        this.infoTrx = infoTrx;
        this.typeTrx = typeTrx;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
       String periodicity;

       if (typeTrx.equals(OTHER_BANKS)){
           destinationBank=infoTrx.getDestinationBank();
       }else{
           destinationBank="Iris";
       }

        if(infoTrx.getPeriodicity().equals("Única vez")){
            periodicity = "";
        }else{
            periodicity = infoTrx.getPeriodicity();
        }

        actor.attemptsTo(
                Check.whether(COL_SCHEDULEDDATE.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains(infoTrx.getStartTransactionDate())&&
                        COL_ORIGINACCOUNT.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains(infoTrx.getOriginAccountNumber()) &&
                        COL_DESTINATIONBANK.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains(destinationBank) &&
                        COL_DESTINATIONACCOUNT.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains(infoTrx.getDestinationAccountNumber()) &&
                        COL_TAG.resolveFor(OnStage.theActorInTheSpotlight()).getText().equals(infoTrx.getTag()) &&
                        COL_PERIODICITY.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains(periodicity) &&
                        COL_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", "").contains("$"+infoTrx.getTransferValue())
                ).andIfSo(
                WaitUntil.the(LOADSCREEN_SPINNER,isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                MoveMouse.to(ROW_REGISTER),
                Scroll.to(ROW_REGISTER),
                Click.on(ROW_REGISTER),
                WaitUntil.the(BTN_CLOSE_VOUCHER, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))
                )
        );
    }

    public static SelectARegisterCorrect scheduledTransactionTable(InfoTrx infoTrx, String typeTrx) {
        return Tasks.instrumented(SelectARegisterCorrect.class, infoTrx, typeTrx);
    }
}
