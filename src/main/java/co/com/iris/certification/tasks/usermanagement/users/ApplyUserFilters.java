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

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.WAIT_LOADER;
import static co.com.iris.certification.userinterfaces.usermanagement.users.UserFiltersUI.*;
import static co.com.iris.certification.utils.Constants.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class ApplyUserFilters implements Task {
    private InfoUser infoUser;
    private String typeOfSearch;

    public ApplyUserFilters(InfoUser infoUser, String typeOfSearch) {

        this.infoUser = infoUser;
        this.typeOfSearch = typeOfSearch;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (typeOfSearch) {
            case USER_CREATION:
                actor.attemptsTo(
                        WaitUntil.the(BTN_USER_FILTERS, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                        Click.on(BTN_USER_FILTERS),
                        Enter.theValue(infoUser.getNameUser() + " " + infoUser.getLastnameUser()).into(NAME_USER),
                        Click.on(BTN_APPLY_FILTERS),
                        WaitUntil.the(WAIT_LOADER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
                );
                break;
            case USER_MODIFICATION:
                actor.attemptsTo(
                        WaitUntil.the(BTN_FILTERS_USERPROFILE, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                        Click.on(BTN_FILTERS_USERPROFILE),
                        Enter.theValue(infoUser.getNameUser() + " "+ infoUser.getLastnameUser()).into(TEXT_FILTER_NAME_USER),
                        Click.on(LIST_FILTER_ROL),
                        Click.on(PageElement.containingText(infoUser.getRole()).inside(OPTLST_FILTER_ROL)),
                        Click.on(TEXT_FILTER_NAME_USER),
                        WaitUntil.the(LIST_FILTER_STATUS,isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                        Click.on(LIST_FILTER_STATUS),
                        Click.on(PageElement.containingText("Activo").inside(OPTLST_FILTER_STATUS)),
                        Scroll.to(BTN_APPLY_FILTERS),
                        Click.on(BTN_APPLY_FILTERS),
                        WaitUntil.the(WAIT_LOADER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
                );
                break;
        }
    }

    public static ApplyUserFilters forGetTheUserRecord(InfoUser infoUser, String typeOfSearch) {
        return Tasks.instrumented(ApplyUserFilters.class, infoUser, typeOfSearch);
    }
}
