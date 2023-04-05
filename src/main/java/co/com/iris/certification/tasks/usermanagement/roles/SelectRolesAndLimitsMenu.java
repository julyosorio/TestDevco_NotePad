package co.com.iris.certification.tasks.usermanagement.roles;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.MENU_USER_ADMINISTRATION;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.WAIT_LOADER;
import static co.com.iris.certification.userinterfaces.usermanagement.UserManagementUI.BTN_ROLES_AND_LIMITS;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SelectRolesAndLimitsMenu implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(WAIT_LOADER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(MENU_USER_ADMINISTRATION, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(MENU_USER_ADMINISTRATION),
                WaitUntil.the(BTN_ROLES_AND_LIMITS, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_ROLES_AND_LIMITS),
                WaitUntil.the(WAIT_LOADER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    public static SelectRolesAndLimitsMenu forContinue() {
        return Tasks.instrumented(SelectRolesAndLimitsMenu.class);
    }
}
