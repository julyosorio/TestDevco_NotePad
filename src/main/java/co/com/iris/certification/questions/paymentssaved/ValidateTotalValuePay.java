package co.com.iris.certification.questions.paymentssaved;

import co.com.iris.certification.utils.SetData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.math.BigDecimal;

public class ValidateTotalValuePay implements Question<BigDecimal> {

    private Target target;
    private int position;

    public ValidateTotalValuePay(Target target, int position) {
        this.target = target;
        this.position = position;
    }

    @Override
    public BigDecimal answeredBy(Actor actor) {
        return SetData.formatValueBigDecimal(Text.ofEach(target).asListOf(String.class).answeredBy(actor).get(position));
    }

    public static ValidateTotalValuePay inRecordPaySaved(Target target, int position){
        return new ValidateTotalValuePay(target,position);
    }
}
