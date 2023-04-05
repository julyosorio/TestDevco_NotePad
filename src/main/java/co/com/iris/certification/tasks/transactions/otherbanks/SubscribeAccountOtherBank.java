package co.com.iris.certification.tasks.transactions.otherbanks;

import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.transactions.SubscribedAccountOtherBankUI.*;

public class SubscribeAccountOtherBank implements Task {

    private InfoTrx trx;

    public SubscribeAccountOtherBank(InfoTrx trx){
        this.trx = trx;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(TEXT_OWNER_ACCOUNT, WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(trx.getOwnerDestinationAccount()).into(TEXT_OWNER_ACCOUNT),
                WaitUntil.the(LIST_DOCUMENT_TYPE, WebElementStateMatchers.isClickable()).forNoMoreThan(20).seconds(),
                Click.on(LIST_DOCUMENT_TYPE),
                WaitUntil.the(OPTLST_DOCUMENT_TYPE, WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
                SelectOption.fromList(OPTLST_DOCUMENT_TYPE,trx.getDocTypeDestinationAccount()),
                Enter.theValue(trx.getDocNumDestinationAccount()).into(TEXT_DOCUMENT_NUMBER),
                WaitUntil.the(LIST_BANK, WebElementStateMatchers.isClickable()).forNoMoreThan(20).seconds(),
                Click.on(LIST_BANK),
                WaitUntil.the(OPTLST_BANK, WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
                SelectOption.fromList(OPTLST_BANK,trx.getDestinationBank()),
                WaitUntil.the(LIST_ACCOUNT_TYPE, WebElementStateMatchers.isClickable()).forNoMoreThan(20).seconds(),
                Click.on(LIST_ACCOUNT_TYPE),
                WaitUntil.the(OPTLST_ACCOUNT_TYPE, WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
                SelectOption.fromList(OPTLST_ACCOUNT_TYPE,trx.getDestinationAccountType()),
                Enter.theValue(trx.getDestinationAccountNumber()).into(TEXT_ACCOUNT_NUMBER_OTHER_BANKS),
                Check.whether(trx.getRequiresSaveSubscription().contains("Si")).andIfSo(
                        Click.on(RADIO_SAVE_SUSCRIBED_ACCOUNT),
                        WaitUntil.the(TEXT_EMAIL_SUBSCRIBED_ACCOUNT_OTHER_BANKS,WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
                        Enter.theValue(trx.getEmailSubsAccount()).into(TEXT_EMAIL_SUBSCRIBED_ACCOUNT_OTHER_BANKS),
                        Enter.theValue(trx.getDescriptionSubsAccount()).into(TEXT_DESCRIPTION_SUBSCRIBED_ACCOUNT_OTHER_BANKS)
                ),
                WaitUntil.the(BTN_COMPLETE_SUBSCRIPTION_ACCOUNT_OTHER_BANKS, WebElementStateMatchers.isClickable()).forNoMoreThan(20).seconds(),
                Click.on(BTN_COMPLETE_SUBSCRIPTION_ACCOUNT_OTHER_BANKS)
        );
    }

    public static SubscribeAccountOtherBank toSelectDestinationAccount(InfoTrx trx){
        return Tasks.instrumented(SubscribeAccountOtherBank.class, trx);
    }
}
