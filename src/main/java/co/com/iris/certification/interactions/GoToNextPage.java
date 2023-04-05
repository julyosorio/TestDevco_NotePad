package co.com.iris.certification.interactions;

import co.com.iris.certification.exceptions.PayIDNotFound;
import co.com.iris.certification.questions.paymentssaved.ValidateStatusDisabledButton;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matchers;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.SPINNER;
import static co.com.iris.certification.userinterfaces.payments.paymentssaved.PaymentsSavedUI.BTN_NEXT_PAGE;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class GoToNextPage implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(BTN_NEXT_PAGE),
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
        actor.should(
                seeThat(ValidateStatusDisabledButton.nextPageInPaymentsSavedTable(), Matchers.equalTo(false))
                .orComplainWith(PayIDNotFound.class, "The record you are searching for cannot be found in the table")
        );
        actor.attemptsTo(
                WaitUntil.the(BTN_NEXT_PAGE, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_NEXT_PAGE),
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    public static GoToNextPage forFindTheCorrectRecord() {
        return Tasks.instrumented(GoToNextPage.class);
    }
}
