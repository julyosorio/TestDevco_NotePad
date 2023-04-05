package co.com.iris.certification.tasks.transactions.registeredaccounts;

import co.com.iris.certification.interactions.GoToNextPage;
import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

import static co.com.iris.certification.userinterfaces.transactions.registeredaccounts.RegisteredAccountsDetailUI.TEXT_ACCOUNT_HOLDER;
import static co.com.iris.certification.userinterfaces.transactions.registeredaccounts.RegisteredAccountsTableUI.COL_REGISTERED_ACCOUNT;
import static co.com.iris.certification.userinterfaces.transactions.registeredaccounts.RegisteredAccountsTableUI.COL_TYPE_ACCOUNT;

public class ScrollThroughTheTable implements Task {

    private InfoTrx infoTrx;
    private String accountOwner;
    private String account;

    public ScrollThroughTheTable(InfoTrx infoTrx, String account, String accountOwner) {
        this.infoTrx = infoTrx;
        this.account=account;
        this.accountOwner=accountOwner;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> numRegisteredAccount = COL_REGISTERED_ACCOUNT.resolveAllFor(actor);
        List<WebElementFacade> typeAccount = COL_TYPE_ACCOUNT.resolveAllFor(actor);
        int i = 0;
        while (i < numRegisteredAccount.size()){
            account=numRegisteredAccount.get(i).getText().replaceAll("\\R"+typeAccount.get(i).getText(),"");
            if (account.equals(infoTrx.getDestinationAccountNumber())) {
                actor.attemptsTo(
                        Scroll.to(numRegisteredAccount.get(i)),
                        Click.on(numRegisteredAccount.get(i))
                );
                accountOwner = TEXT_ACCOUNT_HOLDER.resolveFor(OnStage.theActorInTheSpotlight()).getText();
                actor.remember("AccountOwner", accountOwner);
                break;
            } else {
                if (i == numRegisteredAccount.size() - 1) {
                    actor.attemptsTo(
                            GoToNextPage.forFindTheCorrectRecord()
                    );
                    i = 0;
                    numRegisteredAccount = COL_REGISTERED_ACCOUNT.resolveAllFor(actor);
                    typeAccount = COL_TYPE_ACCOUNT.resolveAllFor(actor);
                } else {
                    i++;
                }
            }
        }
    }

    public static ScrollThroughTheTable ofRegisteredAccounts(InfoTrx infoTrx) {
        return Tasks.instrumented(ScrollThroughTheTable.class, infoTrx);
    }
}
