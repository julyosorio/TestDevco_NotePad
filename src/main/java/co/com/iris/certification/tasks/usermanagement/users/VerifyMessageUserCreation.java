package co.com.iris.certification.tasks.usermanagement.users;

import co.com.iris.certification.exceptions.UserDocumentUsedBefore;
import co.com.iris.certification.exceptions.UserEmailUsedBefore;
import co.com.iris.certification.exceptions.UserNameUsedBefore;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.usermanagement.users.CreateNewUserUI.*;
import static co.com.iris.certification.userinterfaces.usermanagement.users.TableUserProfileUI.COL_NAME_USER;
import static co.com.iris.certification.userinterfaces.usermanagement.users.TableUserProfileUI.LABEL_MESSAGE_TITLE_USER_CREATED;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class VerifyMessageUserCreation implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LABEL_MESSAGE, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                MoveMouse.to(LABEL_MESSAGE));
        if (LABEL_MESSAGE_TITLE_USER_CREATED.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Ensure.that(LABEL_MESSAGE_TITLE_USER_CREATED).text().isEqualToIgnoringCase("Usuario invitado exitosamente."),
                    Ensure.that(LABEL_MESSAGE.resolveFor(actor).getText()).isEqualToIgnoringCase("Se ha enviado un correo electrónico al usuario y está pendiente de aceptación."),
                    WaitUntil.the(COL_NAME_USER, isPresent()).forNoMoreThan(WAITING_TIME).seconds());
        }
        while (BTN_CLOSE_FORM.resolveFor(actor).isPresent()) {
            actor.attemptsTo(Click.on(BTN_CREATE_USER));
            actor.should(seeThat(the(LABEL_MESSAGE_DOCUMENT_WAS_USED), isNotVisible())
                    .orComplainWith(UserDocumentUsedBefore.class, "Ya hay un usuario con el mismo documento"));
            actor.should(seeThat(the(LABEL_MESSAGE_NAME_WAS_USED), isNotVisible())
                    .orComplainWith(UserNameUsedBefore.class, "Ya hay un usuario con el mismo nombre"));
            actor.should(seeThat(the(LABEL_MESSAGE_EMAIL_WAS_USED), isNotVisible())
                    .orComplainWith(UserEmailUsedBefore.class, "Ya hay un usuario con el mismo correo electrónico"));
        }
    }

    public static VerifyMessageUserCreation forNewUser() {
        return Tasks.instrumented(VerifyMessageUserCreation.class);
    }
}
