package co.com.iris.certification.tasks.payments;

import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.transactions.Payment;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.payments.AddPayToListUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class AddPay implements Task {
    private Payment infoPay;

    public AddPay(Payment infoPay){
        this.infoPay = infoPay;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(LOADSCREEN_SPINNER.isVisibleFor(actor)).andIfSo(
                        WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()),
                Click.on(LIST_DESTINATION_BANK),
                SelectOption.fromList(OPTLST_DESTINATION_BANK, infoPay.getDestinationBank()),
                Click.on(LIST_DESTINATION_ACCOUNT),
                SelectOption.fromList(OPTLST_DESTINATION_ACCOUNT, infoPay.getDestinationAccountNumber()),
                Enter.theValue(infoPay.getPayValue()).into(TEXT_AMOUNT).thenHit(Keys.TAB),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds().then(Scroll.to(LABEL_ADD_PAY))
        );
    }

    public static AddPay toVerifyTheValueEntered(Payment infoPay){
        return Tasks.instrumented(AddPay.class, infoPay);
    }
}
