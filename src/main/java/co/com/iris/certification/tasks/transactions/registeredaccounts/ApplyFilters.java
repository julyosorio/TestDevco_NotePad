package co.com.iris.certification.tasks.transactions.registeredaccounts;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.PageElement;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.transactions.registeredaccounts.RegisteredAccountsUI.*;
import static co.com.iris.certification.utils.Constants.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class ApplyFilters implements Task {
    private InfoTrx infoTrx;
    private String typeTransaction;

    public ApplyFilters(InfoTrx infoTrx, String typeTransaction) {
        this.infoTrx = infoTrx;
        this.typeTransaction = typeTransaction;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        switch (typeTransaction) {
            case OTHER_BANKS:
                actor.attemptsTo(
                        Click.on(BTN_GO_TO_FILTER),
                        Enter.theValue(infoTrx.getOwnerDestinationAccount()).into(TEXT_SEARCH_HOLDER),
                        Click.on(TEXT_BANK),
                        Click.on(PageElement.containingText(infoTrx.getDestinationBank()).inside(TEXT_BANK)),
                        Click.on(TEXT_ACCOUNT_TYPE),
                        Click.on(PageElement.containingText(infoTrx.getDestinationAccountType()).inside(TEXT_ACCOUNT_TYPE)),
                        Click.on(TEXT_STATUS),
                        Click.on(PageElement.containingText("En Procesamiento").inside(TEXT_STATUS))
                );
                break;
            case IRIS_ACCOUNTS:
                actor.attemptsTo(
                        Click.on(BTN_GO_TO_FILTER),
                        Click.on(TEXT_BANK),
                        Click.on(PageElement.containingText("Iris").inside(TEXT_BANK)),
                        Click.on(TEXT_STATUS),
                        Click.on(PageElement.containingText("Exitosa").inside(TEXT_STATUS))
                );
                break;

            case DELETE_REGISTERED_ACCOUNT:
                actor.attemptsTo(
                        Click.on(BTN_GO_TO_FILTER),
                        Click.on(TEXT_STATUS),
                        Click.on(PageElement.containingText("Exitosa").inside(TEXT_STATUS))
                );
                break;
        }
        actor.attemptsTo(
                Click.on(BTN_APPLY_FILTERS),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );

    }

    public static ApplyFilters toTableOfRegisteredAccounts(InfoTrx infoTrx, String typeTransaction) {
        return Tasks.instrumented(ApplyFilters.class, infoTrx, typeTransaction);
    }
}
