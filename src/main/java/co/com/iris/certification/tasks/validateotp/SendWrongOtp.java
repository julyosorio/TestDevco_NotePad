package co.com.iris.certification.tasks.validateotp;

import co.com.iris.certification.models.login.LoginUsers;
import co.com.iris.certification.userinterfaces.validateotp.ValidateOtpUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SendWrongOtp implements Task {

    private LoginUsers userWrongOtp;

    public SendWrongOtp(LoginUsers loginUsers) {
        this.userWrongOtp = loginUsers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toTheOtherWindow(),
                WaitUntil.the(ValidateOtpUI.TEXT_OTP_CODE, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Enter.theValue(userWrongOtp.getOtp()).into(ValidateOtpUI.TEXT_OTP_CODE)
        );
    }

    public static SendWrongOtp sendWrongOTP(LoginUsers userWrongOtp) {
        return Tasks.instrumented(SendWrongOtp.class, userWrongOtp);
    }
}
