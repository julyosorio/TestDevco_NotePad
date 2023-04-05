package co.com.iris.certification.questions.editpayments;

import co.com.iris.certification.utils.SetData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidateDate implements Question<Boolean> {

    private String executeDate;

    public ValidateDate(String executeDate) {
        this.executeDate = executeDate;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate executeDateFormat = LocalDate.parse(this.executeDate, formatter);
        LocalDate currentDate = LocalDate.parse(SetData.getCurrentDateFormatDayMonthYear(), formatter);
        return executeDateFormat.isAfter(currentDate) || executeDateFormat.isEqual(currentDate);
    }

    public static ValidateDate forCompleteEdition(String executeDate) {
        return new ValidateDate(executeDate);
    }
}
