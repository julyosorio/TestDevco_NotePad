package co.com.iris.certification.tasks.usermanagement.users;

import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.users.InfoUser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.usermanagement.users.CreateNewUserUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class EnterUserData implements Task {
    private InfoUser infoUser;

    public EnterUserData(InfoUser infoUser) {
        this.infoUser = infoUser;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(infoUser.getNameUser()).into(TEXT_NAME_USER),
                Enter.theValue(infoUser.getLastnameUser()).into(TEXT_LASTNAME_USER),
                Click.on(LIST_DOCUMENT_TYPE),
                SelectOption.fromList(OPTLST_DOCUMENT_TYPE, infoUser.getDocumentType()),
                Enter.theValue(infoUser.getDocumentNumber()).into(TEXT_DOCUMENT_NUMBER),
                Enter.theValue(infoUser.getCellphone()).into(TEXT_CELLPHONE),
                Enter.theValue(infoUser.getEmailNewUser()).into(TEXT_EMAIL),
                WaitUntil.the(LIST_ROLE, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LIST_ROLE),
                SelectOption.fromList(OPTLST_ROLE, infoUser.getRole()),
                Click.on(BTN_CREATE_USER));
           }


    public static EnterUserData forNewUser(InfoUser infoUser) {
        return Tasks.instrumented(EnterUserData.class, infoUser);
    }
}
