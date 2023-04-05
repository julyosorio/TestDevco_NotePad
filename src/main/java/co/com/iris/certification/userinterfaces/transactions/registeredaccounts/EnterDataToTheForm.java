package co.com.iris.certification.userinterfaces.transactions.registeredaccounts;

import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.transactions.SubscribedAccountIrisBankUI.*;
import static co.com.iris.certification.userinterfaces.transactions.SubscribedAccountOtherBankUI.*;
import static co.com.iris.certification.utils.Constants.OTHER_BANKS;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterDataToTheForm implements Task {

    private InfoTrx infoTrx;
    private String typeTrx;

    public EnterDataToTheForm(InfoTrx infoTrx, String typeTrx) {
        this.infoTrx = infoTrx;
        this.typeTrx = typeTrx;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (typeTrx.equals(OTHER_BANKS)) {
            actor.attemptsTo(
                    Enter.theValue(infoTrx.getOwnerDestinationAccount()).into(TEXT_OWNER_ACCOUNT),
                    Enter.theValue(infoTrx.getEmailSubsAccount()).into(TEXT_EMAIL_SUBSCRIBED_ACCOUNT_OTHER_BANKS),
                    WaitUntil.the(LIST_DOCUMENT_TYPE, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(LIST_DOCUMENT_TYPE),
                    SelectOption.fromList(OPTLST_DOCUMENT_TYPE, infoTrx.getDocTypeDestinationAccount()),
                    Enter.theValue(infoTrx.getDocNumDestinationAccount()).into(TEXT_DOCUMENT_NUMBER)
                            .then(Scroll.to(TEXT_DESCRIPTION_SUBSCRIBED_ACCOUNT)),
                    WaitUntil.the(LIST_BANK, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(LIST_BANK),
                    SelectOption.fromList(OPTLST_BANK, infoTrx.getDestinationBank()),
                    WaitUntil.the(LIST_ACCOUNT_TYPE, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(LIST_ACCOUNT_TYPE),
                    SelectOption.fromList(OPTLST_ACCOUNT_TYPE, infoTrx.getDestinationAccountType()),
                    Enter.theValue(infoTrx.getDestinationAccountNumber()).into(TEXT_ACCOUNT_NUMBER_OTHER_BANKS),
                    Enter.theValue(infoTrx.getDescriptionSubsAccount()).into(TEXT_DESCRIPTION_SUBSCRIBED_ACCOUNT_OTHER_BANKS),
                    Check.whether(infoTrx.getRequiresSaveSubscription().equalsIgnoreCase("Si"))
                            .andIfSo(Click.on(RADIO_NOTIFICATION)),
                    Click.on(BTN_COMPLETE_SUBSCRIPTION_ACCOUNT_OTHER_BANKS),
                    WaitUntil.the(LABEL_POP_UP_MESSAGE_TITLE_OTHER_BANKS, isVisible()).forNoMoreThan(WAITING_TIME).seconds()
            );
        } else {
            actor.attemptsTo(
                    Enter.theValue(infoTrx.getDestinationAccountNumber()).into(TEXT_ACCOUNT_NUMBER),
                    Click.on(BTN_VALIDATE_ACCOUNT),
                    WaitUntil.the(TEXT_EMAIL_SUBSCRIBED_ACCOUNT, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                    Enter.theValue(infoTrx.getEmailSubsAccount()).into(TEXT_EMAIL_SUBSCRIBED_ACCOUNT),
                    Enter.theValue(infoTrx.getDescriptionSubsAccount()).into(TEXT_DESCRIPTION_SUBSCRIBED_ACCOUNT)
                            .then(Scroll.to(RADIO_NOTIFICATION)),
                    Check.whether(infoTrx.getRequiresSaveSubscription().equalsIgnoreCase("Si"))
                            .andIfSo(Click.on(RADIO_NOTIFICATION)),
                    Click.on(BTN_COMPLETE_SUBSCRIPTION_ACCOUNT),
                    WaitUntil.the(LABEL_POP_UP_MESSAGE_TITLE, isVisible()).forNoMoreThan(WAITING_TIME).seconds()
            );
        }
    }

    public static EnterDataToTheForm accountRegistration(InfoTrx infoTrx, String typeTrx) {
        return Tasks.instrumented(EnterDataToTheForm.class, infoTrx, typeTrx);
    }
}
