package co.com.iris.certification.tasks.payments;

import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.transactions.Payment;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.payments.AddPayToListUI.*;
import static co.com.iris.certification.userinterfaces.payments.ManualPaymentUI.BTN_NEXT;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AddPayments implements Task {

    private Payment infoPay;

    public AddPayments(Payment infoPay) {
        this.infoPay = infoPay;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int i = 1;
        while (i <= Integer.parseInt(infoPay.getQuantity())) {
            actor.attemptsTo(
                    WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(LIST_DESTINATION_BANK),
                    SelectOption.fromList(OPTLST_DESTINATION_BANK, infoPay.getDestinationBank()),
                    WaitUntil.the(LIST_DESTINATION_ACCOUNT, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(LIST_DESTINATION_ACCOUNT),
                    SelectOption.fromList(OPTLST_DESTINATION_ACCOUNT, infoPay.getDestinationAccountNumber()),
                    Enter.theValue(infoPay.getPayValue()).into(TEXT_AMOUNT).thenHit(Keys.TAB),
                    WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds().then(Scroll.to(LABEL_ADD_PAY)),
                    WaitUntil.the(BTN_ADD_PAYMENT_TO_THE_LIST, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(BTN_ADD_PAYMENT_TO_THE_LIST),
                    WaitUntil.the(LABEL_TOAST_MESSAGE_PAY_ADDED_SUCCESSFULLY, isPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(LABEL_TOAST_MESSAGE_PAY_ADDED_SUCCESSFULLY)
            );
            Serenity.recordReportData().withTitle("A new pay was added to the list ").andContents("#" + i);
            i++;
        }
        continueWithPayTransaction(actor);

    }

    public void continueWithPayTransaction(Actor actor) {
        actor.attemptsTo(
                Scroll.to(BTN_NEXT),
                Click.on(BTN_NEXT));
    }

    public static AddPayments toPayList(Payment infoPay) {
        return Tasks.instrumented(AddPayments.class, infoPay);
    }
}
