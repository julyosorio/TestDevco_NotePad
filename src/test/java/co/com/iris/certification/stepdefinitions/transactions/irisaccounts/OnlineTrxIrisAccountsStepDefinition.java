package co.com.iris.certification.stepdefinitions.transactions.irisaccounts;

import co.com.iris.certification.models.transactions.InfoTrx;
import co.com.iris.certification.tasks.transactions.*;
import co.com.iris.certification.tasks.transactions.irisaccounts.AccessIrisAccountsOption;
import co.com.iris.certification.tasks.transactions.irisaccounts.SelectIrisAccounts;
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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.transactions.TransactionSummaryUI.*;
import static co.com.iris.certification.userinterfaces.transactions.TransferValueUI.LABEL_WRONG_AMOUNT;
import static co.com.iris.certification.userinterfaces.transactions.irisaccounts.IrisAccountsUI.BTN_NEXT_STEP;
import static co.com.iris.certification.userinterfaces.transactions.transactiondetail.TransactionDetailTableUI.*;
import static co.com.iris.certification.userinterfaces.transactions.voucher.SuccessfulVoucherUI.*;
import static co.com.iris.certification.userinterfaces.transactionshistory.transactions.TransactionHistoryTableUI.*;
import static co.com.iris.certification.userinterfaces.yopmail.YopMailUI.LABEL_EMAIL_MESSAGE_BODY;
import static co.com.iris.certification.userinterfaces.yopmail.YopMailUI.LABEL_EMAIL_SUBJETC;
import static co.com.iris.certification.utils.Constants.*;
import static co.com.iris.certification.utils.SetData.getCurrentDateFormatDayMonthYear;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OnlineTrxIrisAccountsStepDefinition {

    private double valueTrx;
    private InfoTrx infoTrx;

    @When("{string} enters the transfer value for transaction between iris accounts")
    public void actorEntersTheValueTransferForTransactionBetweenIrisAccounts(String user, InfoTrx infotrx) {
        valueTrx = Double.parseDouble(infotrx.getTransferValue());
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccessIrisAccountsOption.fromMainMenu(),
                SelectIrisAccounts.forTransaction(infotrx),
                InsertTransferValue.forAssessItsValidity(infotrx)
        );
    }

    @Then("{string} verifies if the value of the transfer between iris accounts is correct")
    public void verifiesIfTheValueOfTheTransferBetweenIrisAccountsIsCorrect(String user) {
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

    @When("{string} verifies the information on the summary page of the transaction made between iris accounts")
    public void verifiesTheInformationOnTheSummaryPageOfTheTransactionMadeBetweenIrisAccounts(String user, InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccessIrisAccountsOption.fromMainMenu(),
                SelectIrisAccounts.forTransaction(infoTrx),
                InsertValueCorrect.ofTransaction(infoTrx),
                SchedulePeriodicity.ofTheTransaction(infoTrx),
                AddTag.toTheTransaction(infoTrx)
        );
    }

    @Then("{string} verifies the online transaction information between iris accounts on the summary page matches the information entered")
    public void verifiesTheOnlineTransactionInformationBetweenIrisAccountsOnTheSummaryPageMatchesTheInformationEntered(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_ORIGIN_ACCOUNT_OWNER).text().isNotEmpty(),
                Ensure.that(LABEL_TYPE_ORIGIN_ACCOUNT).text().isNotEmpty(),
                Ensure.that(LABEL_ORIGIN_ACCOUNT_NUMBER).text().contains("••••" + infoTrx.getOriginAccountNumber()),
                Ensure.that(LABEL_DESTINATION_ACCOUNT_OWNER).text().isNotEmpty().then(Scroll.to(LABEL_TYPE_DESTINATION_ACCOUNT)),
                Ensure.that(LABEL_TYPE_DESTINATION_ACCOUNT).text().isNotEmpty(),
                Ensure.that(LABEL_DESTINATION_ACCOUNT_NUMBER).text().contains("••••" + infoTrx.getDestinationAccountNumber()),
                Ensure.that(LABEL_PERIODICITY).text().isEqualTo(TRANSFER_DOESNT_HAVE_PERIODICITY),
                Ensure.that(LABEL_EXECUTION_DATE).text().isEqualTo(getCurrentDateFormatDayMonthYear()),
                Ensure.that(LABEL_FINAL_DATE).isNotDisplayed(),
                Ensure.that(LABEL_TAG).text().isEqualToIgnoringCase(infoTrx.getTag()).then(Scroll.to(LABEL_TRX_AMMOUNT)),
                Check.whether(infoTrx.getDescription() == null)
                        .andIfSo(Ensure.that(Text.of(LABEL_DESCRIPTION_TAG)).isEqualTo("-"))
                        .otherwise(Ensure.that(Text.of(LABEL_DESCRIPTION_TAG)).isEqualTo(infoTrx.getDescription())),
                Ensure.that(LABEL_TRX_AMMOUNT.resolveFor(OnStage.theActorInTheSpotlight())
                        .getText().replace(",", "")).contains("$" + infoTrx.getTransferValue())
        );
    }

    @Given("{string} makes a transaction online between iris accounts using the following credentials:")
    @When("{string} makes an online transaction between iris accounts")
    public void theMakesATransactionOnlineBetweenUsingTheFollowingCredentials(String user, InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccessIrisAccountsOption.fromMainMenu(),
                SelectIrisAccounts.forTransaction(infoTrx),
                InsertValueCorrect.ofTransaction(infoTrx),
                SchedulePeriodicity.ofTheTransaction(infoTrx),
                AddTag.toTheTransaction(infoTrx),
                Execute.theTransaction(infoTrx)
        );
    }

    @Then("{string} verify transaction successful message between iris accounts")
    public void verifyTransactionSuccessfulMessageBetweenIrisAccounts(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_SUCCESSFUL_TRANSACTION).text().containsIgnoringCase("Transacción exitosa"),
                WaitUntil.the(LABEL_SUCCESSFUL_TRANSACTION_AMOUNT, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Ensure.that(LABEL_SUCCESSFUL_TRANSACTION_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight())
                        .getText().replace(",", "")).contains("$" + infoTrx.getTransferValue())
        );
    }

    @When("The {string} see the initial voucher of transaction between iris accounts")
    public void theSeeTheInitialVoucherOfTransactionBetweenIrisAccounts(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ShowInitialVoucher.goTo(),
                GetVoucherDate.rememberDate()
        );
    }

    @Then("{string} validate that the information on the transaction voucher between iris accounts is correct.")
    @Then("{string} validate that the information of the transaction detail table voucher is correct for trx between iris accounts")
    @Then("{string} validate that the information of the transaction historic table voucher is correct for trx between iris accounts")
    public void validateThatTheInformationOnTheTransactionVoucherBetweenIrisAccountsIsCorrect(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_ORIGIN_ACCOUNT).text().endsWith(infoTrx.getOriginAccountNumber()),
                Ensure.that(LABEL_DESTINATION_ACCOUNT).text().endsWith(infoTrx.getDestinationAccountNumber()),
                Ensure.that(LABEL_DESTINATION_BANK_VOUCHER).text().contains("Iris").then(ScrollVoucher.goTo()),
                Ensure.that(LABEL_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", "")).contains("$" + infoTrx.getTransferValue()),
                Ensure.that(LABEL_TRANSACTION_COST).text().contains("$0.00"),
                Check.whether(infoTrx.getDescription() == null)
                        .andIfSo(Ensure.that(LABEL_DESCRIPTION).text().contains("-"))
                        .otherwise(Ensure.that(LABEL_DESCRIPTION).text().contains(infoTrx.getDescription()))
                        .then(CloseVoucher.onClick())
        );
    }
    @When("{string} look for the transaction between iris accounts in the transaction detail table")
    public void lookForTheTransactionBetweenIrisAccountsInTheTransactionDetailTable(String user, InfoTrx infoTrx) {
        this.infoTrx =infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                TransactionDetail.goTo(infoTrx)
        );
    }
    @Then("{string} validate that the information of the transaction detail table register is correct for trx between iris accounts")
    public void validateThatTheInformationOfTheTransactionDetailTableRegisterIsCorrectForTrxBetweenIrisAccounts(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(COL_DATE_EXECUTE).text().startsWith(DATE_CURRENT),
                Ensure.that(COL_PRODUCT).text().contains("••••" + infoTrx.getOriginAccountNumber()),
                Ensure.that(COL_OPERATION_TYPE).text().contains("Transferencias"),
                Ensure.that(COL_TRANSACTION_TYPE).text().contains("Transf. cuentas Iris"),
                Ensure.that(COL_DESTINATION_BANK).text().contains("Iris"),
                Ensure.that(COL_DESTINATION_ACCOUNT).text().contains("••••" + infoTrx.getDestinationAccountNumber()),
                Ensure.that(COL_TAG).text().contains(infoTrx.getTag()),
                Ensure.that(COL_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", "")).contains(infoTrx.getTransferValue())
        );
    }

    @When("{string} look for the transaction done between iris accounts in the transaction detail voucher")
    public void lookForTheTransactionDoneBetweenIrisAccountsInTheTransactionDetailVoucher(String user, InfoTrx infoTrx) {
        this.infoTrx =infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                TransactionDetail.goTo(infoTrx),
                SelectRegisterCorrect.transactionDetailTable(infoTrx, IRIS_ACCOUNTS)
        );
    }

    @When("{string} look for the transaction between iris accounts in the transaction historic table")
    public void lookForTheTransactionBetweenIrisAccountsInTheTransactionHistoricTable(String user, InfoTrx infoTrx) {
        this.infoTrx =infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToTransactionHistoric.forAppliesSearchFilters(infoTrx, IRIS_ACCOUNTS)
        );
    }

    @Then("{string} validate that the information of the historic transaction table register is correct for trx between iris accounts")
    public void validateThatTheInformationOfTheHistoricTransactionTableRegisterIsCorrectForTrxBetweenIrisAccounts(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(COL_DATE_CREATE).text().startsWith(DATE_CURRENT),
                Ensure.that(COL_DATE_EXECUTION).text().startsWith(DATE_CURRENT),
                Ensure.that(COL_TRANSFERS).text().isEqualTo(IRIS_ACCOUNTS),
                Ensure.that(COL_ORIGIN_PRODUCT).text().contains(infoTrx.getOriginAccountNumber()),
                Ensure.that(COL_DEST_BANK).text().isEqualTo("Iris"),
                Ensure.that(COL_DEST_ACCOUNT).text().contains(infoTrx.getDestinationAccountNumber()),
                Ensure.that(COL_TAG_TRANSACTION).text().isEqualToIgnoringCase(infoTrx.getTag()),
                Ensure.that(COL_AMOUNT_TRANSACTION.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", "")).isEqualTo("$" + infoTrx.getTransferValue()),
                Ensure.that(COL_STATUS).text().isEqualTo("Exitosa")
        );
    }

    @When("{string} look for the transaction between iris accounts in the transaction history table register")
    public void lookForTheTransactionBetweenIrisAccountsInTheTransactionHistoryTableRegister(String user, InfoTrx infoTrx) {
        this.infoTrx =infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToTransactionHistoric.forAppliesSearchFilters(infoTrx, IRIS_ACCOUNTS),
                SelectTheRegisterCorrect.transactionHistoryTable(infoTrx, IRIS_ACCOUNTS)
        );
    }

    @When("{string} sends the transaction voucher between iris accounts by email")
    public void sendsTheTransactionVoucherBetweenIrisAccountsByEmail(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ShowInitialVoucher.goTo(),
                SendVoucherByEmail.withDataEmail(infoTrx),
                ValidateVoucherByEmail.goTo(infoTrx)
        );
    }

    @Then("{string} validate that the voucher was received in destination email")
    public void validateThatTheVoucherWasReceivedInDestinationEmail(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_EMAIL_SUBJETC).textContent().contains(TRANSACTION_MESSAGE).then(SwitchFrameEmail.messageBody()),
                Ensure.that(LABEL_EMAIL_MESSAGE_BODY).textContent().contains(TRANSACTION_MESSAGE).then(Switch.toTheOtherWindow())
        );
    }


}