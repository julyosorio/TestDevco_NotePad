package co.com.iris.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.conditions.Check;

import static co.com.iris.certification.userinterfaces.yopmail.YopMailUI.FRM_INBOX;

public class ValidateOpenTab implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(!FRM_INBOX.resolveFor(actor).isVisible()).andIfSo(
                        OpenNew.tab(),
                        Switch.toTheOtherWindow()
                )
        );
    }

    public static ValidateOpenTab inBrowser() {
        return Tasks.instrumented(ValidateOpenTab.class);
    }
}
