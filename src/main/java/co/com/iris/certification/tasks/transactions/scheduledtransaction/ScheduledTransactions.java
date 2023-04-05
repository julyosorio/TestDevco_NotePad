package co.com.iris.certification.tasks.transactions.scheduledtransaction;

import co.com.iris.certification.interactions.SelectTag;
import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.PageElement;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.transactions.scheduledtransaction.ScheduledTransactionsFilterUI.*;
import static co.com.iris.certification.utils.Constants.OTHER_BANKS;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class ScheduledTransactions implements Task {
    private InfoTrx infoTrx;
    private String trxType;
    private String destinationBank;

    public ScheduledTransactions(InfoTrx infoTrx, String trxType) {

        this.infoTrx = infoTrx;
        this.trxType=trxType;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (trxType.equals(OTHER_BANKS)){
            destinationBank = infoTrx.getDestinationBank();
        }else {
            destinationBank = "Iris";
        }

        actor.attemptsTo(
                Click.on(BTN_FILTER),
                Click.on(LIST_TRANSACTION_TYPES),
                Click.on(PageElement.containingText(trxType).inside(LIST_TRANSACTION_TYPES)),
                Click.on(LIST_PRODUCTS),
                Click.on(PageElement.containingText(infoTrx.getOriginAccountNumber()).inside(LIST_PRODUCTS)),
                Click.on(LIST_PRODUCTS),
                Click.on(LIST_DESTINATION_BANK),
                Click.on(PageElement.containingText(destinationBank).inside(LIST_DESTINATION_BANK)),
                Click.on(LIST_PERIODICITY),
                Click.on(PageElement.containingText(infoTrx.getPeriodicity()).inside(LIST_PERIODICITY)),
                Click.on(LIST_TAGS),
                SelectTag.fromList(LIST_TAGS,infoTrx.getTag()),
                Click.on(BTN_APPLY_FILTER),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))
        );
    }

    public static ScheduledTransactions applyFilters(InfoTrx infoTrx, String trxType) {
        return Tasks.instrumented(ScheduledTransactions.class, infoTrx, trxType);
    }
}
