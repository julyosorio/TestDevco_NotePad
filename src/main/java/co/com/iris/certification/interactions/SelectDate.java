package co.com.iris.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectDate implements Interaction {

    private Target calendarDate;
    private Target year;
    private Target yearsList;
    private Target month;
    private Target monthsList;
    private String yearValue;
    private String monthValue;
    private Target valueDate;

    public SelectDate(Target calendarDate, Target year, Target yearsList, Target month, Target monthsList, Target valueDate, String monthValue, String yearValue) {
        this.calendarDate = calendarDate;
        this.year = year;
        this.yearsList = yearsList;
        this.month = month;
        this.monthsList = monthsList;
        this.valueDate = valueDate;
        this.yearValue = yearValue;
        this.monthValue = monthValue;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MoveMouse.to(calendarDate),
                WaitUntil.the(calendarDate, isClickable()),
                Click.on(calendarDate),
                MoveMouse.to(year),
                WaitUntil.the(year, isClickable()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(year),
                WaitUntil.the(yearsList, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                SelectOption.fromList(yearsList,yearValue),
                MoveMouse.to(month),
                WaitUntil.the(month, isClickable()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(month),
                WaitUntil.the(monthsList, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                SelectOption.fromList(monthsList,monthValue),
                Click.on(valueDate)
        );
    }

    public static SelectDate toShceduleTransaction(Target calendarDate,Target year,Target yearsList,Target month, Target monthsList,Target valueDate, String monthValue,String yearValue) {
        return Tasks.instrumented(SelectDate.class, calendarDate, year, yearsList,
                month, monthsList, valueDate, monthValue, yearValue);
    }
}
