package co.com.iris.certification.tasks.transactions.irisaccounts;

import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.transactions.irisaccounts.IrisAccountsUI.BTN_NEXT_STEP;
import static co.com.iris.certification.userinterfaces.transactions.irisaccounts.SelectIrisAccountsUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectIrisAccounts implements Task {

    private InfoTrx trx;

    public SelectIrisAccounts(InfoTrx trx) {
        this.trx = trx;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(LIST_ORIGINACCOUNT, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(LIST_ORIGINACCOUNT),
                SelectOption.fromList(OPTLST_ORIGINACCOUNT, trx.getOriginAccountNumber()),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LIST_DESTINATIONACCOUNT),
                SelectOption.fromList(OPTLST_DESTINATIONACCOUNT, trx.getDestinationAccountNumber()),
                Click.on(BTN_NEXT_STEP)
        );
    }

    public static SelectIrisAccounts forTransaction(InfoTrx trx) {
        return Tasks.instrumented(SelectIrisAccounts.class, trx);
    }
}
