package co.com.iris.certification.tasks.transactions.irisaccounts;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.transactions.SubscribedAccountIrisBankUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SubscribeAccountIrisAccount implements Task {
    private InfoTrx trx;

    public SubscribeAccountIrisAccount(InfoTrx trx){
        this.trx = trx;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TEXT_ACCOUNT_NUMBER, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Enter.theValue(trx.getDestinationAccountNumber()).into(TEXT_ACCOUNT_NUMBER),
                WaitUntil.the(BTN_VALIDATE_ACCOUNT, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_VALIDATE_ACCOUNT),
                WaitUntil.the(LOADSCREEN_SPINNER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Check.whether(trx.getRequiresSaveSubscription().contains("Si")).andIfSo(
                        Click.on(RADIO_SAVE_SUSCRIBED_ACCOUNT),
                        WaitUntil.the(TEXT_EMAIL_SUBSCRIBED_ACCOUNT, WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
                        Enter.theValue(trx.getEmailSubsAccount()).into(TEXT_EMAIL_SUBSCRIBED_ACCOUNT),
                        Enter.theValue(trx.getDescriptionSubsAccount()).into(TEXT_DESCRIPTION_SUBSCRIBED_ACCOUNT)
                ),
                WaitUntil.the(BTN_COMPLETE_SUBSCRIPTION_ACCOUNT, WebElementStateMatchers.isClickable()).forNoMoreThan(20).seconds(),
                Click.on(BTN_COMPLETE_SUBSCRIPTION_ACCOUNT)
        );
    }

    public static SubscribeAccountIrisAccount toSelectDestinationAccount(InfoTrx trx){
        return Tasks.instrumented(SubscribeAccountIrisAccount.class, trx);
    }
}
