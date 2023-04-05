package co.com.iris.certification.tasks.transactions;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.WAIT_LOADER;
import static co.com.iris.certification.userinterfaces.transactions.TransferValueUI.LABEL_TEXT_AMOUNT;
import static co.com.iris.certification.userinterfaces.transactions.TransferValueUI.TEXT_TRX_AMOUNT;
import static co.com.iris.certification.userinterfaces.transactions.irisaccounts.IrisAccountsUI.BTN_NEXT_STEP;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class InsertValueCorrect implements Task {
    private InfoTrx infoTrx;
    public InsertValueCorrect(InfoTrx infoTrx){
        this.infoTrx=infoTrx;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TEXT_TRX_AMOUNT, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Enter.theValue(infoTrx.getTransferValue()).into(TEXT_TRX_AMOUNT),
                Hit.the(Keys.TAB).into(TEXT_TRX_AMOUNT),
                MoveMouse.to(BTN_NEXT_STEP),
                WaitUntil.the(BTN_NEXT_STEP, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_NEXT_STEP),
                Check.whether(WAIT_LOADER.isVisibleFor(actor)).andIfSo(
                        WaitUntil.the(WAIT_LOADER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
                )
        );
        validateSelectButtonContinue(actor);
        actor.remember("transferValue", infoTrx.getTransferValue());
    }

    public void validateSelectButtonContinue(Actor actor){
        while(LABEL_TEXT_AMOUNT.resolveFor(actor).isVisible()){
            actor.attemptsTo(
                    WaitUntil.the(BTN_NEXT_STEP, isEnabled()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(BTN_NEXT_STEP)
            );
        }
    }

    public static InsertValueCorrect ofTransaction(InfoTrx infoTrx){
        return Tasks.instrumented(InsertValueCorrect.class,infoTrx);
    }
}
