package co.com.iris.certification.stepdefinitions.transactions.registeraccount;

import co.com.iris.certification.models.transactions.InfoTrx;
import co.com.iris.certification.tasks.transactions.registeredaccounts.*;
import co.com.iris.certification.userinterfaces.transactions.registeredaccounts.EnterDataToTheForm;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.transactions.SubscribedAccountIrisBankUI.LABEL_POP_UP_MESSAGE_BODY;
import static co.com.iris.certification.userinterfaces.transactions.SubscribedAccountIrisBankUI.LABEL_POP_UP_MESSAGE_TITLE;
import static co.com.iris.certification.userinterfaces.transactions.SubscribedAccountOtherBankUI.LABEL_POP_UP_MESSAGE_BODY_OTHER_BANKS;
import static co.com.iris.certification.userinterfaces.transactions.SubscribedAccountOtherBankUI.LABEL_POP_UP_MESSAGE_TITLE_OTHER_BANKS;
import static co.com.iris.certification.userinterfaces.transactions.registeredaccounts.RegisteredAccountsTableUI.TEXT_POP_UP;
import static co.com.iris.certification.utils.Constants.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class RegisterAccountStepDefinition {

    @When("{string} registers an account of other banks in the menu registered accounts")
    public void registersAnAccountOfOtherBanksInTheMenuRegisteredAccounts(String actor, InfoTrx infoTrx) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterAccount.goToMenu(),
                GoToRegisteredAccounts.menu(OTHER_BANKS),
                EnterDataToTheForm.accountRegistration(infoTrx, OTHER_BANKS)
        );
    }

    @Then("{string} verifies the new account registration pop-up message for other banks")
    public void verifiesTheNewAccountRegistrationPopUpMessageForOtherBanks(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_POP_UP_MESSAGE_TITLE_OTHER_BANKS).text().isEqualTo("¡Registro de nueva cuenta!"),
                Ensure.that(LABEL_POP_UP_MESSAGE_BODY_OTHER_BANKS).text().isEqualTo("La cuenta se encuentra en proceso de inscripción.")
                        .then(Click.on(LABEL_POP_UP_MESSAGE_TITLE_OTHER_BANKS))
        );
    }


    @When("{string} registers an iris account in the menu registered accounts")
    public void registersAnIrisAccountInTheMenuRegisteredAccounts(String actor, InfoTrx infoTrx) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterAccount.goToMenu(),
                GoToRegisteredAccounts.menu(IRIS_ACCOUNTS),
                EnterDataToTheForm.accountRegistration(infoTrx, IRIS_ACCOUNTS)
        );
    }

    @Then("{string} verifies the new account registration pop-up message for iris accounts")
    public void verifiesTheNewAccountRegistrationPopUpMessageForIrisAccounts(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_POP_UP_MESSAGE_TITLE).text().isEqualTo("¡Registro de nueva cuenta!"),
                Ensure.that(LABEL_POP_UP_MESSAGE_BODY).text().startsWith("Ahora puede realizar transacciones para")
                        .then(Click.on(LABEL_POP_UP_MESSAGE_TITLE))
        );
    }

    @When("{string} deletes an registered account from the table of registered accounts")
    public void deletesAnRegisteredAccountFromTheTableOfRegisteredAccounts(String actor, InfoTrx infoTrx) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterAccount.goToMenu(),
                ApplyFilters.toTableOfRegisteredAccounts(infoTrx,DELETE_REGISTERED_ACCOUNT),
                ScrollThroughTheTable.ofRegisteredAccounts(infoTrx),
                DeleteAccount.register()
        );
    }

    @Then("{string} verifies the pop-up message to delete the registered account")
    public void verifiesThePopUpMessageToDeleteTheRegisteredAccount(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(TEXT_POP_UP).text().contains("La cuenta del titular "+OnStage.theActorInTheSpotlight().recall("AccountOwner")+" fue eliminada exitosamente")
                        .then(Click.on(TEXT_POP_UP))
        );
    }

    @When("{string} updates the data of a registered account from the table of registered accounts")
    public void updatesTheDataOfARegisteredAccountFromTheTableOfRegisteredAccounts(String actor, InfoTrx infoTrx) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterAccount.goToMenu(),
                ApplyFilters.toTableOfRegisteredAccounts(infoTrx,DELETE_REGISTERED_ACCOUNT),
                ScrollThroughTheTable.ofRegisteredAccounts(infoTrx),
                UpdateData.ofARegisteredAccount(infoTrx)
        );
    }

    @Then("{string} verifies the pop-up message for successful update of  registered account")
    public void verifiesThePopUpMessageForSuccessfulUpdateOfRegisteredAccount(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(TEXT_POP_UP,isPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Ensure.that(TEXT_POP_UP).text().contains("La cuenta del titular "+OnStage.theActorInTheSpotlight().recall("AccountOwner")+" fue editada exitosamente")
                        .then(Click.on(TEXT_POP_UP))
        );
    }
}
