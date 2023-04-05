package co.com.iris.certification.tasks.payments.paymentssaved.editpayments;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.SPINNER;
import static co.com.iris.certification.userinterfaces.payments.paymentssaved.PaymentsSavedUI.BTN_EDIT_PAY;
import static co.com.iris.certification.userinterfaces.payments.paymentssaved.PaymentsSavedUI.BTN_OPTIONS_PAY;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectEditOption implements Task {

    @Override
    public <T extends Actor> void performAs(T t) {
        int row = t.recall("numRow");
        String xpathBtnOptionsPay = BTN_OPTIONS_PAY.selectors(BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).getDriver()).get(0).toString().replace("By.xpath:","").replace("num", String.valueOf(row+1));
        t.attemptsTo(
                WaitUntil.the(xpathBtnOptionsPay, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(xpathBtnOptionsPay),
                Click.on(BTN_EDIT_PAY),
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    public static SelectEditOption fromPaymentThatRequestUpdate(){
        return Tasks.instrumented(SelectEditOption.class);
    }
}
