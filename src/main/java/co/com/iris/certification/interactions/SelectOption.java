package co.com.iris.certification.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class SelectOption implements Interaction {
    private Target locatorList;
    private String valueOption;

    public SelectOption(Target locatorList, String valueOption) {
        this.locatorList = locatorList;
        this.valueOption = valueOption;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> listSelect = this.locatorList.resolveAllFor(actor);
        for (WebElementFacade element : listSelect) {
                if (element.getText().contains(this.valueOption)) {
                    actor.attemptsTo(
                            Scroll.to(element),
                            MoveMouse.to(element),
                            Click.on(element));
                    if (!element.isVisible()) {
                        break;
                    }
                }
        }
    }

    public static SelectOption fromList(Target locatorList, String valueOption) {
        return Tasks.instrumented(SelectOption.class, locatorList, valueOption);
    }
}
