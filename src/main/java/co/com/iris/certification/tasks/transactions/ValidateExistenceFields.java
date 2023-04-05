package co.com.iris.certification.tasks.transactions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.transactions.TransactionSummaryUI.*;

public class ValidateExistenceFields implements Task {
    private String typeTransaction;
    public ValidateExistenceFields(String typeTransaction){
        this.typeTransaction =typeTransaction;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(LABEL_ORIGIN_ACCOUNT_OWNER).textContent().isNotEmpty(),
                Ensure.that(LABEL_TYPE_ORIGIN_ACCOUNT).textContent().isNotEmpty(),
                Ensure.that(LABEL_DESTINATION_ACCOUNT_OWNER).textContent().isNotEmpty(),
                Ensure.that(LABEL_TYPE_DESTINATION_ACCOUNT).textContent().isNotEmpty(),
                Check.whether(typeTransaction.equalsIgnoreCase("other bank")).andIfSo(
                        Ensure.that(LABEL_NUM_DOC_ACCOUNT_DESTINATION).textContent().isNotEmpty(),
                        Ensure.that(LABEL_COST_TRANSACTION).textContent().isNotEmpty()
                ),
                WaitUntil.the(BTN_EXECUTE_TRANSACTION, WebElementStateMatchers.isClickable()).forNoMoreThan(20).seconds()
        );
    }

    public static ValidateExistenceFields inSummaryPage(String  typeTransaction){
        return Tasks.instrumented(ValidateExistenceFields.class,typeTransaction);
    }
}
