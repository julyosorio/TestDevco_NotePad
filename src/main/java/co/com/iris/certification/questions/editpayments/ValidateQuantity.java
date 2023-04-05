package co.com.iris.certification.questions.editpayments;

import co.com.iris.certification.userinterfaces.payments.AddPayToListUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.iris.certification.userinterfaces.payments.AddPayToListUI.LABEL_QUATITY_PAYMENTS_ADDED_TO_LIST;

public class ValidateQuantity implements Question<Boolean> {
    private String quantityForDelete;

    public ValidateQuantity(String quantityForDelete) {
        this.quantityForDelete = quantityForDelete;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(Scroll.to(LABEL_QUATITY_PAYMENTS_ADDED_TO_LIST));
        int quantityPaymentsInList = Integer.parseInt(AddPayToListUI.LABEL_QUATITY_PAYMENTS_ADDED_TO_LIST.resolveFor(actor).getText());
        return Integer.parseInt(quantityForDelete) < quantityPaymentsInList;
    }

    public static ValidateQuantity forDeletePayments(String quantityForDelete) {
        return new ValidateQuantity(quantityForDelete);
    }
}
