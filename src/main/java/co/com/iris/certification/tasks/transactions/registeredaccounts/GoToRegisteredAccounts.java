package co.com.iris.certification.tasks.transactions.registeredaccounts;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.transactions.registeredaccounts.AccountRegistrationFormUI.BTN_OTHER_BANKS;
import static co.com.iris.certification.userinterfaces.transactions.registeredaccounts.RegisteredAccountsUI.BTN_REGISTER_ACCOUNT;
import static co.com.iris.certification.utils.Constants.OTHER_BANKS;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class GoToRegisteredAccounts implements Task {

    private String typeTransaction;

    public GoToRegisteredAccounts(String typeTransaction){
        this.typeTransaction=typeTransaction;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_REGISTER_ACCOUNT, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_REGISTER_ACCOUNT),
                Check.whether(typeTransaction.equals(OTHER_BANKS))
                        .andIfSo(Click.on(BTN_OTHER_BANKS))
        );
    }

    public static GoToRegisteredAccounts menu(String typeTransaction) {
        return Tasks.instrumented(GoToRegisteredAccounts.class, typeTransaction);
    }
}
