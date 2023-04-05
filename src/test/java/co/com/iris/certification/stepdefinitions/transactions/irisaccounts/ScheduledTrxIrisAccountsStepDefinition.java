package co.com.iris.certification.stepdefinitions.transactions.irisaccounts;

import co.com.iris.certification.models.transactions.InfoTrx;
import co.com.iris.certification.tasks.transactions.MenuPendingTransactions;
import co.com.iris.certification.tasks.transactions.*;
import co.com.iris.certification.tasks.transactions.irisaccounts.AccessIrisAccountsOption;
import co.com.iris.certification.tasks.transactions.irisaccounts.SelectIrisAccounts;
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

public class ScheduledTrxIrisAccountsStepDefinition {

    private InfoTrx infoTrx;

    @When("{string} goes to summary page of current transaction between iris accounts")
    public void goesToSummaryPageOfCurrentTransactionBetweenIrisAccounts(String actor, InfoTrx infoTrx) {
        this.infoTrx = infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccessIrisAccountsOption.fromMainMenu(),
                SelectIrisAccounts.forTransaction(infoTrx),
                InsertValueCorrect.ofTransaction(infoTrx),
                SchedulePeriodicity.ofTheTransaction(infoTrx),
                AddTag.toTheTransaction(infoTrx)
        );
    }
    @Then("{string} verifies for scheduled transaction between iris accounts that information of summary page be equal to the entered information")
    public void verifiesForScheduledTransactionBetweenIrisAccountsThatInformationOfSummaryPageBeEqualToTheEnteredInformation(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_ORIGIN_ACCOUNT_OWNER).text().isNotEmpty(),
                Ensure.that(LABEL_TYPE_ORIGIN_ACCOUNT).text().isNotEmpty(),
                Ensure.that(LABEL_ORIGIN_ACCOUNT_NUMBER).text().contains(infoTrx.getOriginAccountNumber())
                        .then(Scroll.to(LABEL_DESTINATION_ACCOUNT_OWNER)),
                Ensure.that(LABEL_DESTINATION_ACCOUNT_OWNER).text().isNotEmpty(),
                Ensure.that(LABEL_TYPE_DESTINATION_ACCOUNT).text().isNotEmpty(),
                Ensure.that(LABEL_DESTINATION_ACCOUNT_NUMBER).text().contains(infoTrx.getDestinationAccountNumber())
                        .then(Scroll.to(LABEL_EXECUTION_DATE)),
                Ensure.that(LABEL_EXECUTION_DATE).text().isEqualTo(infoTrx.getStartTransactionDate()),
                Ensure.that(LABEL_PERIODICITY).text().contains(infoTrx.getPeriodicity()),
                Check.whether(!infoTrx.getPeriodicity().contains("Única vez"))
                        .andIfSo(
                                Ensure.that(Text.of(LABEL_FINAL_DATE)).isEqualTo(infoTrx.getFinalTransactionDate()),
                                Ensure.that(LABEL_MESSAGE_FOR_SCHEDULE_TRANSACTIONS).text()
                                        .containsIgnoringCase("Esto significa que esta transferencia se repetirá desde el "
                                                + infoTrx.getStartTransactionDate()
                                        + " " + infoTrx.getPeriodicity() + "mente hasta el " + infoTrx.getFinalTransactionDate() + ".")
                        )
                        .otherwise(
                                Ensure.that(LABEL_FINAL_DATE).isNotDisplayed()),
                Ensure.that(LABEL_TAG).text().isEqualToIgnoringCase(infoTrx.getTag()).then(Scroll.to(LABEL_TRX_AMMOUNT)),
                Check.whether(infoTrx.getDescription() == null)
                        .andIfSo(Ensure.that(LABEL_DESCRIPTION_TAG).text().contains("-"))
                        .otherwise(Ensure.that(LABEL_DESCRIPTION_TAG).text().isEqualTo(infoTrx.getDescription())),
                Ensure.that(LABEL_TRX_AMMOUNT.resolveFor(OnStage.theActorInTheSpotlight()).getText()
                        .replace(",", "")).isEqualTo("$" + infoTrx.getTransferValue())
        );
    }

    @When("{string} makes a scheduled transaction between iris accounts")
    @Given("The {string} makes a scheduled transaction between iris accounts using the following credentials:")
    public void actorMakesAScheduledTransactionBetweenIrisAccounts(String actor, InfoTrx infoTrx) {
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

    @Then("{string} verifies successful scheduled transaction message between iris accounts")
    public void verifiesSuccessfulScheduledTransactionMessageBetweenIrisAccounts(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_SUCCESSFUL_TRANSACTION).text().containsIgnoringCase("Transacción exitosa"),
                WaitUntil.the(LABEL_SUCCESSFUL_TRANSACTION_AMOUNT, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Ensure.that(LABEL_SUCCESSFUL_TRANSACTION_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight())
                        .getText().replace(",", "")).contains("$" + infoTrx.getTransferValue())
        );
    }

    @When("{string} search in the table of scheduled transactions for the transaction between iris accounts")
    public void searchInTheTableOfScheduledTransactionsForTheTransactionBetweenIrisAccounts(String user,InfoTrx infoTrx) {
        this.infoTrx=infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                MenuPendingTransactions.goToTheMenuProgrammed(TYPE_OPERATION_TRANSFER),
                ScheduledTransactions.applyFilters(infoTrx, IRIS_ACCOUNTS)
        );
    }

    @Then("{string} verifies that the information of the scheduled transaction register between iris accounts is correct")
    public void verifiesThatTheInformationOfTheScheduledTransactionRegisterBetweenIrisAccountsIsCorrect(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(COL_TRANSACTIONTYPE).text().contains("Banco Iris"),
                Ensure.that(COL_ORIGINACCOUNT).text().contains("••••" + infoTrx.getOriginAccountNumber()),
                Ensure.that(COL_DESTINATIONBANK).text().contains("Iris"),
                Ensure.that(COL_DESTINATIONACCOUNT).text().contains("••••" + infoTrx.getDestinationAccountNumber()),
                Ensure.that(COL_INITIALDATE).text().startsWith(DATE_CURRENT),
                Ensure.that(COL_SCHEDULEDDATE).text().contains(infoTrx.getStartTransactionDate()),
                Ensure.that(COL_TAG).text().contains(infoTrx.getTag()),
                Ensure.that(COL_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", "")).contains("$" + infoTrx.getTransferValue()),
                Check.whether(infoTrx.getPeriodicity().equals("Única vez")).andIfSo(
                        Ensure.that(COL_PERIODICITY).text().isEmpty()
                ).otherwise(
                        Ensure.that(COL_PERIODICITY).text().startsWith(infoTrx.getPeriodicity()),
                        Ensure.that(COL_PERIODICITYDATE).text().contains("Fecha final: " + infoTrx.getFinalTransactionDate())
                )
        );
    }

    @When("{string} searches the table of scheduled transactions to view the transaction voucher between iris accounts")
    public void searchesTheTableOfScheduledTransactionsToViewTheTransactionVoucherBetweenIrisAccounts(String actor, InfoTrx infoTrx) {
        this.infoTrx=infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                MenuPendingTransactions.goToTheMenuProgrammed(TYPE_OPERATION_TRANSFER),
                ScheduledTransactions.applyFilters(infoTrx, IRIS_ACCOUNTS),
                SelectARegisterCorrect.scheduledTransactionTable(infoTrx, IRIS_ACCOUNTS)
        );
    }

    @Then("{string} verifies that the scheduled transaction voucher information is correct between iris accounts")
    public void verifiesThatTheScheduledTransactionVoucherInformationIsCorrectBetweenIrisAccounts(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_TITLE).text().contains("Transferencia - Banco Iris"),
                Check.whether(!infoTrx.getPeriodicity().equals("Única vez"))
                        .andIfSo(
                                Ensure.that(LABEL_TITLE_MESSAGE).text().containsIgnoringCase("Transacción periódica"),
                                Ensure.that(LABEL_SUBTITLE_MESSAGE).text().containsIgnoringCase("Esta transferencia hace parte de una transacción periódica "
                                        + infoTrx.getPeriodicity() + " con fecha final el " + infoTrx.getFinalTransactionDate())
                                ),
                Ensure.that(LABEL_ACCOUNT_ORIGIN).text().contains("••••" + infoTrx.getOriginAccountNumber()),
                Ensure.that(LABEL_DESTINATION_BANK).text().contains("Iris"),
                Ensure.that(LABEL_DESTINATION_ACCOUNT).text().contains("••••" + infoTrx.getDestinationAccountNumber()),
                Ensure.that(LABEL_CREATION_DATE).text().contains(DATE_CURRENT),
                Ensure.that(LABEL_EXECUTE_DATE).text().contains(infoTrx.getStartTransactionDate()).then(ScrollVoucher.goTo()),
                Ensure.that(LABEL_AMOUNT.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", "")).contains("$" + infoTrx.getTransferValue()),
                Ensure.that(LABEL_COST_TRX).text().contains("$0.00"),
                Ensure.that(LABEL_TAG_PERIODIC).text().contains(infoTrx.getTag()),
                Check.whether(infoTrx.getDescription() == null)
                        .andIfSo(Ensure.that(LABEL_DESCRIPTION).text().contains("-").then(CloseVoucher.onClick()))
                        .otherwise(Ensure.that(LABEL_DESCRIPTION).text().contains(infoTrx.getDescription()).then(CloseVoucher.onClick()))
        );
    }


    @When("{string} deletes a scheduled transaction between iris accounts from the detail of a selected record in the scheduled transactions table")
    public void deletesAScheduledTransactionBetweenIrisAccountsFromTheDetailOfASelectedRecordInTheScheduledTransactionsTable(String actor, InfoTrx infoTrx ) {
        this.infoTrx = infoTrx;
        OnStage.theActorInTheSpotlight().attemptsTo(
                MenuPendingTransactions.goToTheMenuProgrammed(TYPE_OPERATION_TRANSFER),
                ScheduledTransactions.applyFilters(infoTrx, IRIS_ACCOUNTS),
                SelectARegisterCorrect.scheduledTransactionTable(infoTrx, IRIS_ACCOUNTS),
                DeleteScheduledTrx.fromTheDetail()
        );
    }

    @Then("{string} verifies the successful deletion message of a scheduled transaction between iris accounts")
    public void verifiesTheSuccessfulDeletionMessageOfAScheduledTransactionBetweenIrisAccounts(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(TEXT_MSG1_POP_UP).text().isEqualTo("Transacción eliminada con éxito."),
                Ensure.that(TEXT_MSG2_POP_UP.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", ""))
                        .isEqualTo("Eliminamos la transacción por un total de $"+infoTrx.getTransferValue()+" de sus programaciones."),
                WaitUntil.the(TEXT_MSG2_POP_UP, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))
        );
    }
}
