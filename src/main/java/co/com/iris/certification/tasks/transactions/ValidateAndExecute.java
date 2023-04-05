package co.com.iris.certification.tasks.transactions;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.transactions.TransactionSummaryUI.BTN_EXECUTE_TRANSACTION;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class ValidateAndExecute implements Task {

    private InfoTrx trx;
    private String emailUser;
    private String typeTransaction;

    public ValidateAndExecute(InfoTrx trx, String emailUser, String typeTransaction) {
        this.trx = trx;
        this.emailUser = emailUser;
        this.typeTransaction = typeTransaction;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidateInfoFieldsRigthPanel.inSummaryPage(trx,typeTransaction),
                ValidateInfoFieldsLeftPanel.inSummaryPage(trx,typeTransaction),
                ValidateExistenceFields.inSummaryPage(typeTransaction),
                Scroll.to(BTN_EXECUTE_TRANSACTION),
                Click.on(BTN_EXECUTE_TRANSACTION),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
             //   GetOtp.byEmail(emailUser),
             //   SendCorrectOtp.with()
        );

    }

    public static ValidateAndExecute infoOfTransaction(InfoTrx trx, String emailUser, String typeTransaction) {
        return Tasks.instrumented(ValidateAndExecute.class, trx, emailUser, typeTransaction);
    }
}
