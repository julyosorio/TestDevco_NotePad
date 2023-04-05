package co.com.iris.certification.tasks.usermanagement.roles;

import co.com.iris.certification.models.roles.InfoRole;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.WAIT_LOADER;
import static co.com.iris.certification.userinterfaces.usermanagement.roles.CreateNewRoleUI.BTN_NEXT;
import static co.com.iris.certification.userinterfaces.usermanagement.roles.SummaryCreateNewRoleUI.BTN_CREATE_ROLE;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class CompleteNewRoleCreation implements Task {

    private InfoRole infoRole;

    public CompleteNewRoleCreation(InfoRole infoRole){
        this.infoRole= infoRole;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(WAIT_LOADER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Scroll.to(BTN_NEXT).then(Click.on(BTN_NEXT)),
                WaitUntil.the(WAIT_LOADER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Scroll.to(BTN_NEXT).then(Click.on(BTN_NEXT)),
                WaitUntil.the(WAIT_LOADER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Scroll.to(BTN_CREATE_ROLE).then(Click.on(BTN_CREATE_ROLE))
//                GetOtp.byEmail(infoRole.getEmailUser()),
//                SendCorrectOtp.with()
        );
    }

    public static CompleteNewRoleCreation forAssignToTheUsersBanking(InfoRole infoRole) {
        return Tasks.instrumented(CompleteNewRoleCreation.class, infoRole);
    }
}
