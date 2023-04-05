package co.com.iris.certification.questions.paymentssaved;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.iris.certification.userinterfaces.payments.paymentssaved.PaymentsSavedUI.ROW_CREATE_DATE_PAY;

public class ValidateRowPay implements Question<String> {
    private Target target;
    private int position;

    public ValidateRowPay(Target target, int position) {
        this.target = target;
        this.position = position;
    }

    @Override
    public String answeredBy(Actor actor) {
        if (target == ROW_CREATE_DATE_PAY) {
           return Text.ofEach(target).asListOf(String.class).answeredBy(actor).get(position).substring(0, 10);
        }
        return  Text.ofEach(target).asListOf(String.class).answeredBy(actor).get(position);
    }

    public static ValidateRowPay inPaySaved(Target target, int position) {
        return new ValidateRowPay(target, position);
    }
}
