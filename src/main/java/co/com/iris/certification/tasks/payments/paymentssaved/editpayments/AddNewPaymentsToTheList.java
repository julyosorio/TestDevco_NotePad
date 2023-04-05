package co.com.iris.certification.tasks.payments.paymentssaved.editpayments;

import co.com.iris.certification.exceptions.AddPaymentsToTheList;
import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.transactions.Payment;
import co.com.iris.certification.questions.editpayments.ValidateQuantitySentForAdd;
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
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.equalTo;

public class AddNewPaymentsToTheList implements Task {

    private Payment infoPay;

    public AddNewPaymentsToTheList(Payment infoPay) {
        this.infoPay = infoPay;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(seeThat(ValidateQuantitySentForAdd.newPaymentsToTheList(infoPay.getQuantity()),
                    equalTo(true)).orComplainWith(AddPaymentsToTheList.class, "The quantity indicated for add is greater to the payments quantity allowed in the list"));

        int i = 1;
        while (i <= Integer.parseInt(infoPay.getQuantity())) {
            actor.attemptsTo(
                    WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(LIST_DESTINATION_BANK),
                    SelectOption.fromList(OPTLST_DESTINATION_BANK, infoPay.getDestinationBank()),
                    WaitUntil.the(LIST_DESTINATION_ACCOUNT, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(LIST_DESTINATION_ACCOUNT),
                    SelectOption.fromList(OPTLST_DESTINATION_ACCOUNT, infoPay.getDestinationAccountNumber()),
                    Scroll.to(TEXT_AMOUNT).then(Enter.theValue(infoPay.getPayValue()).into(TEXT_AMOUNT).thenHit(Keys.TAB)),
                    WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds().then(Scroll.to(LABEL_ADD_PAY)),
                    WaitUntil.the(BTN_ADD_PAYMENT_TO_THE_LIST, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(BTN_ADD_PAYMENT_TO_THE_LIST),
                    WaitUntil.the(LABEL_TOAST_MESSAGE_PAY_ADDED_SUCCESSFULLY, isPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(LABEL_TOAST_MESSAGE_PAY_ADDED_SUCCESSFULLY)
            );
            Serenity.recordReportData().withTitle("Payment edition: A new pay was added to the list ").andContents("#" + i);
            i++;
        }
    }

    public static AddNewPaymentsToTheList accordingToPaymentsQuantityIndicatedForAdd(Payment infoPay) {
        return Tasks.instrumented(AddNewPaymentsToTheList.class, infoPay);
    }
}
