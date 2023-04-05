package co.com.iris.certification.stepdefinitions.authorization;

import co.com.iris.certification.models.transactions.InfoTrx;
import co.com.iris.certification.tasks.authorization.*;
import co.com.iris.certification.tasks.transactions.AddTag;
import co.com.iris.certification.tasks.transactions.Execute;
import co.com.iris.certification.tasks.transactions.InsertValueCorrect;
import co.com.iris.certification.tasks.transactions.SchedulePeriodicity;
import co.com.iris.certification.tasks.transactions.irisaccounts.AccessIrisAccountsOption;
import co.com.iris.certification.tasks.transactions.irisaccounts.SelectIrisAccounts;
import co.com.iris.certification.tasks.transactions.otherbanks.AccessOtherBanksOption;
import co.com.iris.certification.tasks.transactions.otherbanks.ChooseAccountsOtherBanks;
import co.com.iris.certification.tasks.transactions.ownaccounts.TransfersOfOwnAccounts;
import co.com.iris.certification.tasks.transactions.transactionhistory.GoToTransactionHistoric;
import co.com.iris.certification.utils.SetData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.authorization.MyAuthorizationsUI.LABEL_POP_UP1;
import static co.com.iris.certification.userinterfaces.authorization.MyAuthorizationsUI.LABEL_POP_UP2;
import static co.com.iris.certification.userinterfaces.authorization.PendingBankAuthorizationsUI.*;
import static co.com.iris.certification.userinterfaces.authorization.VoucherPendingAuthorizationUI.*;
import static co.com.iris.certification.userinterfaces.transactions.TransactionSummaryUI.*;
import static co.com.iris.certification.userinterfaces.transactionshistory.transactions.TransactionHistoryTableUI.*;
import static co.com.iris.certification.utils.Constants.*;
import static co.com.iris.certification.utils.SetData.formatValueTransfer;
import static co.com.iris.certification.utils.SetData.getCurrentDateFormatDayMonthYear;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OnlineTransferAuthorizationStepDefinition {

    private InfoTrx infoTrx;

    @When("{string} is an unauthorized user and performs an online transaction to other banks using the following credentials:")
    public void isAnUnauthorizedUserAndPerformsAnOnlineTransactionToOtherBanksUsingTheFollowingCredentials(String actor, InfoTrx infoTrx) {
        this.infoTrx=infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccessOtherBanksOption.fromMainMenu(),
                ChooseAccountsOtherBanks.originAndDestination(infoTrx),
                InsertValueCorrect.ofTransaction(infoTrx),
                SchedulePeriodicity.ofTheTransaction(infoTrx),
                AddTag.toTheTransaction(infoTrx),
                Execute.theTransaction(infoTrx)
        );
    }
    @Then("{string} verify that transaction message with authorization pending was showed")
    public void actorVerifyThatTransactionMessageWithAuthorizationPendingWasShowed(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_SUCCESSFUL_TRANSACTION).text().containsIgnoringCase("Transacción pendiente de autorización"),
                WaitUntil.the(LABEL_SUCCESSFUL_TRANSACTION_AMOUNT, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Ensure.that(LABEL_MESSAGE_PENDING_APPROVAL.resolveFor(OnStage.theActorInTheSpotlight())
                                .getText().replace(",", "").replaceAll("\\R", " "))
                        .contains("Tu transferencia de $" + infoTrx.getTransferValue() + " se realizará cuando sea autorizada.")
        );
    }

    @When("{string} is an unauthorized user and performs an online transaction between iris accounts using the following credentials:")
    public void isAnUnauthorizedUserAndPerformsAnOnlineTransactionBetweenIrisAccountsUsingTheFollowingCredentials(String actor, InfoTrx infoTrx) {
        this.infoTrx=infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccessIrisAccountsOption.fromMainMenu(),
                SelectIrisAccounts.forTransaction(infoTrx),
                InsertValueCorrect.ofTransaction(infoTrx),
                SchedulePeriodicity.ofTheTransaction(infoTrx),
                AddTag.toTheTransaction(infoTrx),
                Execute.theTransaction(infoTrx)
        );
    }

    @When("{string} is an unauthorized user and performs an online transaction between own accounts using the following credentials:")
    public void isAnUnauthorizedUserAndPerformsAnOnlineTransactionBetweenOwnAccountsUsingTheFollowingCredentials(String actor, InfoTrx infoTrx) {
        this.infoTrx=infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                TransfersOfOwnAccounts.goTo(infoTrx),
                SelectIrisAccounts.forTransaction(infoTrx),
                InsertValueCorrect.ofTransaction(infoTrx),
                SchedulePeriodicity.ofTheTransaction(infoTrx),
                AddTag.toTheTransaction(infoTrx),
                Execute.theTransaction(infoTrx)
        );
    }

    @When("{string} searches and approves the transaction pending approval in the my approvals table")
    public void searchesAndApprovesTheTransactionPendingApprovalInTheMyApprovalsTable(String user, InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AuthorizeTransactions.goToAuthorization(infoTrx, TYPE_OPERATION_TRANSFER),
                SearchCorrectRegister.onTableMyAuthorizations(infoTrx, TYPE_OPERATION_TRANSFER),
                SelectRegister.click(),
                AuthorizeTransfer.fromTheRecordDetail(infoTrx)
        );
    }

    @Then("{string} verifies successful approval messages")
    public void verifiesSuccessfulApprovalMessages(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_POP_UP1).text().contains("Transacción autorizada con éxito."),
                Ensure.that(LABEL_POP_UP2.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", ""))
                        .contains("Autorizamos la transacción por un total de $" + infoTrx.getTransferValue() + " y ya están en procesamiento."),
                WaitUntil.the(LABEL_POP_UP2, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    @When("{string} searches and approves for the transaction pending approval in the table my authorizations")
    public void searchesAndApprovesForTheTransactionPendingApprovalInTheTableMyAuthorizations(String user, InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AuthorizeTransactions.goToAuthorization(infoTrx, TYPE_OPERATION_TRANSFER),
                SearchCorrectRegister.onTableMyAuthorizations(infoTrx, TYPE_OPERATION_TRANSFER),
                SelectAndAuthorize.pendingTransactions(infoTrx)
        );
    }

    @When("{string} looks for and does not authorize the transaction pending authorization from the details of the table my authorizations")
    public void looksForAndDoesNotAuthorizeTheTransactionPendingAuthorizationFromTheDetailsOfTheTableMyAuthorizations(String user, InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AuthorizeTransactions.goToAuthorization(infoTrx, TYPE_OPERATION_TRANSFER),
                SearchCorrectRegister.onTableMyAuthorizations(infoTrx, TYPE_OPERATION_TRANSFER),
                SelectRegister.click(),
                NoAuthorize.transactionPendingFromDetail(infoTrx)
        );
    }

    @Then("{string} verify that NO authorization messages are successful")
    public void verifyThatNOAuthorizationMessagesAreSuccessful(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_POP_UP1).text().contains("Transacción no autorizada con éxito."),
                Ensure.that(LABEL_POP_UP2.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", ""))
                        .contains("No autorizamos la transacción por un total de $" + infoTrx.getTransferValue() + "."),
                WaitUntil.the(LABEL_POP_UP2, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    @When("{string} searches for and does not authorize the transaction pending authorization in the table my authorizations")
    public void searchesForAndDoesNotAuthorizeTheTransactionPendingAuthorizationInTheTableMyAuthorizations(String user, InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AuthorizeTransactions.goToAuthorization(infoTrx, TYPE_OPERATION_TRANSFER),
                SearchCorrectRegister.onTableMyAuthorizations(infoTrx, TYPE_OPERATION_TRANSFER),
                SelectAndNoAuthorize.pendingTransactions(infoTrx)
        );
    }

    @When("{string} goes to pending authorizations table and filters by type transaction")
    public void actorGoesToPendingAuthorizationsTableAndFiltersByTypeTransaction(String actor, InfoTrx infoTrx) {
        this.infoTrx=infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccessToPendingBankAuthorizationsTable.forVerifyTheTrxRecordFound(infoTrx, TYPE_OPERATION_TRANSFER),
                SelectFiltersTrx.forGetTheRecordPendingAuthorization(infoTrx, TYPE_OPERATION_TRANSFER)
        );
    }

    @Then("{string} verifies that the transaction record exists in the pending bank authorizations table")
    public void actorVerifiesThatTheTransactionRecordExistsInThePendingBankAuthorizationsTable(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(COL_OPERATION).text().contains(TYPE_OPERATION_TRANSFER),
                Check.whether(infoTrx.getTypeTransaction().equalsIgnoreCase("Otros bancos")).andIfSo(
                        Ensure.that(COL_TYPE_OPERATION).text().contains(OTHER_BANKS)),
                Check.whether(infoTrx.getTypeTransaction().equalsIgnoreCase("Cuentas iris")).andIfSo(
                        Ensure.that(COL_TYPE_OPERATION).text().contains(IRIS_BANK)),
                Check.whether(infoTrx.getTypeTransaction().equalsIgnoreCase("Cuentas propias")).andIfSo(
                        Ensure.that(COL_TYPE_OPERATION).text().contains(OWN_ACCOUNTS)),
                Ensure.that(COL_QUANTITY).text().contains("1"),
                Ensure.that(COL_CREATION_DATE).text().contains(getCurrentDateFormatDayMonthYear()),
                Ensure.that(COL_EXECUTE_DATE).text().contains(getCurrentDateFormatDayMonthYear()),
                Ensure.that(COL_AUTHORIZERS).text().isNotEmpty(),
                Ensure.that(COL_TAGS).text().contains(infoTrx.getTag()),
                Ensure.that(COL_VALUE.resolveFor(OnStage.theActorInTheSpotlight())
                        .getText().replace(",", "")).isEqualTo("$" + infoTrx.getTransferValue())
        );
    }

    @When("{string} opens the voucher of transaction pending for authorization")
    public void actorOpensTheVoucherOfTransactionPendingForAuthorization(String actor, InfoTrx infoTrx) {
        this.infoTrx=infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccessToPendingBankAuthorizationsTable.forVerifyTheTrxRecordFound(infoTrx, TYPE_OPERATION_TRANSFER),
                SelectFiltersTrx.forGetTheRecordPendingAuthorization(infoTrx, TYPE_OPERATION_TRANSFER),
                OpenVoucherOfPendingAuthorizationTrx.toVerifyItsInformation()
        );
    }

    @Then("{string} verifies that voucher information for the transaction pending authorization is correct")
    public void actorVerifiesThatVoucherInformationForTheTransactionPendingAuthorizationIsCorrect(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Check.whether(infoTrx.getTypeTransaction().equalsIgnoreCase("Otros bancos")).andIfSo(
                        Ensure.that(Text.of(LABEL_TYPE_TRANSACTION)).containsIgnoringCase("Otros bancos"),
                        Ensure.that(Text.of(LABEL_NAME_DESTINATION_BANK)).isEqualTo(infoTrx.getDestinationBank())
                ),
                Check.whether(infoTrx.getTypeTransaction().equalsIgnoreCase("Cuentas iris")).andIfSo(
                        Ensure.that(Text.of(LABEL_TYPE_TRANSACTION)).containsIgnoringCase("Banco Iris"),
                        Ensure.that(Text.of(LABEL_NAME_DESTINATION_BANK)).isEqualTo("Iris"),
                        Ensure.that(Text.of(LABEL_COST_REGISTER)).isEqualTo("$0.00")
                ),
                Check.whether(infoTrx.getTypeTransaction().equalsIgnoreCase("Cuentas propias")).andIfSo(
                        Ensure.that(Text.of(LABEL_TYPE_TRANSACTION)).containsIgnoringCase("Cuentas propias"),
                        Ensure.that(Text.of(LABEL_NAME_DESTINATION_BANK)).isEqualTo("Iris"),
                        Ensure.that(Text.of(LABEL_COST_REGISTER)).isEqualTo("$0.00")
                ),
                Ensure.that(Text.of(LABEL_NUMBER_ORIGIN_ACCOUNT)).endsWith(infoTrx.getOriginAccountNumber()),
                Ensure.that(Text.of(LABEL_NUMBER_DESTINATION_ACCOUNT)).endsWith(infoTrx.getDestinationAccountNumber()).then(Scroll.to(LABEL_TAG_VOUCHER)),
                Ensure.that(Text.of(LABEL_CREATION_DATE_VOUCHER)).isEqualTo(getCurrentDateFormatDayMonthYear()),
                Ensure.that(Text.of(LABEL_EXECUTION_DATE_VOUCHER)).isEqualTo(getCurrentDateFormatDayMonthYear()),
                Ensure.that(formatValueTransfer(Text.of(LABEL_VALUE_REGISTER).answeredBy(OnStage.theActorInTheSpotlight()))).isEqualTo(infoTrx.getTransferValue()),
                Check.whether(infoTrx.getDescription() != null).andIfSo(
                        Ensure.that(Text.of(LABEL_DESCRIPTION_VOUCHER)).isEqualTo(infoTrx.getDescription())
                ).otherwise(Ensure.that(Text.of(LABEL_DESCRIPTION_VOUCHER)).isEqualTo("-")),
                Ensure.that(Text.of(LABEL_TAG_VOUCHER)).isEqualTo(infoTrx.getTag()).then(Click.on(BTN_CLOSE_AUTHORIZATION_VOUCHER))
        );
    }

    @When("{string} goes to transactions historic table and looks for the last transaction with pending authorization")
    public void actorGoesToTransactionsHistoricTableAndLooksForTheLastTransactionWithPendingAuthorization(String actor, InfoTrx infoTrx) {
        this.infoTrx=infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToTransactionHistoric.forAppliesSearchFilters(infoTrx, infoTrx.getTypeTransaction())
        );
    }

    @Then("{string} verifies that found historic record for the transaction pending authorization is correct")
    public void actorVerifiesThatFoundRecordForTheTransactionPendingAuthorizationIsCorrect(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(Text.of(COL_DATE_CREATE)).startsWith(SetData.getCurrentDateFormatDayMonthYear()),
                Ensure.that(Text.of(COL_HOUR_CREATE)).isNotEmpty(),
                Check.whether(infoTrx.getTypeTransaction().equalsIgnoreCase(OTHER_BANKS)).andIfSo(
                        Ensure.that(Text.of(COL_TRANSFERS)).isEqualTo(OTHER_BANKS),
                        Ensure.that(Text.of(COL_DEST_BANK)).containsIgnoringCase(infoTrx.getDestinationBank()),
                        Ensure.that(Text.of(COL_STATUS)).isEqualToIgnoringCase(STATUS_TRANSFER_IN_PROCCESS)
                ),
                Check.whether(infoTrx.getTypeTransaction().equalsIgnoreCase(IRIS_ACCOUNTS)).andIfSo(
                        Ensure.that(Text.of(COL_TRANSFERS)).isEqualToIgnoringCase(IRIS_ACCOUNTS),
                        Ensure.that(Text.of(COL_DEST_BANK)).isEqualTo(BANK_IRIS_NAME),
                        Ensure.that(Text.of(COL_STATUS)).isEqualToIgnoringCase(STATUS_TRANSFER_SUCCESSFUL)
                ),
                Check.whether(infoTrx.getTypeTransaction().equalsIgnoreCase(OWN_ACCOUNTS)).andIfSo(
                        Ensure.that(Text.of(COL_TRANSFERS)).isEqualToIgnoringCase(OWN_ACCOUNTS),
                        Ensure.that(Text.of(COL_DEST_BANK)).isEqualTo(BANK_IRIS_NAME),
                        Ensure.that(Text.of(COL_STATUS)).isEqualToIgnoringCase(STATUS_TRANSFER_SUCCESSFUL)
                ),
                Ensure.that(Text.of(COL_ORIGIN_PRODUCT)).endsWith(infoTrx.getOriginAccountNumber()),
                Ensure.that(Text.of(COL_DEST_ACCOUNT)).endsWith(infoTrx.getDestinationAccountNumber()),
                Ensure.that(Text.of(COL_TAG_TRANSACTION)).isEqualToIgnoringCase(infoTrx.getTag()),
                Ensure.that(SetData.formatValueTransfer(Text.of(COL_AMOUNT_TRANSACTION)
                        .answeredBy(OnStage.theActorInTheSpotlight()))).isEqualTo(infoTrx.getTransferValue())
        );
    }



}