package co.com.iris.certification.tasks.transactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.MENU_PENDING_TRX;
import static co.com.iris.certification.userinterfaces.transactions.pendingtransaction.PendingTransactionUI.LABEL_GO_TO_PAYMENTS;
import static co.com.iris.certification.userinterfaces.transactions.pendingtransaction.PendingTransactionUI.LABEL_SCHEDULED;
import static co.com.iris.certification.utils.Constants.TYPE_OPERATION_PAYMENTS;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class MenuPendingTransactions implements Task {

    private String typeTransaction;

    public MenuPendingTransactions(String typeTransaction){
        this.typeTransaction = typeTransaction;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(MENU_PENDING_TRX),
                Click.on(LABEL_SCHEDULED),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Check.whether(typeTransaction.equals(TYPE_OPERATION_PAYMENTS))
                        .andIfSo(Click.on(LABEL_GO_TO_PAYMENTS))
        );
    }
    public static MenuPendingTransactions goToTheMenuProgrammed(String typeTransaction){
        return Tasks.instrumented(MenuPendingTransactions.class, typeTransaction);
    }
}
