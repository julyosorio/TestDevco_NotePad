package co.com.iris.certification.tasks.transactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.iris.certification.userinterfaces.transactions.voucher.SuccessfulVoucherUI.LABEL_TRANSACTION_DATE;

public class GetVoucherDate implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        String date = Text.of(LABEL_TRANSACTION_DATE).answeredBy(actor);
        actor.remember("TransactionExecutionDate", date);
        Serenity.recordReportData().withTitle("Execution date was: ").andContents(date);
    }

    public static GetVoucherDate rememberDate(){
        return Tasks.instrumented(GetVoucherDate.class);
    }
}
