package co.com.iris.certification.tasks.transactions.registeredaccounts;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.MENU_TRANSACTIONS;
import static co.com.iris.certification.userinterfaces.transactions.DashboardTransactionsUI.LABEL_REGISTERED_ACCOUNTS;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class RegisterAccount implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MENU_TRANSACTIONS, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(MENU_TRANSACTIONS),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(LABEL_REGISTERED_ACCOUNTS, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LABEL_REGISTERED_ACCOUNTS),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    public static RegisterAccount goToMenu(){
        return Tasks.instrumented(RegisterAccount.class);
    }
}
