package co.com.iris.certification.tasks.usermanagement.roles;

import co.com.iris.certification.interactions.ClickToContinue;
import co.com.iris.certification.models.roles.InfoRole;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.List;

import static co.com.iris.certification.userinterfaces.usermanagement.roles.PermitsAndRestrictionsUI.*;
import static co.com.iris.certification.utils.SetData.convertStringToList;

public class SelectPermitsGroups implements Task {
    private InfoRole infoRole;

    public SelectPermitsGroups(InfoRole infoRole) {
        this.infoRole = infoRole;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> listPermitsFeature = convertStringToList(infoRole.getPermitsGroupsList());
        for (String permits : listPermitsFeature) {
            permits = permits.trim().toLowerCase();
            switch (permits) {
                case "banca general":
                    actor.attemptsTo(Scroll.to(CHECK_PERMITS_GENERAL_BANKING).then(Click.on(CHECK_PERMITS_GENERAL_BANKING)));
                    Serenity.recordReportData().withTitle("The permits of general banking group were selected").andContents("");
                    break;
                case "resumen":
                    actor.attemptsTo(Scroll.to(CHECK_PERMITS_FOR_SUMMARY_GROUP).then(Click.on(CHECK_PERMITS_FOR_SUMMARY_GROUP)));
                    Serenity.recordReportData().withTitle("The permits of summary group were selected").andContents("");
                    break;
                case "transferencias":
                    actor.attemptsTo(Scroll.to(CHECK_PERMITS_FOR_TRANSACTION_GROUP).then(Click.on(CHECK_PERMITS_FOR_TRANSACTION_GROUP)));
                    Serenity.recordReportData().withTitle("The permits of transactions group were selected").andContents("");
                    break;
                case "pagos":
                    actor.attemptsTo(Scroll.to(CHECK_PERMITS_FOR_PAYMENTS_GROUP).then(Click.on(CHECK_PERMITS_FOR_PAYMENTS_GROUP)));
                    Serenity.recordReportData().withTitle("The permits of payments group were selected").andContents("");
                    break;
                case "pse":
                    actor.attemptsTo(Scroll.to(CHECK_PERMITS_FOR_PSE_GROUP).then(Click.on(CHECK_PERMITS_FOR_PSE_GROUP)));
                    Serenity.recordReportData().withTitle("The permits of PSE group were selected").andContents("");
                    break;
                case "configuracion":
                    actor.attemptsTo(Scroll.to(CHECK_PERMITS_FOR_CONFIGURATION_GROUP).then(Click.on(CHECK_PERMITS_FOR_CONFIGURATION_GROUP)));
                    Serenity.recordReportData().withTitle("The permits of configuration group were selected").andContents("");
                    break;
            }
        }
        actor.attemptsTo(ClickToContinue.toTheNextPage());

    }

    public static SelectPermitsGroups forNewRole(InfoRole infoRole) {
        return Tasks.instrumented(SelectPermitsGroups.class, infoRole);
    }
}
