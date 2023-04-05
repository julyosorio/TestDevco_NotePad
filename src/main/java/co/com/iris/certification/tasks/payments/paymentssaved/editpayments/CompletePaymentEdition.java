package co.com.iris.certification.tasks.payments.paymentssaved.editpayments;

import co.com.iris.certification.interactions.SavePaymentChanges;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.iris.certification.userinterfaces.payments.ManualPaymentUI.BTN_NEXT;

public class CompletePaymentEdition implements Task {

    private String scenarioForEdition;

    public CompletePaymentEdition(String scenarioForEdition) {
        this.scenarioForEdition = scenarioForEdition;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (scenarioForEdition) {
            case "delete payments":
            case "add payments":
                actor.attemptsTo(
                        Scroll.to(BTN_NEXT).then(Click.on(BTN_NEXT)),
                        SavePaymentChanges.forCompletePayEdition());
                break;
            case "update origin account":
            case "update execute date":
                actor.attemptsTo(
                        Click.on(BTN_NEXT),
                        Click.on(BTN_NEXT),
                        Scroll.to(BTN_NEXT).then(Click.on(BTN_NEXT)),
                        SavePaymentChanges.forCompletePayEdition());
                break;
            default:
                break;
        }
    }

    public static CompletePaymentEdition withTheChangesDone(String scenarioForEdition) {
        return Tasks.instrumented(CompletePaymentEdition.class, scenarioForEdition);
    }
}
