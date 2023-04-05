package co.com.iris.certification.questions.paymentssaved;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.iris.certification.userinterfaces.payments.paymentssaved.PaymentsSavedUI.BTN_NEXT_PAGE;

public class ValidateStatusDisabledButton implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return BTN_NEXT_PAGE.resolveFor(actor).getAttribute("class").contains("disabled");
    }

    public static ValidateStatusDisabledButton nextPageInPaymentsSavedTable() {
        return new ValidateStatusDisabledButton();
    }
}
