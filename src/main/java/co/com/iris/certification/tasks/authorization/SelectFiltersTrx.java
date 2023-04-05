package co.com.iris.certification.tasks.authorization;

import co.com.iris.certification.interactions.SelectTag;
import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ui.PageElement;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.authorization.FilterAuthorizationsUI.*;
import static co.com.iris.certification.userinterfaces.authorization.PendingBankAuthorizationsUI.COL_CREATION_DATE;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class SelectFiltersTrx implements Task {
    private String operation;
    private InfoTrx infoTrx;

    public SelectFiltersTrx(InfoTrx infoTrx, String operation) {
        this.infoTrx = infoTrx;
        this.operation = operation;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_FILTER),
                Click.on(LIST_OPTION_OPERATION),
                Click.on(PageElement.containingText(operation).inside(LIST_OPTION_OPERATION)),
                Click.on(LIST_TYPE_OPERATION),
                Click.on(PageElement.containingText(infoTrx.getTypeTransaction()).inside(LIST_TYPE_OPERATION)),
                Click.on(LIST_TAG),
                SelectTag.fromList(OPTLIST_TAG,infoTrx.getTag()),
                MoveMouse.to(BTN_APLLY_FILTERS),
                Scroll.to(BTN_APLLY_FILTERS),
                Click.on(BTN_APLLY_FILTERS),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Scroll.to(COL_CREATION_DATE)
        );
    }

    public static SelectFiltersTrx forGetTheRecordPendingAuthorization(InfoTrx infoTrx, String operation){
        return Tasks.instrumented(SelectFiltersTrx.class, infoTrx,operation);
    }
}
