package co.com.iris.certification.tasks.transactions.ownaccounts;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.MENU_TRANSACTIONS;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.WAIT_LOADER;
import static co.com.iris.certification.userinterfaces.transactions.DashboardTransactionsUI.LABEL_OWN_ACCOUNTS;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class TransfersOfOwnAccounts implements Task {
    private InfoTrx infoTrx;

    public TransfersOfOwnAccounts(InfoTrx infoTrx){
        this.infoTrx = infoTrx;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MENU_TRANSACTIONS, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(MENU_TRANSACTIONS),
                WaitUntil.the(LABEL_OWN_ACCOUNTS,isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LABEL_OWN_ACCOUNTS),
                WaitUntil.the(WAIT_LOADER, isNotVisible()).forNoMoreThan(WAITING_TIME).seconds()
                );
    }
    public static TransfersOfOwnAccounts goTo(InfoTrx infoTrx){
        return Tasks.instrumented(TransfersOfOwnAccounts.class, infoTrx);
    }
}
