package co.com.iris.certification.tasks.payments.paymentssaved.editpayments;

import co.com.iris.certification.exceptions.ExecuteDateLesser;
import co.com.iris.certification.interactions.SelectDate;
import co.com.iris.certification.models.transactions.Payment;
import co.com.iris.certification.questions.editpayments.ValidateDate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.transactions.CalendarUI.*;
import static co.com.iris.certification.userinterfaces.transactions.PeriodicidadUI.CALENDAR_EXECUTE_DATE;
import static co.com.iris.certification.utils.Constants.SEPARATOR_FORMAT_DATE;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static co.com.iris.certification.utils.SetData.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static org.hamcrest.Matchers.equalTo;

public class EditExecuteDate implements Task {

    private Payment infoPay;

    public EditExecuteDate(Payment infoPay){
        this.infoPay = infoPay;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(seeThat(ValidateDate.forCompleteEdition(infoPay.getExecuteDate()), equalTo(true))
                .orComplainWith(ExecuteDateLesser.class, "The new execute date is lesser than the current date"));

        String[] executeDate = null;
        if (infoPay.getExecuteDate() != null) {
            executeDate = dateInDayMonthYearFormat(infoPay.getExecuteDate(), SEPARATOR_FORMAT_DATE);
            String valueExecuteDate = VALUE_XPATH_EXECUTE_DATE.replace("executeDate", convertDate(executeDate));
            VALUE_EXECUTE_DATE = Target.the("field that contains the execute date to select").located(By.xpath(valueExecuteDate));
        }
        actor.attemptsTo(
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                SelectDate.toShceduleTransaction(CALENDAR_EXECUTE_DATE, BTN_YEAR_DATE, CALENDAR_YEAR_DATE,
                        BTN_MONTH_DATE, CALENDAR_MONTH_DATE, VALUE_EXECUTE_DATE,
                        convertMonth(executeDate[1]), executeDate[2])
        );
    }

    public static String convertDate(String date[]) {
        return convertDayAndMonth(date[0]).concat("/" + convertDayAndMonth(date[1])).concat("/" + date[2]);
    }

    public static EditExecuteDate withTheNewDateSend(Payment infoPay){
        return Tasks.instrumented(EditExecuteDate.class, infoPay);
    }
}
