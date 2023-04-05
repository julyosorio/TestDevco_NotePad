package co.com.iris.certification.tasks.payments;

import co.com.iris.certification.interactions.SelectDate;
import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.transactions.Payment;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.payments.ManualPaymentUI.*;
import static co.com.iris.certification.userinterfaces.transactions.CalendarUI.*;
import static co.com.iris.certification.userinterfaces.transactions.PeriodicidadUI.CALENDAR_EXECUTE_DATE;
import static co.com.iris.certification.utils.Constants.SEPARATOR_FORMAT_DATE;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static co.com.iris.certification.utils.SetData.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class SelectOriginProductAndExecuteDate implements Task {
    private Payment infoPay;

    public SelectOriginProductAndExecuteDate(Payment infoPay) {
        this.infoPay = infoPay;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String[] executeDate = null;
        if (infoPay.getExecuteDate() != null) {
            executeDate = dateInDayMonthYearFormat(infoPay.getExecuteDate(), SEPARATOR_FORMAT_DATE);
            String valueExecuteDate = VALUE_XPATH_EXECUTE_DATE.replace("executeDate", convertDate(executeDate));
            VALUE_EXECUTE_DATE = Target.the("field that contains the execute date to select").located(By.xpath(valueExecuteDate));
        }
        actor.attemptsTo(
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LIST_ORIGIN_ACCOUNT),
                SelectOption.fromList(OPTLST_ORIGIN_ACCOUNT, infoPay.getOriginAccountNumber()),
                SelectDate.toShceduleTransaction(CALENDAR_EXECUTE_DATE, BTN_YEAR_DATE, CALENDAR_YEAR_DATE,
                        BTN_MONTH_DATE, CALENDAR_MONTH_DATE, VALUE_EXECUTE_DATE,
                        convertMonth(executeDate[1]), executeDate[2]),
                Click.on(BTN_NEXT)
        );
    }

    public static String convertDate(String date[]) {
        return convertDayAndMonth(date[0]).concat("/" + convertDayAndMonth(date[1])).concat("/" + date[2]);
    }

    public static SelectOriginProductAndExecuteDate forScheduleThePay(Payment infoPay) {
        return Tasks.instrumented(SelectOriginProductAndExecuteDate.class, infoPay);
    }
}
