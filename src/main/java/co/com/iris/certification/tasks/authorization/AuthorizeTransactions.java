package co.com.iris.certification.tasks.authorization;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.authorization.MenuAuthorizationUI.MENU_MY_AUTHORIZATIONS;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.MENU_PENDING_TRX;
import static co.com.iris.certification.userinterfaces.transactions.pendingtransaction.PendingTransactionUI.LABEL_AUTHORIZATION;
import static co.com.iris.certification.utils.Constants.IRIS_BANK;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class AuthorizeTransactions implements Task {

    private InfoTrx infoTrx;
    private String operation;

    public AuthorizeTransactions(InfoTrx infoTrx, String operation) {
        this.infoTrx = infoTrx;
        this.operation = operation;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (infoTrx.getTypeTransaction().equalsIgnoreCase("Cuentas iris")) {
           infoTrx.setTypeTransaction(IRIS_BANK);
        }
        actor.attemptsTo(
                WaitUntil.the(LOADSCREEN_SPINNER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(MENU_PENDING_TRX),
                Click.on(LABEL_AUTHORIZATION),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(MENU_MY_AUTHORIZATIONS),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                SelectFiltersTrx.forGetTheRecordPendingAuthorization(infoTrx,operation),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    public static AuthorizeTransactions goToAuthorization(InfoTrx infoTrx, String operation) {
        return Tasks.instrumented(AuthorizeTransactions.class, infoTrx, operation);
    }
}
