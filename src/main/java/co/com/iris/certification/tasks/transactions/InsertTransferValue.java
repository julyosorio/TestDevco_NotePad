package co.com.iris.certification.tasks.transactions;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.iris.certification.userinterfaces.transactions.TransferValueUI.TEXT_TRX_AMOUNT;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class InsertTransferValue implements Task {

    private InfoTrx infoTrx;

    public InsertTransferValue(InfoTrx infoTrx){
        this.infoTrx=infoTrx;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TEXT_TRX_AMOUNT, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Enter.theValue(infoTrx.getTransferValue()).into(TEXT_TRX_AMOUNT),
                Hit.the(Keys.TAB).into(TEXT_TRX_AMOUNT)
        );
    }

    public static InsertTransferValue forAssessItsValidity(InfoTrx infoTrx){
        return Tasks.instrumented(InsertTransferValue.class,infoTrx);
    }
}
