package co.com.iris.certification.tasks.passwordrecovery;

import co.com.iris.certification.models.passwordrecovery.PasswordRecovery;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.iris.certification.userinterfaces.passwordrecovery.ChangePasswordUI.*;

public class CreateNewPassword implements Task {

    private PasswordRecovery passwordRecovery;

    public CreateNewPassword(PasswordRecovery passwordRecovery){

        this.passwordRecovery = passwordRecovery;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.remember("windowIris",BrowseTheWeb.as(actor).getDriver().getWindowHandle());
        actor.attemptsTo(
                Enter.theValue(passwordRecovery.getUsername()).into(TEXT_USERNAME),
                Enter.theValue(passwordRecovery.getPassword()).into(TEXT_PASSWORD),
                Enter.theValue(passwordRecovery.getPassword()).into(TEXT_CONFIRM_PASSWORD),
                Click.on(BTN_SAVE_NEW_PASSWORD)
        );
    }

    public static CreateNewPassword withTheData(PasswordRecovery passwordRecovery){
        return Tasks.instrumented(CreateNewPassword.class, passwordRecovery);
    }
}
