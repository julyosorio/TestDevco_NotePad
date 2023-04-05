package co.com.iris.certification.tasks.transactions.irisaccounts;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.MENU_TRANSACTIONS;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.SPINNER;
import static co.com.iris.certification.userinterfaces.transactions.DashboardTransactionsUI.LABEL_IRIS_ACCOUNTS;
import static co.com.iris.certification.userinterfaces.transactions.irisaccounts.SelectIrisAccountsUI.LIST_ORIGINACCOUNT;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AccessIrisAccountsOption implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(MENU_TRANSACTIONS, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(MENU_TRANSACTIONS),
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(LABEL_IRIS_ACCOUNTS, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LABEL_IRIS_ACCOUNTS),
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(LIST_ORIGINACCOUNT, isVisible()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    public static AccessIrisAccountsOption fromMainMenu() {
        return Tasks.instrumented(AccessIrisAccountsOption.class);
    }
}
