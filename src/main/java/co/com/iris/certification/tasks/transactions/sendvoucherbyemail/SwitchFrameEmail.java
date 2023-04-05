package co.com.iris.certification.tasks.transactions.sendvoucherbyemail;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Switch;

import static co.com.iris.certification.userinterfaces.yopmail.YopMailUI.FRM_DETAIL_EMAIL;

public class SwitchFrameEmail implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toParentFrame(),
                Switch.toFrame(FRM_DETAIL_EMAIL.resolveFor(actor))
        );
    }

    public static SwitchFrameEmail messageBody()
    {
        return Tasks.instrumented(SwitchFrameEmail.class);
    }


}
