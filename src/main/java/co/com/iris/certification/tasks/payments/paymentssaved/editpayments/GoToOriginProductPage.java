package co.com.iris.certification.tasks.payments.paymentssaved.editpayments;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.SPINNER;
import static co.com.iris.certification.userinterfaces.payments.ManualPaymentUI.BTN_BACK;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToOriginProductPage implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(BTN_BACK).then(Click.on(BTN_BACK)),
                WaitUntil.the(BTN_BACK, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_BACK),
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    public static GoToOriginProductPage forUpdateTheAccount(){
        return Tasks.instrumented(GoToOriginProductPage.class);
    }
}
