package co.com.iris.certification.tasks.usermanagement.users;

import co.com.iris.certification.models.users.InfoUser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.usermanagement.users.TableUserProfileUI.COL_NAME_USER;
import static co.com.iris.certification.userinterfaces.usermanagement.users.TableUserProfileUI.ROW_TABLE_USER_PROFILE;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class SelectARegister implements Task {

    private InfoUser infoUser;

    public SelectARegister(InfoUser infoUser) {
        this.infoUser = infoUser;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOADSCREEN_SPINNER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Check.whether(COL_NAME_USER.resolveFor(actor).getText().contains(infoUser.getNameUser() + " " + infoUser.getLastnameUser()))
                        .andIfSo(
                                MoveMouse.to(ROW_TABLE_USER_PROFILE),
                                Scroll.to(ROW_TABLE_USER_PROFILE),
                                Click.on(ROW_TABLE_USER_PROFILE),
                                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds())
        );
    }

    public static SelectARegister fromUserProfileTable(InfoUser infoUser) {
        return Tasks.instrumented(SelectARegister.class, infoUser);
    }
}
