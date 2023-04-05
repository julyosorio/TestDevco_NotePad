package co.com.iris.certification.tasks.validateotp;

import co.com.iris.certification.interactions.ValidateOpenTab;
import co.com.iris.certification.userinterfaces.validateotp.ValidateOtpUI;
import co.com.iris.certification.userinterfaces.yopmail.YopMailUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GetOtp implements Task {

    private String email;

    public GetOtp(String email){
        this.email = email;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ValidateOtpUI.LINK_CHANGE_CHANNEL, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(ValidateOtpUI.LINK_CHANGE_CHANNEL),
                Click.on(ValidateOtpUI.LABEL_SEND_CODE_BY_MAIL),
                Click.on(ValidateOtpUI.BTN_CONFIRM_CHANNEL),
                Switch.toTheOtherWindow(),
                ValidateOpenTab.inBrowser(),
                LoginYopmail.withEmail(email),
                Switch.toFrame(YopMailUI.FRM_INBOX.resolveFor(actor)),
                WaitUntil.the(YopMailUI.LABEL_EMAIL_OTP_CODE, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(YopMailUI.LABEL_EMAIL_OTP_CODE),
                Switch.toParentFrame(),
                Switch.toFrame(YopMailUI.FRM_DETAIL_EMAIL.resolveFor(actor))
                );
        actor.remember("otpCode",YopMailUI.VALUE_OTP_CODE.resolveFor(actor).getText());
    }

    public static GetOtp byEmail(String email){
        return Tasks.instrumented(GetOtp.class, email);
    }
}
