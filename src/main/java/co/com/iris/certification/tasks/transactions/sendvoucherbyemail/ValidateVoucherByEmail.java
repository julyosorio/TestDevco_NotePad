package co.com.iris.certification.tasks.transactions.sendvoucherbyemail;

import co.com.iris.certification.interactions.ValidateOpenTab;
import co.com.iris.certification.models.transactions.InfoTrx;
import co.com.iris.certification.tasks.validateotp.LoginYopmail;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Switch;

import static co.com.iris.certification.userinterfaces.yopmail.YopMailUI.FRM_INBOX;

public class ValidateVoucherByEmail implements Task {
    private InfoTrx infoTrx;

    public ValidateVoucherByEmail(InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toTheOtherWindow(),
                ValidateOpenTab.inBrowser(),
                LoginYopmail.withEmail(infoTrx.getEmailUser()),
                Switch.toFrame(FRM_INBOX.resolveFor(actor))
                );
    }

    public static ValidateVoucherByEmail goTo(InfoTrx infoTrx)
    {
        return Tasks.instrumented(ValidateVoucherByEmail.class, infoTrx);
    }


}
