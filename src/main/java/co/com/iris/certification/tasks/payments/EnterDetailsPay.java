package co.com.iris.certification.tasks.payments;

import co.com.iris.certification.exceptions.PayIDUsedBefore;
import co.com.iris.certification.interactions.SelectTag;
import co.com.iris.certification.models.transactions.Payment;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.payments.ManualPaymentUI.*;
import static co.com.iris.certification.userinterfaces.transactions.TagUI.LIST_TAG;
import static co.com.iris.certification.userinterfaces.transactions.TagUI.OPTLST_TAG;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class EnterDetailsPay implements Task {
    private Payment infoPay;

    public EnterDetailsPay(Payment infoPay) {
        this.infoPay = infoPay;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        enterPayID(actor);
        actor.should(seeThat(the(LABEL_ID_PAY_ERROR_MESSAGE), isNotVisible())
                .orComplainWith(PayIDUsedBefore.class, "Pay ID entered already was used."));
        addTag(actor);
    }
    public void enterPayID(Actor actor) {
        actor.attemptsTo(Enter.theValue(infoPay.getPayId()).into(TEXT_PAYMENT_ID).thenHit(Keys.TAB),
                WaitUntil.the(LIST_TAG, isEnabled()).forNoMoreThan(WAITING_TIME).seconds());
    }
    public void addTag(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(LIST_TAG, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LIST_TAG),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                SelectTag.fromList(OPTLST_TAG, infoPay.getTag()),
                Click.on(BTN_NEXT)
        );
    }
    public static EnterDetailsPay toIdentifyTheCurrentPayTransaction(Payment infoPay) {
        return Tasks.instrumented(EnterDetailsPay.class, infoPay);
    }
}
