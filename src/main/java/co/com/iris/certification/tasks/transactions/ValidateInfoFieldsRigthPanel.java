package co.com.iris.certification.tasks.transactions;


import co.com.iris.certification.models.transactions.InfoTrx;
import co.com.iris.certification.utils.SetData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.WAIT_LOADER;
import static co.com.iris.certification.userinterfaces.transactions.TransactionSummaryUI.*;
import static co.com.iris.certification.utils.Constants.TRANSFER_DOESNT_HAVE_PERIODICITY;

public class ValidateInfoFieldsRigthPanel implements Task {

    private InfoTrx trx;
    private String typeTransaction;

    public ValidateInfoFieldsRigthPanel(InfoTrx trx, String typeTransaction) {
        this.trx = trx;
        this.typeTransaction = typeTransaction;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String value = LABEL_TRX_AMMOUNT.resolveFor(actor).getText().replace("$", "").replace(",", "");
        actor.attemptsTo(
                WaitUntil.the(WAIT_LOADER, WebElementStateMatchers.isNotVisible()).forNoMoreThan(40).seconds(),
                Check.whether(typeTransaction.equalsIgnoreCase("Other bank")).andIfSo(
                        Ensure.that(LABEL_DESTINATION_BANK).textContent().containsIgnoringCase(trx.getDestinationBank())
                ),
                Ensure.that(LABEL_ORIGIN_ACCOUNT_NUMBER).textContent().containsIgnoringCase(trx.getOriginAccountNumber().substring(trx.getOriginAccountNumber().length() - 4)),
                Ensure.that(LABEL_DESTINATION_ACCOUNT_NUMBER).textContent().containsIgnoringCase(trx.getDestinationAccountNumber().substring(trx.getDestinationAccountNumber().length() - 4)),
                Ensure.that(LABEL_TAG).textContent().containsIgnoringCase(trx.getTag()),
                Check.whether(trx.getDescription() != null).andIfSo(
                        Ensure.that(LABEL_DESCRIPTION_TAG).textContent().containsIgnoringCase(trx.getDescription())),
                Ensure.that(value).isEqualToIgnoringCase(trx.getTransferValue()),
                validatePeriodicity()
                );
    }
    public Performable validatePeriodicity() {
        return Check.whether(trx.getPeriodicity() != null).andIfSo(
                Ensure.that(LABEL_PERIODICITY).textContent().containsIgnoringCase(trx.getPeriodicity()),
                Ensure.that(LABEL_EXECUTION_DATE).textContent().containsIgnoringCase(trx.getStartTransactionDate()),
                validateFinalDate()
        ).otherwise(Ensure.that(LABEL_PERIODICITY).textContent().containsIgnoringCase(TRANSFER_DOESNT_HAVE_PERIODICITY),
                Ensure.that(LABEL_EXECUTION_DATE).textContent().containsIgnoringCase(SetData.getCurrentDateFormatDayMonthYear()));
    }
    public Performable validateFinalDate() {
        return Check.whether(trx.getFinalTransactionDate() != null).andIfSo(
                Ensure.that(LABEL_FINAL_DATE).textContent().containsIgnoringCase(trx.getFinalTransactionDate()),
                Ensure.that(LABEL_MESSAGE_FOR_SCHEDULE_TRANSACTIONS).textContent().containsIgnoringCase("Esto significa que esta transferencia se repetirá desde el " + trx.getStartTransactionDate()),
                Ensure.that(LABEL_MESSAGE_FOR_SCHEDULE_TRANSACTIONS).textContent().containsIgnoringCase("hasta el " + trx.getFinalTransactionDate())
        );
    }

    public static ValidateInfoFieldsRigthPanel inSummaryPage(InfoTrx trx, String typeTransaction) {
        return Tasks.instrumented(ValidateInfoFieldsRigthPanel.class, trx, typeTransaction);
    }
}
