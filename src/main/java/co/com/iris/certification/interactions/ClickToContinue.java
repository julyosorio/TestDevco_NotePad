package co.com.iris.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.iris.certification.userinterfaces.usermanagement.roles.CreateNewRoleUI.BTN_NEXT;

public class ClickToContinue implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Scroll.to(BTN_NEXT).then(Click.on(BTN_NEXT)));
    }

    public static ClickToContinue toTheNextPage() {
        return Tasks.instrumented(ClickToContinue.class);
    }
}
