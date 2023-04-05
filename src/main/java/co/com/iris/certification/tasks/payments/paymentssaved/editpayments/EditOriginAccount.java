package co.com.iris.certification.tasks.payments.paymentssaved.editpayments;

import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.transactions.Payment;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.SPINNER;
import static co.com.iris.certification.userinterfaces.payments.ManualPaymentUI.LIST_ORIGIN_ACCOUNT_EDITING_PAY;
import static co.com.iris.certification.userinterfaces.payments.ManualPaymentUI.OPTLST_ORIGIN_ACCOUNT;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EditOriginAccount implements Task {
    private Payment infoPay;

    public EditOriginAccount(Payment infoPay){
        this.infoPay = infoPay;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(LIST_ORIGIN_ACCOUNT_EDITING_PAY, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LIST_ORIGIN_ACCOUNT_EDITING_PAY),
                SelectOption.fromList(OPTLST_ORIGIN_ACCOUNT,infoPay.getOriginAccountNumber())
        );
    }

    public static EditOriginAccount withTheNewNumberAccountSend(Payment infoPay){
        return Tasks.instrumented(EditOriginAccount.class, infoPay);
    }
}
