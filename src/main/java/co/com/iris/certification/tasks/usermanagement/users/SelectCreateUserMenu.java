package co.com.iris.certification.tasks.usermanagement.users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.usermanagement.users.TableUserProfileUI.BTN_CREATE_NEW_USER;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectCreateUserMenu implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_CREATE_NEW_USER, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_CREATE_NEW_USER));
    }

    public static SelectCreateUserMenu forContinue() {
        return Tasks.instrumented(SelectCreateUserMenu.class);
    }
}
