package co.com.iris.certification.tasks.usermanagement.roles;

import co.com.iris.certification.models.roles.InfoRole;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.PageElement;

import static co.com.iris.certification.userinterfaces.usermanagement.roles.RolesFiltersUI.*;

public class FilterTheRolesList implements Task {
    private InfoRole infoRole;

    public FilterTheRolesList(InfoRole infoRole) {
        this.infoRole = infoRole;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_FILTERS),
                Click.on(LIST_ROLE_NAME),
                Click.on(PageElement.containingText(infoRole.getRoleName()).inside(LIST_ROLE_NAME)),
                Click.on(BTN_APPLY_FILTERS)
        );
    }

    public static FilterTheRolesList forSearchTheNewRoleCreated(InfoRole infoRole) {
        return Tasks.instrumented(FilterTheRolesList.class, infoRole);
    }
}
