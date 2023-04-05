package co.com.iris.certification.tasks.payments.paymentssaved;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.SPINNER;
import static co.com.iris.certification.userinterfaces.payments.paymentssaved.PaymentsSavedUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DeletePay implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        int numPos = OnStage.theActorInTheSpotlight().recall("numRow");
        String xpathBtnOptionsPay = BTN_OPTIONS_PAY.selectors(BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).getDriver()).get(0).toString().replaceAll("By.xpath:","").replaceAll("num", String.valueOf(numPos+1));
        actor.attemptsTo(
                Click.on(xpathBtnOptionsPay),
                WaitUntil.the(BTN_DELETE_PAY,isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_DELETE_PAY),
                WaitUntil.the(BTN_CONFIRM_DELETE_PAY,isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_CONFIRM_DELETE_PAY),
                WaitUntil.the(SPINNER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds());
    }

    public static DeletePay fromSavedPaymentsTable(){
        return Tasks.instrumented(DeletePay.class);
    }
}
