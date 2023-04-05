package co.com.iris.certification.tasks.transactions;

import co.com.iris.certification.interactions.SelectDate;
import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.transactions.InfoTrx;
import co.com.iris.certification.utils.SetData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static co.com.iris.certification.userinterfaces.transactions.CalendarUI.*;
import static co.com.iris.certification.userinterfaces.transactions.PeriodicidadUI.*;
import static co.com.iris.certification.userinterfaces.transactions.otherbanks.OtherBanksUI.BTN_NEXT_STEP;
import static co.com.iris.certification.utils.Constants.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SchedulePeriodicity implements Task {

    private InfoTrx infoTrx;

    public SchedulePeriodicity(InfoTrx infoTrx) {

        this.infoTrx = infoTrx;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String[] startDateArray = null;
        String[] finalDateArray = null;

        if (infoTrx.getStartTransactionDate() != null) {
            startDateArray = SetData.dateInDayMonthYearFormat(infoTrx.getStartTransactionDate(), SEPARATOR_FORMAT_DATE);
            String valueStartDate = VALUE_XPATH_START_DATE.replace("startDate", convertDate(startDateArray));
            VALUE_START_DATE = Target.the("field that contains the start date to select").located(By.xpath(valueStartDate));
        }
        if (infoTrx.getFinalTransactionDate() != null) {
            finalDateArray = SetData.dateInDayMonthYearFormat(infoTrx.getFinalTransactionDate(), SEPARATOR_FORMAT_DATE);
            String valueFinalDate = VALUE_XPATH_FINAL_DATE.replace("finalDate", convertDate(finalDateArray));
            VALUE_FINAL_DATE = Target.the("field that contains the final date to select").located(By.xpath(valueFinalDate));
        }
        if (infoTrx.getPeriodicity() != null) {
            actor.attemptsTo(
                    Click.on(LIST_PERIODICITY),
                    SelectOption.fromList(OPTLST_PERIODICITY, infoTrx.getPeriodicity()),
                    SelectDate.toShceduleTransaction(CALENDAR_START_DATE, BTN_YEAR_DATE, CALENDAR_YEAR_DATE,
                            BTN_MONTH_DATE, CALENDAR_MONTH_DATE, VALUE_START_DATE,
                            SetData.convertMonth(startDateArray[1]), startDateArray[2])
            );
            selectFinalDate(actor, finalDateArray);
        } else {
            validateDefaultPeriodicity(actor);
        }
        continueWithTheTransaction(actor);

    }

    public void validateDefaultPeriodicity(Actor actor) {
        actor.attemptsTo(WaitUntil.the(VALUE_PERIODICITY, containsText(VALUE_DEFAULT_FIELD_PERIODICITY))
                .forNoMoreThan(20).seconds());
    }

    public void selectFinalDate(Actor actor, String[] list) {
        if (list != null) {
            actor.attemptsTo(SelectDate.toShceduleTransaction(CALENDAR_FINAL_DATE, BTN_YEAR_DATE, CALENDAR_YEAR_DATE,
                    BTN_MONTH_DATE, CALENDAR_MONTH_DATE, VALUE_FINAL_DATE,
                    SetData.convertMonth(list[1]), list[2]));
        }
    }
    public void continueWithTheTransaction(Actor actor) {
        actor.attemptsTo(WaitUntil.the(BTN_NEXT_STEP, isEnabled()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_NEXT_STEP));
    }

    public static String convertDate(String date[]) {
        return SetData.convertDayAndMonth(date[0]).concat("/" + SetData.convertDayAndMonth(date[1])).concat("/" + date[2]);
    }

    public static SchedulePeriodicity ofTheTransaction(InfoTrx infoTrx) {
        return Tasks.instrumented(SchedulePeriodicity.class, infoTrx);
    }
}
