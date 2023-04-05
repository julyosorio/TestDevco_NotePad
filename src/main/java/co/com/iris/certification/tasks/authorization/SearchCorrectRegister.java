package co.com.iris.certification.tasks.authorization;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.authorization.MyAuthorizationsUI.*;
import static co.com.iris.certification.utils.Constants.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class SearchCorrectRegister implements Task {

    private InfoTrx infoTrx;
    private String operation;
    private String typeTransaction;
    public SearchCorrectRegister(InfoTrx infoTrx, String operation) {
        this.infoTrx = infoTrx;
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
               COL_QUANTITY.resolveFor(actor).getText().contains("1") &&
               isCorrectDate(actor) &&
               isDataTrx(actor);
   }

    private <T extends Actor> boolean isCorrectDate(T actor) {
        return COL_CREATION_DATE.resolveFor(actor).getText().contains(DATE_CURRENT) &&
                COL_EXECUTE_DATE.resolveFor(actor).getText().contains(DATE_CURRENT);
    }

    private <T extends Actor> boolean isDataTrx(T actor) {
        if (infoTrx.getTypeTransaction().equalsIgnoreCase("Cuentas iris")) {
            typeTransaction = IRIS_BANK;
        } else {
            typeTransaction = infoTrx.getTypeTransaction();
        }
        return COL_TYPE_OPERATION.resolveFor(actor).getText().contains(typeTransaction) &&
                COL_TAGS.resolveFor(actor).getText().equals(infoTrx.getTag()) &&
                COL_VALUE.resolveFor(actor).getText().replace(",", "").contains(infoTrx.getTransferValue());
    }

    public static SearchCorrectRegister onTableMyAuthorizations(InfoTrx infoTrx, String operation) {
        return Tasks.instrumented(SearchCorrectRegister.class, infoTrx, operation);
    }
}
