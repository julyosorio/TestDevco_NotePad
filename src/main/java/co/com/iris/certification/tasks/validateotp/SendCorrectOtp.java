package co.com.iris.certification.tasks.validateotp;

import co.com.iris.certification.userinterfaces.validateotp.ValidateOtpUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SendCorrectOtp implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        String otp = actor.recall("otpCode");
        actor.attemptsTo(
                Switch.toTheOtherWindow(),
                WaitUntil.the(ValidateOtpUI.TEXT_OTP_CODE, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(otp).into(ValidateOtpUI.TEXT_OTP_CODE),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(20))
        );
    }

    public static SendCorrectOtp with(){
        return Tasks.instrumented(SendCorrectOtp.class);
    }
}
