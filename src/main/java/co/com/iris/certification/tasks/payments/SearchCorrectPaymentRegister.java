package co.com.iris.certification.tasks.payments;

import co.com.iris.certification.models.transactions.Payment;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.authorization.MyAuthorizationsUI.*;
import static co.com.iris.certification.utils.Constants.DATE_CURRENT;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SearchCorrectPaymentRegister implements Task {

    private Payment payment;
    private String operation;


    public SearchCorrectPaymentRegister(Payment payment, String operation) {
        this.payment = payment;
        this.operation = operation;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(isCorrectRow(actor))
                        .andIfSo(
                                WaitUntil.the(ROW_CORRECT, isClickable()).forNoMoreThan(WAITING_TIME).seconds()
                        )
        );
    }

    private <T extends Actor> boolean isCorrectRow(T actor) {
        return COL_OPERATION.resolveFor(actor).getText().contains(operation) &&
                COL_QUANTITY.resolveFor(actor).getText().contains(payment.getQuantity()) &&
                isCorrectDate(actor) &&
                isDataTrx(actor);
    }

    private <T extends Actor> boolean isCorrectDate(T actor) {
        return COL_CREATION_DATE.resolveFor(actor).getText().contains(DATE_CURRENT) &&
                COL_EXECUTE_DATE.resolveFor(actor).getText().contains(DATE_CURRENT);
    }

    private <T extends Actor> boolean isDataTrx(T actor) {
        return COL_TYPE_OPERATION.resolveFor(actor).getText().contains(payment.getPayType()) &&
                COL_TAGS.resolveFor(actor).getText().contains(payment.getTag()) &&
                COL_VALUE.resolveFor(actor).getText().replace(",", "").contains(payment.getPayValue());
    }

    public static SearchCorrectPaymentRegister onTableMyAuthorizations(Payment payment, String operation) {
        return Tasks.instrumented(SearchCorrectPaymentRegister.class, payment, operation);
    }
}
