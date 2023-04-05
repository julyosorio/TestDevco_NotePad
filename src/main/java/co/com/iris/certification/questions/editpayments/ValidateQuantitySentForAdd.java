package co.com.iris.certification.questions.editpayments;

import co.com.iris.certification.userinterfaces.payments.AddPayToListUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.iris.certification.userinterfaces.payments.AddPayToListUI.LABEL_QUATITY_PAYMENTS_ADDED_TO_LIST;

public class ValidateQuantitySentForAdd implements Question<Boolean> {
    private String quantityForAdd;

    public ValidateQuantitySentForAdd(String quantityForAdd){
        this.quantityForAdd = quantityForAdd;
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(Scroll.to(LABEL_QUATITY_PAYMENTS_ADDED_TO_LIST));
        int quantity = Text.of(AddPayToListUI.LABEL_QUATITY_PAYMENTS_ADDED_TO_LIST).asInteger().answeredBy(actor) + Integer.parseInt(quantityForAdd);
        return quantity <= 50;
    }

    public static ValidateQuantitySentForAdd newPaymentsToTheList(String quantityForAdd){
        return new ValidateQuantitySentForAdd(quantityForAdd);
    }
}
