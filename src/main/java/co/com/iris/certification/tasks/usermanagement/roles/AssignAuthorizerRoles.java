package co.com.iris.certification.tasks.usermanagement.roles;

import co.com.iris.certification.interactions.ClickToContinue;
import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.roles.InfoRole;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.WAIT_LOADER;
import static co.com.iris.certification.userinterfaces.usermanagement.roles.PermitsAndRestrictionsUI.LIST_AUTHORIZER_ROLES_ASSOCIATED_TO_EACH_OPERATION;
import static co.com.iris.certification.userinterfaces.usermanagement.roles.PermitsAndRestrictionsUI.OPT_LIST_AUTHORIZER_ROLES_ASSOCIATED_TO_EACH_OPERATION;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class AssignAuthorizerRoles implements Task {
    private InfoRole infoRole;

    public AssignAuthorizerRoles(InfoRole infoRole){
        this.infoRole = infoRole;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> listAuthorizerUser = LIST_AUTHORIZER_ROLES_ASSOCIATED_TO_EACH_OPERATION.resolveAllFor(actor);
        for (WebElementFacade element :listAuthorizerUser) {
            actor.attemptsTo(
                    WaitUntil.the(WAIT_LOADER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(element),
                    SelectOption.fromList(OPT_LIST_AUTHORIZER_ROLES_ASSOCIATED_TO_EACH_OPERATION,"Administrador"),
                    Click.on(element),
                    SelectOption.fromList(OPT_LIST_AUTHORIZER_ROLES_ASSOCIATED_TO_EACH_OPERATION,"Master")
            );
        }
        actor.attemptsTo(ClickToContinue.toTheNextPage());

    }

    public static AssignAuthorizerRoles forEachOperation(InfoRole infoRole){
        return Tasks.instrumented(AssignAuthorizerRoles.class, infoRole);
    }
}
