package co.com.iris.certification.tasks.transactions.registeredaccounts;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

import static co.com.iris.certification.userinterfaces.transactions.registeredaccounts.RegisteredAccountsTableUI.*;

public class UpdateData implements Task {
    private InfoTrx infoTrx;

    public UpdateData(InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_UPDATE),
                Check.whether((infoTrx.getEmailSubsAccount() != null))
                        .andIfSo(Enter.theValue(infoTrx.getEmailSubsAccount()).into(TEXT_EMAIL_UPDATE)),
                Check.whether((infoTrx.getDescriptionSubsAccount()!=null))
                        .andIfSo(Enter.theValue(infoTrx.getDescriptionSubsAccount()).into(TEXT_DESCRIPTION_UPDATE)),
                Check.whether(infoTrx.getRequiresSaveSubscription().equalsIgnoreCase("Si"))
                        .andIfSo(Click.on(RADIO_NOTIFICATION)),
                Click.on(BTN_COMPLETE)
                );

    }

    public static UpdateData ofARegisteredAccount(InfoTrx infoTrx) {
        return Tasks.instrumented(UpdateData.class, infoTrx);
    }
}
