package co.com.iris.certification.stepdefinitions.transactions.irisaccounts;

import co.com.iris.certification.models.transactions.InfoTrx;
import co.com.iris.certification.tasks.transactions.*;
import co.com.iris.certification.tasks.transactions.irisaccounts.AccessIrisAccountsOption;
import co.com.iris.certification.tasks.transactions.registeredaccounts.ApplyFilters;
import co.com.iris.certification.tasks.transactions.registeredaccounts.RegisterAccount;
import co.com.iris.certification.tasks.transactions.registeredaccounts.SelectRowCorrect;
import co.com.iris.certification.tasks.transactions.vouchertransaction.CloseVoucher;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.transactions.TransactionSummaryUI.*;
import static co.com.iris.certification.userinterfaces.transactions.registeredaccounts.RegisteredAccountsDetailUI.*;
import static co.com.iris.certification.userinterfaces.transactions.registeredaccounts.RegisteredAccountsTableUI.*;
import static co.com.iris.certification.utils.Constants.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OnlineTrxUnregisteredIrisAccountStepDefinition {
    private InfoTrx infoTrx;

    @When("{string} goes to summary page of current transaction between iris accounts with destination unregistered account")
    public void goesToSummaryPageOfCurrentTransactionBetweenIrisAccountsWithDestinationUnregisteredAccount(String user, InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccessIrisAccountsOption.fromMainMenu(),
                SubscribeAndChooseAccount.toCompleteTransaction(infoTrx, IRIS_ACCOUNTS),
                InsertValueCorrect.ofTransaction(infoTrx),
                SchedulePeriodicity.ofTheTransaction(infoTrx),
                AddTag.toTheTransaction(infoTrx)
        );
    }

    @Then("{string} verify that the data on the summary page is correct for transaction between iris accounts with unregistered destination account")
    public void verifyThatTheDataOnTheSummaryPageIsCorrectForTransactionBetweenIrisAccountsWithUnregisteredDestinationAccount(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_ORIGIN_ACCOUNT_OWNER).text().isNotEmpty(),
                Ensure.that(LABEL_TYPE_ORIGIN_ACCOUNT).text().isNotEmpty(),
                Ensure.that(LABEL_ORIGIN_ACCOUNT_NUMBER).text().contains(infoTrx.getOriginAccountNumber())
                        .then(Scroll.to(LABEL_TYPE_DESTINATION_ACCOUNT)),
                Ensure.that(LABEL_DESTINATION_ACCOUNT_NUMBER).text().endsWith("••••" + infoTrx.getDestinationAccountNumber()
                        .substring(infoTrx.getDestinationAccountNumber().length() - 4)),
                Ensure.that(LABEL_TRX_AMMOUNT.resolveFor(OnStage.theActorInTheSpotlight()).getText()
                        .replace(",", "")).isEqualTo("$" + infoTrx.getTransferValue()),
                Ensure.that(LABEL_PERIODICITY).text().contains(TRANSFER_DOESNT_HAVE_PERIODICITY),
                Ensure.that(LABEL_EXECUTION_DATE).text().contains(DATE_CURRENT),
                Ensure.that(LABEL_FINAL_DATE).isNotDisplayed(),
                Ensure.that(LABEL_TAG).text().contains(infoTrx.getTag())
                        .then(Scroll.to(LABEL_TRX_AMMOUNT)),
                Check.whether(infoTrx.getDescription() == null)
                        .andIfSo(Ensure.that(LABEL_DESCRIPTION_TAG).text().contains("-"))
                        .otherwise(Ensure.that(LABEL_DESCRIPTION_TAG).text().contains(infoTrx.getDescription())),
                Check.whether(infoTrx.getRequiresSaveSubscription().equals("Si"))
                        .andIfSo(Ensure.that(LABEL_MESSAGE_SUBSCRIPTION_ACCOUNT).text().contains("Guarda esta cuenta para usarla de nuevo."))
                        .otherwise(Ensure.that(LABEL_MESSAGE_SUBSCRIPTION_ACCOUNT).isNotDisplayed()),
                Ensure.that(LABEL_DESTINATION_ACCOUNT_OWNER).text().isNotEmpty(),
                Ensure.that(LABEL_TYPE_DESTINATION_ACCOUNT).text().isNotEmpty(),
                Ensure.that(LABEL_COST_TRANSACTION).isNotDisplayed()
        );
    }

    @When("{string} subscribes an account and makes a transaction between iris accounts")
    public void actorSubscribesAnAccountAndMakesATransactionBetweenIrisAccounts(String actor, InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
        OnStage.theActorCalled(actor).attemptsTo(
                AccessIrisAccountsOption.fromMainMenu(),
                SubscribeAndChooseAccount.toCompleteTransaction(infoTrx, IRIS_ACCOUNTS),
                InsertValueCorrect.ofTransaction(infoTrx),
                SchedulePeriodicity.ofTheTransaction(infoTrx),
                AddTag.toTheTransaction(infoTrx),
                Execute.theTransaction(infoTrx)
        );
    }

    @Then("{string} verifies the message of successful transaction between the iris account with the unregistered destination account")
    public void verifiesTheMessageOfSuccessfulTransactionBetweenTheIrisAccountWithTheUnregisteredDestinationAccount(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_SUCCESSFUL_TRANSACTION).text().containsIgnoringCase("Transacción exitosa"),
                WaitUntil.the(LABEL_SUCCESSFUL_TRANSACTION_AMOUNT, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Ensure.that(LABEL_SUCCESSFUL_TRANSACTION_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight())
                        .getText().replace(",", "")).contains("$" + infoTrx.getTransferValue())
        );
    }

    @When("{string} searches the registered account record between iris accounts in the table registered accounts")
    public void searchesTheRegisteredAccountRecordBetweenIrisAccountsInTheTableRegisteredAccounts(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterAccount.goToMenu(),
                ApplyFilters.toTableOfRegisteredAccounts(infoTrx,IRIS_ACCOUNTS)
        );
    }

    @Then("{string} validate that the information of the registered iris account, of the table accounts registered is correct")
    public void validateThatTheInformationOfTheRegisteredIrisAccountOfTheTableAccountsRegisteredIsCorrect(String user, InfoTrx infoTrx) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(COL_ACCOUNT_HOLDER).text().isNotEmpty(),
                Ensure.that(COL_ACCOUNT_HOLDER_EMAIL).text().isNotEmpty(),
                Ensure.that(COL_DOCUMENT).text().isNotEmpty(),
                Ensure.that(COL_DOCUMENT_TYPE).text().isNotEmpty(),
                Ensure.that(COL_BANK).text().isEqualTo("Iris"),
                Ensure.that(COL_REGISTERED_ACCOUNT).text().contains(infoTrx.getDestinationAccountNumber()),
                Check.whether(infoTrx.getDescriptionSubsAccount() == null)
                        .andIfSo(Ensure.that(COL_DESCRIPTION).text().contains("-"))
                        .otherwise(Ensure.that(COL_DESCRIPTION).text().contains(infoTrx.getDescriptionSubsAccount())),
                Ensure.that(COL_REGISTRATION_STATUS).text().contains("Exitosa")
        );
    }

    @When("{string} searches for the registered iris account in the table registered accounts, to see the account detail")
    public void searchesForTheRegisteredIrisAccountInTheTableRegisteredAccountsToSeeTheAccountDetail(String user, InfoTrx infoTrx) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterAccount.goToMenu(),
                ApplyFilters.toTableOfRegisteredAccounts(infoTrx, IRIS_ACCOUNTS),
                SelectRowCorrect.registeredAccountsTable(infoTrx, IRIS_ACCOUNTS)
        );
    }

    @Then("{string} validate that the detailed information of the registered iris account is correct")
    public void validateThatTheDetailedInformationOfTheRegisteredIrisAccountIsCorrect(String user, InfoTrx infoTrx) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(TEXT_ACCOUNT_HOLDER.waitingForNoMoreThan(Duration.ofSeconds(WAITING_TIME))).text().startsWith(OnStage.theActorInTheSpotlight().recall("accountHolder")),
                Ensure.that(TEXT_DOCUMENT_TYPE).text().isEqualTo(OnStage.theActorInTheSpotlight().recall("typeDocument")),
                Ensure.that(TEXT_NUMBER_DOCUMENT).text().isEqualTo(OnStage.theActorInTheSpotlight().recall("documentNumber")),
                Ensure.that(TEXT_DESTINATION_BANK).text().contains("Iris"),
                Ensure.that(TEXT_ACCOUNT_TYPE).text().isNotEmpty(),
                Ensure.that(TEXT_ACCOUNT_NUMBER).text().endsWith("••••" + infoTrx.getDestinationAccountNumber()
                        .substring(infoTrx.getDestinationAccountNumber().length() - 4)),
                Check.whether(infoTrx.getEmailSubsAccount() != null).andIfSo(
                        Ensure.that(TEXT_EMAIL).text().contains(infoTrx.getEmailSubsAccount())
                ).otherwise(Ensure.that(TEXT_EMAIL_EMPTY).text().contains("-")),
                Check.whether(infoTrx.getDescriptionSubsAccount() == null)
                        .andIfSo(Ensure.that(TEXT_ACCOUNT_DESCRIPTION_EMPTY).text().contains("-"))
                        .otherwise(Ensure.that(TEXT_ACCOUNT_DESCRIPTION).text().contains(infoTrx.getDescriptionSubsAccount()))
                        .then(CloseVoucher.onClick())
        );
    }
}
