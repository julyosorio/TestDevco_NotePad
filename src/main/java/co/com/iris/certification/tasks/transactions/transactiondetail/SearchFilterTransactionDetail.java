package co.com.iris.certification.tasks.transactions.transactiondetail;

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
import static co.com.iris.certification.userinterfaces.transactions.transactiondetail.TransactionDetailUI.*;
import static co.com.iris.certification.utils.Constants.TRANSFER;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;


public class SearchFilterTransactionDetail implements Task {
    private InfoTrx infoTrx;

    public SearchFilterTransactionDetail(InfoTrx dataTrx) {
        this.infoTrx = dataTrx;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(BTN_OPEN_SIDEWINDOW_FILTER),
                Click.on(LIST_PRODUCTS),
                Click.on(PageElement.containingText(infoTrx.getOriginAccountNumber()).inside(LIST_PRODUCTS)),
                Click.on(LIST_PRODUCTS),
                Click.on(LIST_OPERATION_TYPE),
                Click.on(PageElement.containingText(TRANSFER).inside(LIST_OPERATION_TYPE)),
                Click.on(LIST_OPERATION_TYPE),
                Click.on(LIST_TAGS),
                SelectTag.fromList(OPTLST_TAGS,infoTrx.getTag()),
                Click.on(BUTTON_APPLY_FILTER)
        );
    }

    public static SearchFilterTransactionDetail withDetails(InfoTrx info) {
        return Tasks.instrumented(SearchFilterTransactionDetail.class, info);
    }
}
