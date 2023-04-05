package co.com.iris.certification.tasks.validateotp;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.yopmail.YopMailUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static co.com.iris.certification.utils.Constants.YOPMAIL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginYopmail implements Task {
    private String email;

    public LoginYopmail(String email){
        this.email = email;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(YOPMAIL),
                WaitUntil.the(TEXT_EMAIL, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Enter.theValue(email).into(TEXT_EMAIL),
                Hit.the(Keys.ENTER).into(TEXT_EMAIL),
                WaitUntil.the(AMOUNT_MAILS, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                WaitUntil.the(BTN_REFRESH, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Click.on(BTN_REFRESH)
        );
    }
    public static LoginYopmail withEmail(String email){

        return Tasks.instrumented(LoginYopmail.class,email);
    }
}
