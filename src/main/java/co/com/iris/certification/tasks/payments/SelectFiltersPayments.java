package co.com.iris.certification.tasks.payments;

import co.com.iris.certification.models.transactions.Payment;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ui.PageElement;

import static co.com.iris.certification.userinterfaces.authorization.FilterAuthorizationsUI.*;
import static co.com.iris.certification.utils.Constants.MANUAL_PAYROLL;
import static co.com.iris.certification.utils.Constants.MANUAL_SUPPLIER_PAYMENT;

public class SelectFiltersPayments implements Task {
    private String operation;
    private String payType;
    private Payment payment;
    public SelectFiltersPayments(Payment payment, String operation){
        this.payment=payment;
        this.operation=operation;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (payment.getPayType().equalsIgnoreCase("Manuales:Nominas")){
            payType = MANUAL_PAYROLL;
        }
        else if (payment.getPayType().equalsIgnoreCase("Manuales:Proveedores")){
            payType = MANUAL_SUPPLIER_PAYMENT;
        }else {
            payType = payment.getPayType();
        }

        actor.attemptsTo(
                Click.on(BTN_FILTER),
                Click.on(LIST_OPTION_OPERATION),
                Click.on(PageElement.containingText(operation).inside(LIST_OPTION_OPERATION)),
                Click.on(LIST_TYPE_OPERATION),
                Click.on(PageElement.containingText(payType).inside(LIST_TYPE_OPERATION)),
                Click.on(LIST_TAG),
                Click.on(PageElement.containingText(payment.getTag()).inside(LIST_TAG)),
                MoveMouse.to(BTN_APLLY_FILTERS),
                Scroll.to(BTN_APLLY_FILTERS),
                Click.on(BTN_APLLY_FILTERS)
        );

    }

    public static SelectFiltersPayments forGetTheRecordPendingAuthorization(Payment payment, String operation){
        return Tasks.instrumented(SelectFiltersPayments.class, payment, operation);
    }
}
