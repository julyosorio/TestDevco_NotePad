package co.com.iris.certification.tasks.transactions;

import co.com.iris.certification.interactions.SelectTag;
import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.transactions.TagUI.*;
import static co.com.iris.certification.userinterfaces.transactions.TransactionSummaryUI.BTN_EXECUTE_TRANSACTION;
import static co.com.iris.certification.userinterfaces.transactions.otherbanks.OtherBanksUI.BTN_NEXT_STEP;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AddTag implements Task {

    private InfoTrx infoTrx;

    public AddTag(InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LIST_TAG, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LIST_TAG),
                SelectTag.fromList(OPTLST_TAG, infoTrx.getTag()),
                Enter.theValue(infoTrx.getDescription()).into(TEXT_DESCRIPTION),
                WaitUntil.the(BTN_NEXT_STEP,isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_NEXT_STEP),
                Check.whether(LOADSCREEN_SPINNER.isVisibleFor(actor))
                        .andIfSo(WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds())
                        .otherwise(WaitUntil.the(BTN_EXECUTE_TRANSACTION, isVisible()).forNoMoreThan(WAITING_TIME).seconds())
        );
    }

    public static AddTag toTheTransaction(InfoTrx infoTrx) {
        return Tasks.instrumented(AddTag.class, infoTrx);
    }
}
