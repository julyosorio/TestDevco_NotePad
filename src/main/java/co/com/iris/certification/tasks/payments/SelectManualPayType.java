package co.com.iris.certification.tasks.payments;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.MENU_PAYMENTS;
import static co.com.iris.certification.userinterfaces.payments.ManualPaymentUI.PAYROLL_PAYMENT;
import static co.com.iris.certification.userinterfaces.payments.ManualPaymentUI.SUPPLIERS_PAYMENT;
import static co.com.iris.certification.userinterfaces.payments.PaymentOptionsUI.MANUAL_PAYMENT;
import static co.com.iris.certification.utils.Constants.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class SelectManualPayType implements Task {

    private String payType;

    public SelectManualPayType(String payType) {
        this.payType = payType;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(MENU_PAYMENTS, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(MENU_PAYMENTS),
                WaitUntil.the(MANUAL_PAYMENT, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(MANUAL_PAYMENT),
                Check.whether(LOADSCREEN_SPINNER.isVisibleFor(actor)).andIfSo(
                        WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()),
                Check.whether(payType.equalsIgnoreCase(PAY_TYPE_PAYROLL)).andIfSo(
                        WaitUntil.the(PAYROLL_PAYMENT, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                        Click.on(PAYROLL_PAYMENT)),
                Check.whether(payType.equalsIgnoreCase(PAY_TYPE_SUPPLIERS)).andIfSo(
                        WaitUntil.the(SUPPLIERS_PAYMENT, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                        Click.on(SUPPLIERS_PAYMENT))
        );
    }

    public static SelectManualPayType forContinue(String payType) {
        return Tasks.instrumented(SelectManualPayType.class, payType);
    }
}
