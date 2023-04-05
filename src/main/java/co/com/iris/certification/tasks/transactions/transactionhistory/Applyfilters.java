package co.com.iris.certification.tasks.transactions.transactionhistory;

import co.com.iris.certification.interactions.SelectTag;
import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.PageElement;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.transactionshistory.transactions.TransactionHistoryUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class Applyfilters implements Task {

    private InfoTrx infoTrx;
    private String typeTrx;

    public Applyfilters(InfoTrx infoTrx, String typeTrx){
        this.infoTrx=infoTrx;
        this.typeTrx=typeTrx;

    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_GO_FILTER),
                WaitUntil.the(LIST_TRANSACTION_TYPES, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LIST_TRANSACTION_TYPES),
                Click.on(PageElement.containingText(typeTrx).inside(LIST_TRANSACTION_TYPES)),
                WaitUntil.the(LIST_ORIGIN_PRODUCT, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LIST_ORIGIN_PRODUCT),
                Click.on(PageElement.containingText(infoTrx.getOriginAccountNumber()).inside(LIST_ORIGIN_PRODUCT))
                        .then(Click.on(LIST_ORIGIN_PRODUCT)),
                WaitUntil.the(LIST_DESTINATION_BANK, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LIST_DESTINATION_BANK),
                Click.on(PageElement.containingText(infoTrx.getDestinationBank()).inside(LIST_DESTINATION_BANK)),
                Click.on(LIST_TAGS),
                SelectTag.fromList(OPTLST_TAGS,infoTrx.getTag()),
                Click.on(BTN_APPLY_FILTER)
        );

    }
    public static Applyfilters transactionHistoryTable(InfoTrx infoTrx, String typeTrx){
        return Tasks.instrumented(Applyfilters.class, infoTrx, typeTrx);
    }
}
