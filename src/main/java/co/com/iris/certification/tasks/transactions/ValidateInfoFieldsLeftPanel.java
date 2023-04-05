package co.com.iris.certification.tasks.transactions;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.iris.certification.userinterfaces.transactions.WizardTransactionUI.*;
import static co.com.iris.certification.utils.Constants.VALUE_DEFAULT_FIELD_PERIODICITY;
import static co.com.iris.certification.utils.SetData.getCurrentDateFormatDayMonthYear;

public class ValidateInfoFieldsLeftPanel implements Task {
    private InfoTrx trx;
    private String typeTransaction;

    public ValidateInfoFieldsLeftPanel(InfoTrx trx, String typeTransaction) {
        this.trx = trx;
        this.typeTransaction = typeTransaction;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String value = LABEL_TRANSFER_VALUE_LEFT_PANEL.resolveFor(actor).getText().replace("$", "").replace(",", "");

        if(typeTransaction.equals("iris accounts")){
            actor.attemptsTo(
                    Ensure.that(LABEL_ACCOUNT_ORIGIN_LEFT_PANEL).textContent().asAString().containsIgnoringCase(trx.getOriginAccountNumber().substring(trx.getOriginAccountNumber().length() - 4)),
                    Ensure.that(LABEL_ACCOUNT_DESTINATION_LEFT_PANEL).textContent().asAString().containsIgnoringCase(trx.getDestinationAccountNumber().substring(trx.getDestinationAccountNumber().length() - 4)),
                    Ensure.that(value).asAFloat().isEqualTo(Float.parseFloat(trx.getTransferValue())),
                    Ensure.that(LABEL_TAG_LEFT_PANEL).textContent().isEqualToIgnoringCase(trx.getTag()),
                    Check.whether(trx.getDescription() != null).andIfSo(
                            Ensure.that(LABEL_DESCRIPTION_LEFT_PANEL).textContent().containsIgnoringCase(trx.getDescription())
                    ));
            if(trx.getPeriodicity() != null) {
                actor.attemptsTo(
                        Ensure.that(LABEL_PERIODICITY_LEFT_PANEL).textContent().isEqualToIgnoringCase(trx.getPeriodicity()),
                        Ensure.that(LABEL_EXECUTION_DATE_LEFT_PANEL).textContent().isEqualToIgnoringCase(trx.getStartTransactionDate()),
                        Check.whether(trx.getFinalTransactionDate() != null).andIfSo(
                                Ensure.that(LABEL_FINAL_DATE_LEFT_PANEL).textContent().isEqualToIgnoringCase(trx.getFinalTransactionDate())
                        ));
            } else{
                actor.attemptsTo(
                        Ensure.that(LABEL_PERIODICITY_LEFT_PANEL).textContent().containsIgnoringCase(VALUE_DEFAULT_FIELD_PERIODICITY),
                        Ensure.that(LABEL_EXECUTION_DATE_LEFT_PANEL).textContent().containsIgnoringCase(getCurrentDateFormatDayMonthYear())
                );
            }
        }
    }

    public static ValidateInfoFieldsLeftPanel inSummaryPage(InfoTrx trx, String typeTransaction) {
        return Tasks.instrumented(ValidateInfoFieldsLeftPanel.class, trx, typeTransaction);
    }
}
