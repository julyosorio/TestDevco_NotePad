package co.com.iris.certification.tasks.payments.paymentssaved;

import co.com.iris.certification.interactions.GoToNextPage;
import co.com.iris.certification.models.transactions.Payment;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.List;

import static co.com.iris.certification.userinterfaces.payments.paymentssaved.PaymentsSavedUI.ROW_ID_PAY;

public class LookForTheCorrectRecord implements Task {
    private Payment infoPay;
    public LookForTheCorrectRecord(Payment infoPay) {
        this.infoPay = infoPay;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> listPayments = ROW_ID_PAY.resolveAllFor(actor);
        int i = 0;
        while (i < listPayments.size()) {
            if (listPayments.get(i).getText().equalsIgnoreCase(infoPay.getPayId())) {
                actor.remember("numRow", i);
                actor.attemptsTo(Scroll.to(listPayments.get(i)));
                break;
            } else {
                if (i == listPayments.size() - 1) {
                    actor.attemptsTo(GoToNextPage.forFindTheCorrectRecord());
                    i = 0;
                    listPayments = ROW_ID_PAY.resolveAllFor(actor);
                } else{
                    i++;
                }
            }
        }
    }

    public static LookForTheCorrectRecord inSavedPaymentsTable(Payment infoPay) {
        return Tasks.instrumented(LookForTheCorrectRecord.class, infoPay);
    }
}
