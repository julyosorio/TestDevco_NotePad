package co.com.iris.certification.tasks.usermanagement.users;

import co.com.iris.certification.models.users.InfoUser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ui.PageElement;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.usermanagement.users.UserDetailUI.*;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EditUserData implements Task {

    private InfoUser infoUser;

    public EditUserData(InfoUser infoUser) {
        this.infoUser = infoUser;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LABEL_EDIT_USER, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LABEL_EDIT_USER),
                Enter.theValue(infoUser.getCellphone()).into(TEXT_PHONE_CHANGED),
                Enter.theValue(infoUser.getEmailNewUser()).into(TEXT_EMAIL_CHANGED),
                Click.on(LIST_ROL_CHANGED),
                Click.on(PageElement.containingText(infoUser.getUpdateRole()).inside(OPTLST_ROL_CHANGED)),
                Scroll.to(BTN_SAVE_CHANGES),
                Click.on(BTN_SAVE_CHANGES),
                WaitUntil.the(LOADSCREEN_SPINNER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    public static EditUserData newData(InfoUser infoUser) {
        return Tasks.instrumented(EditUserData.class, infoUser);
    }
}
