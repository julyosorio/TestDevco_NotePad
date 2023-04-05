package co.com.iris.certification.tasks.transactions.otherbanks;


import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.transactions.TransferValueUI.TEXT_TRX_AMOUNT;
import static co.com.iris.certification.userinterfaces.transactions.otherbanks.OtherBanksUI.BTN_NEXT_STEP;
import static co.com.iris.certification.userinterfaces.transactions.otherbanks.SelectAccountsOtherBanksUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ChooseAccountsOtherBanks implements Task {

    private InfoTrx trx;

    public ChooseAccountsOtherBanks(InfoTrx trx) {
        this.trx = trx;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(LIST_ORIGIN_ACCOUNT, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LIST_ORIGIN_ACCOUNT),
                SelectOption.fromList(OPTLST_ORIGIN_ACCOUNT, trx.getOriginAccountNumber()),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(LIST_DESTINATION_BANK, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LIST_DESTINATION_BANK),
                SelectOption.fromList(OPTLST_DESTINATION_BANK, trx.getDestinationBank()),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(LIST_DESTINATION_ACCOUNT, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LIST_DESTINATION_ACCOUNT),
                SelectOption.fromList(OPTLST_DESTINATION_ACCOUNT, trx.getDestinationAccountNumber()),
                Click.on(BTN_NEXT_STEP),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(TEXT_TRX_AMOUNT, isVisible()).forNoMoreThan(WAITING_TIME).seconds()

        );
    }

    public static ChooseAccountsOtherBanks originAndDestination(InfoTrx trx) {
        return Tasks.instrumented(ChooseAccountsOtherBanks.class, trx);
    }
}
