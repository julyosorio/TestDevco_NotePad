package co.com.iris.certification.tasks.payments.paymentssaved.editpayments;

import co.com.iris.certification.exceptions.DeletePaymentsAddedFromPayList;
import co.com.iris.certification.models.transactions.Payment;
import co.com.iris.certification.questions.editpayments.ValidateQuantity;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.payments.AddPayToListUI.LABEL_QUATITY_PAYMENTS_ADDED_TO_LIST;
import static co.com.iris.certification.userinterfaces.payments.PaymentsAddedListUI.BTN_DELETE_PAY_FROM_LIST;
import static co.com.iris.certification.userinterfaces.payments.PaymentsAddedListUI.BTN_OPTION_PAY_IN_LIST;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class DeletePaymentsFromPayList implements Task {
    private Payment infoPay;

    public DeletePaymentsFromPayList(Payment infoPay) {
        this.infoPay = infoPay;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.should(seeThat(ValidateQuantity.forDeletePayments(infoPay.getPaymentQuantityDelete()),
                equalTo(true)).orComplainWith(DeletePaymentsAddedFromPayList.class, "The quantity indicated for delete is greater or equal the quantity the payments added in the list"));
        int i = BTN_OPTION_PAY_IN_LIST.resolveAllFor(t).size()-1;
        int j=0;
        while (j < Integer.parseInt(infoPay.getPaymentQuantityDelete())) {
            t.attemptsTo(
                    Scroll.to(BTN_OPTION_PAY_IN_LIST.resolveAllFor(t).get(i)),
                    Click.on(BTN_OPTION_PAY_IN_LIST.resolveAllFor(t).get(i)),
                    WaitUntil.the(BTN_DELETE_PAY_FROM_LIST, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(BTN_DELETE_PAY_FROM_LIST),
                    Scroll.to(LABEL_QUATITY_PAYMENTS_ADDED_TO_LIST)
            );
            Serenity.recordReportData().withTitle("Payment edition: A pay was deleted ").andContents("#" + (i+1));
            i--;
            j++;
        }
    }

    public static DeletePaymentsFromPayList accordingToQuantityIndicatedForDelete(Payment infoPay) {
        return Tasks.instrumented(DeletePaymentsFromPayList.class, infoPay);
    }
}
