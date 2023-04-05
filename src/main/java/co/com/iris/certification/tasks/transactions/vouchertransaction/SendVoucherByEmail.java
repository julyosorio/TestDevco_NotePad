package co.com.iris.certification.tasks.transactions.vouchertransaction;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.transactions.voucher.SuccessfulVoucherUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class SendVoucherByEmail implements Task {
    private InfoTrx infoTrx;
    
    public SendVoucherByEmail(InfoTrx data)
    {
        infoTrx = data;
    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LIST_VOUCHER_SEND),
                Click.on(OPTLST_VOUCHER_SEND_BY_EMAIL),
                Enter.theValue(infoTrx.getEmailUser()).into(TEXT_EMAIL_TO_SEND).thenHit(Keys.ENTER),               
                Click.on(BTN_SEND_EMAIL),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(BTN_CLOSE_SEND_EMAIL),
                CloseVoucher.onClick()

        );
    }
    
    public static SendVoucherByEmail withDataEmail(InfoTrx infoTrx){
        return Tasks.instrumented(SendVoucherByEmail.class, infoTrx);
    }
}
