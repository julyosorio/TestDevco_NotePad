package co.com.iris.certification.tasks.transactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.transactions.scheduledtransaction.PeriodicTransactionDetailUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DeleteScheduledTrx implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_ELIMINATION_TRX) ,
                WaitUntil.the(BTN_DELETE_POP_UP, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(BTN_DELETE_POP_UP),
                WaitUntil.the(TEXT_MSG1_POP_UP, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))
        );
    }
    public static DeleteScheduledTrx fromTheDetail(){
        return Tasks.instrumented(DeleteScheduledTrx.class);
    }
}
