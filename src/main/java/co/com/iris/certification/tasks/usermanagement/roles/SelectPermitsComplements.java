package co.com.iris.certification.tasks.usermanagement.roles;

import co.com.iris.certification.interactions.ClickToContinue;
import co.com.iris.certification.models.roles.InfoRole;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.WAIT_LOADER;
import static co.com.iris.certification.userinterfaces.usermanagement.roles.PermitsAndRestrictionsUI.CHECK_PERMITS_TO_MANAGEMENT_COMPLEMENT_SELECTED;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class SelectPermitsComplements implements Task {
    private InfoRole infoRole;

    public SelectPermitsComplements(InfoRole infoRole){
        this.infoRole = infoRole;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(WAIT_LOADER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Check.whether(infoRole.getComplementsList() != null).andIfSo(
                        Click.on(CHECK_PERMITS_TO_MANAGEMENT_COMPLEMENT_SELECTED)
                ),
                ClickToContinue.toTheNextPage()
        );
    }

    public static SelectPermitsComplements forCompleteItsConfiguration(InfoRole infoRole){
        return Tasks.instrumented(SelectPermitsComplements.class,infoRole);
    }
}
