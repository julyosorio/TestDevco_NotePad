package co.com.iris.certification.stepdefinitions.transactions.otherbanks;

import co.com.iris.certification.models.transactions.InfoTrx;
import co.com.iris.certification.tasks.sessionclose.SessionClose;
import co.com.iris.certification.tasks.transactions.*;
import co.com.iris.certification.tasks.transactions.otherbanks.AccessOtherBanksOption;
import co.com.iris.certification.tasks.transactions.otherbanks.ChooseAccountsOtherBanks;
import co.com.iris.certification.tasks.transactions.sendvoucherbyemail.SwitchFrameEmail;
import co.com.iris.certification.tasks.transactions.sendvoucherbyemail.ValidateVoucherByEmail;
import co.com.iris.certification.tasks.transactions.transactiondetail.SelectRegisterCorrect;
import co.com.iris.certification.tasks.transactions.transactiondetail.TransactionDetail;
import co.com.iris.certification.tasks.transactions.transactionhistory.GoToTransactionHistoric;
import co.com.iris.certification.tasks.transactions.transactionhistory.SelectTheRegisterCorrect;
import co.com.iris.certification.tasks.transactions.vouchertransaction.CloseVoucher;
import co.com.iris.certification.tasks.transactions.vouchertransaction.ScrollVoucher;
import co.com.iris.certification.tasks.transactions.vouchertransaction.SendVoucherByEmail;
import co.com.iris.certification.tasks.transactions.vouchertransaction.ShowInitialVoucher;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.Map;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.BTN_INIT_EXIT;
import static co.com.iris.certification.userinterfaces.transactions.TransactionSummaryUI.*;
import static co.com.iris.certification.userinterfaces.transactions.TransferValueUI.LABEL_WRONG_AMOUNT;
import static co.com.iris.certification.userinterfaces.transactions.irisaccounts.IrisAccountsUI.BTN_NEXT_STEP;
import static co.com.iris.certification.userinterfaces.transactions.pendingtransaction.PendingTransactionVoucherUI.*;
import static co.com.iris.certification.userinterfaces.transactions.transactiondetail.TransactionDetailTableUI.*;
import static co.com.iris.certification.userinterfaces.transactions.voucher.SuccessfulVoucherUI.*;
import static co.com.iris.certification.userinterfaces.transactionshistory.transactions.TransactionHistoryTableUI.*;
import static co.com.iris.certification.userinterfaces.yopmail.YopMailUI.LABEL_EMAIL_MESSAGE_BODY;
import static co.com.iris.certification.userinterfaces.yopmail.YopMailUI.LABEL_EMAIL_SUBJETC;
import static co.com.iris.certification.utils.Constants.*;
import static co.com.iris.certification.utils.SetData.getCurrentDateFormatDayMonthYear;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OnlineTrxOtherBanksStepDefinition {

    private InfoTrx infoTrx;
    private double valueTrx;

    @DataTableType
    public InfoTrx trxDetails(Map<String, String> data) {
        return new InfoTrx(
                data.get("originAccountNumber"),
                data.get("destinationBank"),
                data.get("destinationAccountNumber"),
                data.get("transferValue"),
                data.get("description"),
                data.get("tag"),
                data.get("startTransactionDate"),
                data.get("finalTransactionDate"),
                data.get("periodicity"),
                data.get("emailUser"),
                data.get("ownerDestinationAccount"),
                data.get("docTypeDestinationAccount"),
                data.get("docNumDestinationAccount"),
                data.get("destinationAccountType"),
                data.get("requiresSaveSubscription"),
                data.get("descriptionSubsAccount"),
                data.get("emailSubsAccount"),
                data.get("typeTransaction")
        );
    }

    @Before
    public void actorConfig() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void closeSession() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(BTN_INIT_EXIT, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                SessionClose.logout()
        );
    }

    @When("{string} enters the transfer value for transaction to other banks")
    public void entersTheTransferValueForTransactionToOtherBanks(String user, InfoTrx infoTrx) {
        valueTrx = Double.parseDouble(infoTrx.getTransferValue());
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccessOtherBanksOption.fromMainMenu(),
                ChooseAccountsOtherBanks.originAndDestination(infoTrx),
                InsertTransferValue.forAssessItsValidity(infoTrx)
        );
    }

    @Then("{string} verifies if the value of the transfer to other banks is correct")
    public void verifiesIfTheValueOfTheTransferToOtherBanksIsCorrect(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Check.whether(valueTrx <= 0.99).andIfSo(
                        Ensure.that(LABEL_WRONG_AMOUNT).text().isEqualToIgnoringCase(MESSAGE_ERROR_WRONG_VALUE_TRX),
                        Ensure.that(BTN_NEXT_STEP).isDisabled()
                ).otherwise(
                        Ensure.that(LABEL_WRONG_AMOUNT).isNotDisplayed(),
                        Ensure.that(BTN_NEXT_STEP.waitingForNoMoreThan(Duration.ofSeconds(WAITING_TIME))).isEnabled()
                )
        );
    }

    @When("{string} goes to summary page of current transaction to other banks")
    public void actorGoesToSummaryPageOfCurrentTransactionToOtherBanks(String user, InfoTrx trx) {
        this.infoTrx = trx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccessOtherBanksOption.fromMainMenu(),
                ChooseAccountsOtherBanks.originAndDestination(trx),
                InsertValueCorrect.ofTransaction(trx),
                SchedulePeriodicity.ofTheTransaction(trx),
                AddTag.toTheTransaction(trx)
        );
    }

    @Then("{string} verifies the online transaction information to other banks on the summary page matches the information entered")
    public void verifiesTheOnlineTransactionInformationToOtherBanksOnTheSummaryPageMatchesTheInformationEntered(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_ORIGIN_ACCOUNT_OWNER).text().isNotEmpty(),
                Ensure.that(LABEL_TYPE_ORIGIN_ACCOUNT).text().isNotEmpty(),
                Ensure.that(LABEL_ORIGIN_ACCOUNT_NUMBER).text().containsIgnoringCase(infoTrx.getOriginAccountNumber()),
                Ensure.that(LABEL_DESTINATION_ACCOUNT_OWNER).text().isNotEmpty().then(Scroll.to(LABEL_TYPE_DESTINATION_ACCOUNT)),
                Ensure.that(LABEL_NUM_DOC_ACCOUNT_DESTINATION).text().isNotEmpty(),
                Ensure.that(LABEL_TYPE_DESTINATION_ACCOUNT).text().isNotEmpty(),
                Ensure.that(LABEL_DESTINATION_ACCOUNT_NUMBER).text().containsIgnoringCase(infoTrx.getDestinationAccountNumber()),
                Ensure.that(LABEL_DESTINATION_BANK).text().containsIgnoringCase(infoTrx.getDestinationBank()),
                Ensure.that(LABEL_PERIODICITY).text().isEqualTo(TRANSFER_DOESNT_HAVE_PERIODICITY),
                Ensure.that(LABEL_EXECUTION_DATE).text().isEqualTo(getCurrentDateFormatDayMonthYear()),
                Ensure.that(LABEL_FINAL_DATE).isNotDisplayed(),
                Ensure.that(LABEL_TAG).text().isEqualToIgnoringCase(infoTrx.getTag()).then(Scroll.to(LABEL_TRX_AMMOUNT)),
                Check.whether(infoTrx.getDescription() == null)
                        .andIfSo(Ensure.that(LABEL_DESCRIPTION_TAG).text().contains("-"))
                        .otherwise(Ensure.that(LABEL_DESCRIPTION_TAG).text().contains(infoTrx.getDescription())),
                Ensure.that(LABEL_TRX_AMMOUNT.resolveFor(OnStage.theActorInTheSpotlight())
                        .getText().replace(",", "")).contains("$" + infoTrx.getTransferValue()),
                WaitUntil.the(LABEL_COST_TRANSACTION, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Ensure.that(LABEL_COST_TRANSACTION).text().isNotEmpty()
        );
    }

    @When("{string} makes a transaction online to other banks")
    @Given("{string} makes a transaction online to other banks using the following credentials:")
    public void makesATransactionOnlineToOtherBanks(String user, InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccessOtherBanksOption.fromMainMenu(),
                ChooseAccountsOtherBanks.originAndDestination(infoTrx),
                InsertValueCorrect.ofTransaction(infoTrx),
                SchedulePeriodicity.ofTheTransaction(infoTrx),
                AddTag.toTheTransaction(infoTrx),
                Execute.theTransaction(infoTrx)
        );
    }

    @Then("{string} verify transaction successful message to other banks")
    public void verifyTransactionSuccessfulMessageToOtherBanks(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_SUCCESSFUL_TRANSACTION).text().containsIgnoringCase("Transacción exitosa"),
                WaitUntil.the(LABEL_SUCCESSFUL_TRANSACTION_AMOUNT, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Ensure.that(LABEL_SUCCESSFUL_TRANSACTION_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight())
                        .getText().replace(",", "")).contains("$" + infoTrx.getTransferValue())
        );
    }

    @When("The {string} see the initial voucher of transaction to other banks")
    public void TheSeeTheInitialVoucherOfTransactionToOtherBanks(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ShowInitialVoucher.goTo()
        );
    }

    @Then("{string} validate that the information on the transaction voucher to other banks is correct.")
    public void validateThatTheInformationOnTheTransactionVoucherToOtherBanksIsCorrect(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_ORIGIN_ACCOUNT).text().endsWith(infoTrx.getOriginAccountNumber()),
                Ensure.that(LABEL_DESTINATION_ACCOUNT).text().endsWith(infoTrx.getDestinationAccountNumber()),
                Ensure.that(LABEL_DESTINATION_BANK_VOUCHER).text().contains(infoTrx.getDestinationBank()),
                Ensure.that(LABEL_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight())
                        .getText().replace(",", "")).contains("$" + infoTrx.getTransferValue()),
                Check.whether(infoTrx.getDescription() == null)
                        .andIfSo(Ensure.that(LABEL_DESCRIPTION).text().contains("-"))
                        .otherwise(Ensure.that(LABEL_DESCRIPTION).text().contains(infoTrx.getDescription()))
                        .then(CloseVoucher.onClick())
        );
    }

    @When("{string} look for the transaction to other banks in the transaction detail table")
    public void lookForTheTransactionToOtherBanksInTheTransactionDetailTable(String user, InfoTrx infoTrx) {
        this.infoTrx=infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                TransactionDetail.goTo(infoTrx)
        );
    }

    @Then("{string} validate that the information of the transaction detail table register is correct for trx to other banks")
    public void validateThatTheInformationOfTheTransactionDetailTableRegisterIsCorrectForTrxToOtherBanks(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(COL_DATE_EXECUTE).text().startsWith(DATE_CURRENT),
                Ensure.that(COL_PRODUCT).text().contains("••••" + infoTrx.getOriginAccountNumber()),
                Ensure.that(COL_OPERATION_TYPE).text().contains("Transferencias"),
                Ensure.that(COL_DESTINATION_BANK).text().contains(infoTrx.getDestinationBank()),
                Ensure.that(COL_DESTINATION_ACCOUNT).text().contains("••••" + infoTrx.getDestinationAccountNumber()),
                Ensure.that(COL_TAG).text().contains(infoTrx.getTag()),
                Ensure.that(COL_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight())
                        .getText().replace(",", "")).contains("$" + infoTrx.getTransferValue())
        );
    }


    @When("{string} look for the transaction to other banks in the transaction detail table register")
    public void lookForTheTransactionToOtherBanksInTheTransactionDetailTableRegister(String user, InfoTrx infoTrx) {
        this.infoTrx=infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                TransactionDetail.goTo(infoTrx),
                SelectRegisterCorrect.transactionDetailTable(infoTrx, OTHER_BANKS)
        );
    }

    @Then("{string} validate that the information of the transaction detail table voucher is correct for trx to other banks")
    public void validateThatTheInformationOfTheTransactionDetailTableVoucherIsCorrectForTrxToOtherBanks(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_ORIGIN_ACCOUNT).text().endsWith(infoTrx.getOriginAccountNumber()),
                Ensure.that(LABEL_DESTINATION_ACCOUNT).text().endsWith(infoTrx.getDestinationAccountNumber()),
                Ensure.that(LABEL_DESTINATION_BANK_VOUCHER).text().contains(infoTrx.getDestinationBank()).then(ScrollVoucher.goTo()),
                Ensure.that(LABEL_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight())
                        .getText().replace(",", "")).contains("$" + infoTrx.getTransferValue()),
                Check.whether(infoTrx.getDescription() == null)
                        .andIfSo(Ensure.that(LABEL_DESCRIPTION).text().contains("-"))
                        .otherwise(Ensure.that(LABEL_DESCRIPTION).text().contains(infoTrx.getDescription()))
                        .then(CloseVoucher.onClick())
        );
    }

    @When("{string} look for the transaction to other banks in the transaction historic table")
    public void lookForTheTransactionToOtherBanksInTheTransactionHistoricTable(String user, InfoTrx infoTrx) {
        this.infoTrx=infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToTransactionHistoric.forAppliesSearchFilters(infoTrx, OTHER_BANKS)
        );
    }

    @Then("{string} validate that the information of the historic transaction table register is correct for trx to other banks")
    public void validateThatTheInformationOfTheHistoricTransactionTableRegisterIsCorrectForTrxToOtherBanks(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(COL_DATE_CREATE).text().startsWith(DATE_CURRENT),
                Ensure.that(COL_TRANSFERS).text().isEqualTo(OTHER_BANKS),
                Ensure.that(COL_ORIGIN_PRODUCT).text().contains("••••" + infoTrx.getOriginAccountNumber()),
                Ensure.that(COL_DEST_BANK).text().containsIgnoringCase(infoTrx.getDestinationBank()),
                Ensure.that(COL_DEST_ACCOUNT).text().contains("••••" + infoTrx.getDestinationAccountNumber()),
                Ensure.that(COL_TAG_TRANSACTION).text().isEqualToIgnoringCase(infoTrx.getTag()),
                Ensure.that(COL_AMOUNT_TRANSACTION.resolveFor(OnStage.theActorInTheSpotlight())
                        .getText().replace(",", "")).isEqualTo("$" + infoTrx.getTransferValue()),
                Ensure.that(COL_STATUS).text().isEqualToIgnoringCase(STATUS_TRANSFER_IN_PROCCESS)
        );
    }

    @When("{string} look for the transaction to other banks in the transaction history table register")
    public void lookForTheTransactionToOtherBanksInTheTransactionHistoryTableRegister(String user, InfoTrx infoTrx) {
        this.infoTrx=infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToTransactionHistoric.forAppliesSearchFilters(infoTrx, OTHER_BANKS),
                SelectTheRegisterCorrect.transactionHistoryTable(infoTrx, OTHER_BANKS)
        );
    }

    @Then("{string} validate that the information of the transaction historic table voucher is correct for trx to other banks")
    public void validateThatTheInformationOfTheTransactionHistoricTableVoucherIsCorrectForTrxToOtherBanks(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_TITLE_WINDOW).text().contains("Transferencia - Otros bancos"),
                Ensure.that(LABEL_MESSAGE_TRANSACTION_STATUS).text().contains("Transacción en procesamiento"),
                Check.whether(LABEL_MESSAGE_TRANSACTION_STATUS.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains("Transacción en procesamiento")),
                Ensure.that(LABEL_PENDING_TRX_ORIGIN_ACCOUNT).text().endsWith(infoTrx.getOriginAccountNumber()),
                Ensure.that(LABEL_PENDING_TRX_DESTINATION_ACCOUNT).text().endsWith(infoTrx.getDestinationAccountNumber()),
                Ensure.that(LABEL_PENDING_TRX_DESTINATION_BANK).text().contains(infoTrx.getDestinationBank())
                        .then(ScrollVoucher.goTo()),
                Ensure.that(LABEL_PENDING_VALUE.resolveFor(OnStage.theActorInTheSpotlight())
                        .getText().replace(",", "")).contains("$" + infoTrx.getTransferValue()),
                Check.whether(infoTrx.getDescription() == null)
                        .andIfSo(Ensure.that(LABEL_PENDING_DESCRIPTION).text().contains("-"))
                        .otherwise(Ensure.that(LABEL_PENDING_DESCRIPTION).text().contains(infoTrx.getDescription()))
                        .then(CloseVoucher.onClick())
        );
    }
    @When("{string} sends the transaction voucher to other banks by email")
    public void sendsTheTransactionVoucherToOtherBanksByEmail(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ShowInitialVoucher.goTo(),
                SendVoucherByEmail.withDataEmail(infoTrx),
                ValidateVoucherByEmail.goTo(infoTrx)
        );
    }
    @Then("{string} validate that the voucher was received in email")
    public void validateThatTheVoucherWasReceivedInEmail(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_EMAIL_SUBJETC).textContent().contains(TRANSACTION_MESSAGE).then(SwitchFrameEmail.messageBody()),
                Ensure.that(LABEL_EMAIL_MESSAGE_BODY).textContent().contains(TRANSACTION_MESSAGE).then(Switch.toTheOtherWindow())
        );
    }


}
