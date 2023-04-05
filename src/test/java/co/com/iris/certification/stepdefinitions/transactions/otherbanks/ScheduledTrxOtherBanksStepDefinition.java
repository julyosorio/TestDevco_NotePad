package co.com.iris.certification.stepdefinitions.transactions.otherbanks;

import co.com.iris.certification.models.transactions.InfoTrx;
import co.com.iris.certification.tasks.transactions.MenuPendingTransactions;
import co.com.iris.certification.tasks.transactions.*;
import co.com.iris.certification.tasks.transactions.otherbanks.AccessOtherBanksOption;
import co.com.iris.certification.tasks.transactions.otherbanks.ChooseAccountsOtherBanks;
import co.com.iris.certification.tasks.transactions.scheduledtransaction.ScheduledTransactions;
import co.com.iris.certification.tasks.transactions.scheduledtransaction.SelectARegisterCorrect;
import co.com.iris.certification.tasks.transactions.vouchertransaction.CloseVoucher;
import co.com.iris.certification.tasks.transactions.vouchertransaction.ScrollVoucher;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.transactions.TransactionSummaryUI.*;
import static co.com.iris.certification.userinterfaces.transactions.scheduledtransaction.PeriodicTransactionDetailUI.*;
import static co.com.iris.certification.userinterfaces.transactions.scheduledtransaction.ScheduledTransactionTableUI.*;
import static co.com.iris.certification.utils.Constants.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ScheduledTrxOtherBanksStepDefinition {

    private InfoTrx infoTrx;


    @When("{string} goes to summary page of current transaction to other bank")
    public void goesToSummaryPageOfCurrentTransactionToOtherBank(String user, InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccessOtherBanksOption.fromMainMenu(),
                ChooseAccountsOtherBanks.originAndDestination(infoTrx),
                InsertValueCorrect.ofTransaction(infoTrx),
                SchedulePeriodicity.ofTheTransaction(infoTrx),
                AddTag.toTheTransaction(infoTrx)
        );
    }

    @Then("{string} verifies for scheduled transaction to other bank that information of summary page be equal to the entered information")
    public void verifiesForScheduledTransactionToOtherBankThatInformationOfSummaryPageBeEqualToTheEnteredInformation(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_ORIGIN_ACCOUNT_OWNER).text().isNotEmpty(),
                Ensure.that(LABEL_TYPE_ORIGIN_ACCOUNT).text().isNotEmpty(),
                Ensure.that(LABEL_ORIGIN_ACCOUNT_NUMBER).text().containsIgnoringCase(infoTrx.getOriginAccountNumber()),
                Ensure.that(LABEL_DESTINATION_ACCOUNT_OWNER).text().isNotEmpty(),
                Ensure.that(LABEL_NUM_DOC_ACCOUNT_DESTINATION).text().isNotEmpty().then(Scroll.to(LABEL_TYPE_DESTINATION_ACCOUNT)),
                Ensure.that(LABEL_TYPE_DESTINATION_ACCOUNT).text().isNotEmpty(),
                Ensure.that(LABEL_DESTINATION_ACCOUNT_NUMBER).text().containsIgnoringCase(infoTrx.getDestinationAccountNumber()),
                Ensure.that(LABEL_DESTINATION_BANK).text().containsIgnoringCase(infoTrx.getDestinationBank()),
                Ensure.that(LABEL_COST_TRANSACTION.waitingForNoMoreThan(Duration.ofSeconds(WAITING_TIME))).text().isNotEmpty(),
                Ensure.that(LABEL_TRX_AMMOUNT.resolveFor(OnStage.theActorInTheSpotlight())
                        .getText().replace(",", "")).contains("$" + infoTrx.getTransferValue()),
                Ensure.that(LABEL_PERIODICITY).text().isEqualToIgnoringCase(infoTrx.getPeriodicity()),
                Ensure.that(LABEL_EXECUTION_DATE).text().isEqualTo(infoTrx.getStartTransactionDate()),
                Check.whether(!infoTrx.getPeriodicity().equalsIgnoreCase("Única vez"))
                        .andIfSo(
                                Ensure.that(Text.of(LABEL_FINAL_DATE)).isEqualTo(infoTrx.getFinalTransactionDate()),
                                Ensure.that(LABEL_MESSAGE_FOR_SCHEDULE_TRANSACTIONS).text().isEqualToIgnoringCase("Esto significa que esta transferencia se repetirá desde el "
                                        .concat(infoTrx.getStartTransactionDate().concat(" " + infoTrx.getPeriodicity()).concat("mente hasta el " + infoTrx.getFinalTransactionDate() + ".")))
                        )
                        .otherwise(
                                Ensure.that(LABEL_FINAL_DATE).isNotDisplayed(),
                                Ensure.that(LABEL_TAG).text().isEqualToIgnoringCase(infoTrx.getTag())
                                        .then(Scroll.to(LABEL_TRX_AMMOUNT))
                        ),
                Check.whether(infoTrx.getDescription() == null)
                        .andIfSo(Ensure.that(LABEL_DESCRIPTION_TAG).text().contains("-"))
                        .otherwise(Ensure.that(LABEL_DESCRIPTION_TAG).text().contains(infoTrx.getDescription()))
        );
    }

    @Given("The {string} makes a scheduled transaction to other bank using the following credentials:")
    @When("{string} makes a scheduled transaction to other bank")
    public void makesAScheduledTransactionToOtherBank(String user, InfoTrx infoTrx) {
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

    @Then("{string} verifies that show successful transaction message to other bank")
    public void verifiesThatShowSuccessfulTransactionMessageToOtherBank(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_SUCCESSFUL_TRANSACTION).text().containsIgnoringCase("Transacción exitosa"),
                WaitUntil.the(LABEL_SUCCESSFUL_TRANSACTION_AMOUNT, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Ensure.that(LABEL_SUCCESSFUL_TRANSACTION_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight())
                        .getText().replace(",", "")).contains("$" + infoTrx.getTransferValue())
        );
    }

    @When("{string} searches the scheduled transactions table for the transaction with the data")
    public void searchesTheScheduledTransactionsTableForTheTransactionWithTheData(String user, InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                MenuPendingTransactions.goToTheMenuProgrammed(TYPE_OPERATION_TRANSFER),
                ScheduledTransactions.applyFilters(infoTrx, OTHER_BANKS)
        );
    }

    @Then("{string} validate that the information of the scheduled transaction table register was correct")
    public void validateThatTheInformationOfTheScheduledTransactionTableRegisterWasCorrect(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(COL_TRANSACTIONTYPE).text().contains(OTHER_BANKS),
                Ensure.that(COL_ORIGINACCOUNT).text().contains("••••" + infoTrx.getOriginAccountNumber()),
                Ensure.that(COL_DESTINATIONBANK).text().contains(infoTrx.getDestinationBank()),
                Ensure.that(COL_DESTINATIONACCOUNT).text().contains("••••" + infoTrx.getDestinationAccountNumber()),
                Ensure.that(COL_INITIALDATE).text().startsWith(DATE_CURRENT),
                Ensure.that(COL_SCHEDULEDDATE).text().contains(infoTrx.getStartTransactionDate()),
                Ensure.that(COL_TAG).text().contains(infoTrx.getTag()),
                Ensure.that(COL_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight())
                        .getText().replace(",", "").replace("$", "")).isEqualTo(infoTrx.getTransferValue()),
                Check.whether(infoTrx.getPeriodicity().equals("Única vez")).andIfSo(
                        Ensure.that(COL_PERIODICITY).text().isEmpty()
                ).otherwise(
                        Ensure.that(COL_PERIODICITY).text().startsWith(infoTrx.getPeriodicity()),
                        Ensure.that(COL_PERIODICITYDATE).text().contains("Fecha final: " + infoTrx.getFinalTransactionDate())
                )
        );
    }

    @When("{string} searches the scheduled transactions table for the voucher with the data")
    public void searchesTheScheduledTransactionsTableForTheVoucherWithTheData(String user, InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                MenuPendingTransactions.goToTheMenuProgrammed(TYPE_OPERATION_TRANSFER),
                ScheduledTransactions.applyFilters(infoTrx, OTHER_BANKS),
                SelectARegisterCorrect.scheduledTransactionTable(infoTrx, OTHER_BANKS)
        );
    }

    @Then("{string} validate that the information of the voucher was correct")
    public void validateThatTheInformationOfTheVoucherWasCorrect(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_ACCOUNT_ORIGIN).text().contains("••••" + infoTrx.getOriginAccountNumber()),
                Ensure.that(LABEL_DESTINED_BANK).text().contains(infoTrx.getDestinationBank()),
                Ensure.that(LABEL_DESTINATION_ACCOUNT).text().contains("••••" + infoTrx.getDestinationAccountNumber()),
                Ensure.that(LABEL_CREATION_DATE).text().contains(DATE_CURRENT),
                Ensure.that(LABEL_EXECUTE_DATE).text().contains(infoTrx.getStartTransactionDate()).then(ScrollVoucher.goTo()),
                Ensure.that(LABEL_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", "")).contains("$" + infoTrx.getTransferValue()),
                Ensure.that(LABEL_TAG_PERIODIC).text().contains(infoTrx.getTag()),
                Check.whether(infoTrx.getPeriodicity().equals("Semanal") || equals("Quincenal") || equals("Mensual"))
                        .andIfSo(
                                Ensure.that(LABEL_TITLE_MESSAGE).text().containsIgnoringCase("Transacción periódica"),
                                Ensure.that(LABEL_SUBTITLE_MESSAGE).text().containsIgnoringCase("Esta transferencia hace parte de una transacción periódica "
                                        + infoTrx.getPeriodicity() + " con fecha final el " + infoTrx.getFinalTransactionDate())
                        ),
                Check.whether(infoTrx.getDescription() == null)
                        .andIfSo(Ensure.that(LABEL_DESCRIPTION).text().contains("-").then(CloseVoucher.onClick()))
                        .otherwise(Ensure.that(LABEL_DESCRIPTION).text().contains(infoTrx.getDescription()).
                                then(CloseVoucher.onClick()))
        );
    }

    @When("{string} deletes a scheduled transaction to other banks from the detail of a selected record in the scheduled transactions table")
    public void deletesAScheduledTransactiontoOtherBanksFromTheDetailOfASelectedRecordInTheScheduledTransactionsTable(String actor, InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                MenuPendingTransactions.goToTheMenuProgrammed(TYPE_OPERATION_TRANSFER),
                ScheduledTransactions.applyFilters(infoTrx, OTHER_BANKS),
                SelectARegisterCorrect.scheduledTransactionTable(infoTrx, OTHER_BANKS),
                DeleteScheduledTrx.fromTheDetail()
        );
    }

    @Then("{string} verifies the successful deletion message of a scheduled transaction to other banks")
    public void verifiesTheSuccessfulDeletionMessageOfAScheduledTransactionToOtherBanks(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(TEXT_MSG1_POP_UP).text().isEqualTo("Transacción eliminada con éxito."),
                Ensure.that(TEXT_MSG2_POP_UP.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", ""))
                        .isEqualTo("Eliminamos la transacción por un total de $"+infoTrx.getTransferValue()+" de sus programaciones."),
                WaitUntil.the(TEXT_MSG2_POP_UP, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))
        );
    }
}
