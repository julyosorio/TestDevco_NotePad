package co.com.iris.certification.tasks.transactions;

import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.transactions.InfoTrx;
import co.com.iris.certification.tasks.transactions.irisaccounts.SubscribeAccountIrisAccount;
import co.com.iris.certification.tasks.transactions.otherbanks.SubscribeAccountOtherBank;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.WAIT_LOADER;
import static co.com.iris.certification.userinterfaces.transactions.irisaccounts.SelectIrisAccountsUI.*;
import static co.com.iris.certification.userinterfaces.transactions.otherbanks.OtherBanksUI.BTN_NEXT_STEP;
import static co.com.iris.certification.userinterfaces.transactions.otherbanks.SelectAccountsOtherBanksUI.*;
import static co.com.iris.certification.utils.Constants.OTHER_BANKS;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SubscribeAndChooseAccount implements Task {

    private InfoTrx trx;
    private String typeTransaction;

    public SubscribeAndChooseAccount(InfoTrx trx, String typeTransaction) {
        this.trx = trx;
        this.typeTransaction = typeTransaction;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        selectOriginAccount(actor);
        selectBankDestinationAccount(actor);
        openListDestinationAccount(actor);
        subscribeAccount(actor);

    }

    public void subscribeAccount(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_SUBSCRIBE_ACCOUNT, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_SUBSCRIBE_ACCOUNT),
                Check.whether(typeTransaction.equalsIgnoreCase(OTHER_BANKS))
                        .andIfSo(
                                SubscribeAccountOtherBank.toSelectDestinationAccount(trx),
                                WaitUntil.the(LABEL_VALUE_DESTINATION_ACCOUNT, isVisible()).forNoMoreThan(WAITING_TIME).seconds()
                        ).otherwise(SubscribeAccountIrisAccount.toSelectDestinationAccount(trx)),
                Click.on(BTN_NEXT_STEP)
        );
    }

    public void openListDestinationAccount(Actor actor) {
        actor.attemptsTo(
                Check.whether(typeTransaction.equalsIgnoreCase(OTHER_BANKS)).andIfSo(
                        WaitUntil.the(LIST_DESTINATION_ACCOUNT, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                        Click.on(LIST_DESTINATION_ACCOUNT)).otherwise(
                        WaitUntil.the(LIST_DESTINATIONACCOUNT, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                        Click.on(LIST_DESTINATIONACCOUNT)));
    }

    public void selectBankDestinationAccount(Actor actor) {
        actor.attemptsTo(
                Check.whether(typeTransaction.equalsIgnoreCase(OTHER_BANKS)).andIfSo(
                        WaitUntil.the(LIST_DESTINATION_BANK, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                        Click.on(LIST_DESTINATION_BANK),
                        WaitUntil.the(OPTLST_DESTINATION_BANK, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                        SelectOption.fromList(OPTLST_DESTINATION_BANK, trx.getDestinationBank()),
                        WaitUntil.the(WAIT_LOADER, isNotVisible()).forNoMoreThan(WAITING_TIME).seconds()));
    }

    public void selectOriginAccount(Actor actor) {
        actor.attemptsTo(Check.whether(typeTransaction.equalsIgnoreCase(OTHER_BANKS)).andIfSo(
                        WaitUntil.the(LIST_ORIGIN_ACCOUNT, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                        Click.on(LIST_ORIGIN_ACCOUNT),
                        WaitUntil.the(OPTLST_ORIGIN_ACCOUNT, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                        SelectOption.fromList(OPTLST_ORIGIN_ACCOUNT, trx.getOriginAccountNumber()))
                .otherwise(
                        WaitUntil.the(LIST_ORIGINACCOUNT, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                        Click.on(LIST_ORIGINACCOUNT),
                        WaitUntil.the(OPTLST_ORIGINACCOUNT, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                        SelectOption.fromList(OPTLST_ORIGINACCOUNT, trx.getOriginAccountNumber())
                )
        );
    }

    public static SubscribeAndChooseAccount toCompleteTransaction(InfoTrx trx, String typeTransaction) {
        return Tasks.instrumented(SubscribeAndChooseAccount.class, trx, typeTransaction);
    }
}
