package co.com.iris.certification.tasks.usermanagement.roles;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.usermanagement.roles.CreateNewRoleUI.LABEL_MESSAGE_CONTENT_CREATION_NEW_ROLE_SUCCESSFUL;
import static co.com.iris.certification.userinterfaces.usermanagement.roles.CreateNewRoleUI.LABEL_MESSAGE_TITLE_CREATION_NEW_ROLE_SUCCESSFUL;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerifyMessage implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LABEL_MESSAGE_TITLE_CREATION_NEW_ROLE_SUCCESSFUL, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Ensure.that(LABEL_MESSAGE_TITLE_CREATION_NEW_ROLE_SUCCESSFUL).text().isEqualToIgnoringCase("Rol creado con éxito."),
                Ensure.that(LABEL_MESSAGE_CONTENT_CREATION_NEW_ROLE_SUCCESSFUL).text().isEqualToIgnoringCase("Se ha enviado un correo electrónico para los usuarios informando su nuevo rol."),
                Click.on(LABEL_MESSAGE_CONTENT_CREATION_NEW_ROLE_SUCCESSFUL),
                WaitUntil.the(LABEL_MESSAGE_TITLE_CREATION_NEW_ROLE_SUCCESSFUL, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    public static VerifyMessage ofNewRoleCreated(){
        return Tasks.instrumented(VerifyMessage.class);
    }
}
