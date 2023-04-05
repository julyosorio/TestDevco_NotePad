package co.com.iris.certification.tasks.usermanagement.roles;

import co.com.iris.certification.interactions.ClickToContinue;
import co.com.iris.certification.models.roles.InfoRole;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static co.com.iris.certification.userinterfaces.usermanagement.roles.PermitsAndRestrictionsUI.CHECK_PERMITS_GENERAL_BANKING;
import static co.com.iris.certification.userinterfaces.usermanagement.roles.ProductsAndComplementsUI.LIST_COMPLEMENTS_FOR_ASSOCIATE_TO_THE_ROLE;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static co.com.iris.certification.utils.SetData.convertListToMap;
import static co.com.iris.certification.utils.SetData.convertStringToList;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectComplements implements Task {

    private InfoRole infoRole;

    public SelectComplements(InfoRole infoRole) {
        this.infoRole = infoRole;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> listComplements = LIST_COMPLEMENTS_FOR_ASSOCIATE_TO_THE_ROLE.resolveAllFor(actor);

        if (infoRole.getComplementsList() != null) {
            List<String> listComplementsFeature = convertStringToList(infoRole.getComplementsList());
            Map<Integer, String> mapFeature = convertListToMap(listComplementsFeature);

            for (WebElementFacade complement : listComplements) {
                if (mapFeature.containsValue(complement.getText().toLowerCase())) {
                    actor.attemptsTo(Click.on(complement));
                    Serenity.recordReportData().withTitle("A new complement was selected").andContents(complement.getText());
                }
            }
        }
        actor.attemptsTo(
                ClickToContinue.toTheNextPage(),
                WaitUntil.the(CHECK_PERMITS_GENERAL_BANKING, isVisible()).forNoMoreThan(WAITING_TIME).seconds());
    }

    public static SelectComplements forNewRole(InfoRole infoRole) {
        return Tasks.instrumented(SelectComplements.class, infoRole);
    }
}
