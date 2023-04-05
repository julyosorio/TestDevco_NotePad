package co.com.iris.certification.tasks.usermanagement.roles;

import co.com.iris.certification.interactions.ClickToContinue;
import co.com.iris.certification.models.roles.InfoRole;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.WAIT_LOADER;
import static co.com.iris.certification.userinterfaces.usermanagement.roles.CreateNewRoleUI.*;
import static co.com.iris.certification.userinterfaces.usermanagement.roles.ProductsAndComplementsUI.LIST_PRODUCTS_FOR_ASSOCIATES_TO_THE_ROLE;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SelectCreateNewRole implements Task {
    private InfoRole infoRole;

    public SelectCreateNewRole(InfoRole infoRole){
        this.infoRole = infoRole;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CREATE_NEW_ROLE),
                WaitUntil.the(WAIT_LOADER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Enter.theValue(infoRole.getRoleName()).into(TEXT_NAME_ROLE),
                Enter.theValue(infoRole.getRoleDescription()).into(TEXT_DESCRIPTION_ROLE),
                ClickToContinue.toTheNextPage(),
                WaitUntil.the(LIST_PRODUCTS_FOR_ASSOCIATES_TO_THE_ROLE,isPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }
    public static SelectCreateNewRole andEnterBasicInformationForRole(InfoRole role){
        return Tasks.instrumented(SelectCreateNewRole.class, role);
    }
}
