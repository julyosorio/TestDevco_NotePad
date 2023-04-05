package co.com.iris.certification.tasks.payments.historictable;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ui.PageElement;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.transactionshistory.payments.PaymentsAndBatchesHistoricTableUI.FIELD_CREATION_DATE;
import static co.com.iris.certification.userinterfaces.transactionshistory.payments.PaymentsHistoricFiltersUI.*;
import static co.com.iris.certification.utils.Constants.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class ApplySearchFilters implements Task {

    private String payType;
    private String tag;

    public ApplySearchFilters(String payType, String tag) {
        this.payType = payType;
        this.tag = tag;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_FILTERS),
                Click.on(LIST_PAY_TYPE),
                Check.whether(payType.equalsIgnoreCase(PAY_TYPE_MANUAL_PAYROLL)).andIfSo(
                        Click.on(PageElement.containingText(VALUE_PAY_TYPE_MANUAL_PAYROLL).inside(LIST_PAY_TYPE))),
                Check.whether(payType.equalsIgnoreCase(PAY_TYPE_MANUAL_SUPPLIER)).andIfSo(
                        Click.on(PageElement.containingText(VALUE_PAY_TYPE_MANUAL_SUPPLIER).inside(LIST_PAY_TYPE))
                ),
                Click.on(LIST_TAG_PAY_TRANSACTION),
                Click.on(PageElement.containingText(tag).inside(LIST_TAG_PAY_TRANSACTION)),
                Click.on(BTN_APPLY_FILTERS),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(FIELD_CREATION_DATE, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(FIELD_CREATION_DATE),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    public static ApplySearchFilters forGetThePayRecordInTable(String payType, String tag) {
        return Tasks.instrumented(ApplySearchFilters.class, payType, tag);
    }
}
