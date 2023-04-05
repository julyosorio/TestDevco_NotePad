package co.com.iris.certification.stepdefinitions.payments;

import co.com.iris.certification.models.transactions.Payment;
import co.com.iris.certification.tasks.payments.*;
import co.com.iris.certification.tasks.payments.historictable.ApplySearchFilters;
import co.com.iris.certification.tasks.payments.paymentssaved.DeletePay;
import co.com.iris.certification.tasks.payments.paymentssaved.LookForTheCorrectRecord;
import co.com.iris.certification.tasks.payments.paymentssaved.OrderSavedPaymentsList;
import co.com.iris.certification.tasks.payments.paymentssaved.SelectPaymentsSavedOption;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.Map;

import static co.com.iris.certification.questions.paymentssaved.ValidateRowPay.inPaySaved;
import static co.com.iris.certification.questions.paymentssaved.ValidateTotalValuePay.inRecordPaySaved;
import static co.com.iris.certification.userinterfaces.payments.AddPayToListUI.BTN_ADD_PAYMENT_TO_THE_LIST;
import static co.com.iris.certification.userinterfaces.payments.AddPayToListUI.LABEL_MESSAGE_INVALID_VALUE;
import static co.com.iris.certification.userinterfaces.payments.SuccessfulPayCompletedUI.LABEL_SUCCESS_MESSAGE_PAY;
import static co.com.iris.certification.userinterfaces.payments.SuccessfulPayCompletedUI.LABEL_TOTAL_VALUE_PAY;
import static co.com.iris.certification.userinterfaces.payments.SuccessfulPaySavedUI.LABEL_WITH_CONTENT_OF_MESSAGE_ABOUT_PAY_SAVED_SUCCESSFULL;
import static co.com.iris.certification.userinterfaces.payments.SuccessfulPaySavedUI.LABEL_WITH_TITLE_OF_MESSAGE_ABOUT_PAY_SAVED_SUCCESSFULL;
import static co.com.iris.certification.userinterfaces.payments.paymentssaved.PaymentsSavedUI.*;
import static co.com.iris.certification.userinterfaces.transactionshistory.payments.PaymentsAndBatchesHistoricTableUI.*;
import static co.com.iris.certification.utils.Constants.*;
import static co.com.iris.certification.utils.SetData.formatValueBigDecimal;
import static co.com.iris.certification.utils.SetData.getCurrentDateFormatDayMonthYear;

public class OnlinePayrollPayIrisAccountsStepDefinition {

    @DataTableType
    public Payment setPay(Map<String, String> infoPay) {
        return new Payment(
                infoPay.get("originAccountNumber"),
                infoPay.get("payId"),
                infoPay.get("tag"),
                infoPay.get("quantity"),
                infoPay.get("destinationBank"),
                infoPay.get("destinationAccountNumber"),
                infoPay.get("payValue"),
                infoPay.get("payType"),
                infoPay.get("createDate"),
                infoPay.get("executeDate"),
                infoPay.get("totalPaymentValue"),
                infoPay.get("emailUser"),
                infoPay.get("paymentQuantityDelete")
        );
    }


    @When("{string} enters the pay value for manual current payroll pay")
    public void actorEntersThePayValueForManualCurrentPayrollPay(String actor, Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectManualPayType.forContinue(PAY_TYPE_PAYROLL),
                SelectOriginProduct.forExecutePayTransaction(infoPay),
                EnterDetailsPay.toIdentifyTheCurrentPayTransaction(infoPay),
                AddPay.toVerifyTheValueEntered(infoPay)
        );
    }

    @Then("{string} verifies if the value entered for manual payroll pay is correct")
    public void actorVerifiesIfTheValueEnteredForManualPayrollPayIsCorrect(String actor, Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Check.whether(Double.parseDouble(infoPay.getPayValue()) <= 0.99).andIfSo(
                        Ensure.that(LABEL_MESSAGE_INVALID_VALUE).text().isEqualToIgnoringCase(MESSAGE_ERROR_WRONG_VALUE_TRX),
                        Ensure.that(BTN_ADD_PAYMENT_TO_THE_LIST).attribute("class").containsIgnoringCase("disabled")
                ).otherwise(
                        Ensure.that(LABEL_MESSAGE_INVALID_VALUE).isNotDisplayed(),
                        Ensure.that(BTN_ADD_PAYMENT_TO_THE_LIST.waitingForNoMoreThan(Duration.ofSeconds(WAITING_TIME))).isEnabled())
        );
    }

    @When("{string} goes to {string} menu and completes the payroll pay transaction with current date")
    @And("The {string} goes to {string} menu and completes the payroll pay transaction with current date")
    public void actorGoesToOptionMenuAndCompletesThePayrollPayTransactionWithCurrentDate(String actor, String payType, Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectManualPayType.forContinue(payType),
                SelectOriginProduct.forExecutePayTransaction(infoPay),
                EnterDetailsPay.toIdentifyTheCurrentPayTransaction(infoPay),
                AddPayments.toPayList(infoPay),
                CompletePay.byTotalValueEnteredInPayList()
        );
    }

    @Then("{string} verifies the message that indicates the payroll manual pay is in process is showed")
    public void verifiesTheMessageThatIndicatesThePayrollManualPayIsInProcessIsShowed(String actor, Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_SUCCESS_MESSAGE_PAY).text().containsIgnoringCase("Transacción pendiente"),
                Ensure.that(formatValueBigDecimal(Text.of(LABEL_TOTAL_VALUE_PAY).answeredBy(OnStage.theActorInTheSpotlight())))
                        .isEqualTo(BigDecimal.valueOf(Integer.parseInt(infoPay.getQuantity()) * Double.parseDouble(infoPay.getPayValue())).setScale(2, RoundingMode.FLOOR))
        );
    }

    @When("{string} looks for the recent payroll manual pay record in the payments and batches historic table")
    public void actorLooksForTheRecentPayrollManualPayRecordFilteringByOptionInThePaymentsAndBatchesHistoricTable(String actor,Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccessToHistoricTable.forLookForThePayDone(),
                ApplySearchFilters.forGetThePayRecordInTable(PAY_TYPE_MANUAL_PAYROLL, infoPay.getTag())
        );
    }

    @Then("{string} verifies that the data of payroll payment  manual record found in historic table is correct")
    public void actorVerifiesThatTheDataOfPayrollPaymentManualRecordFoundInHistoricTableIsCorrect(String actor,Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(COL_CREATION_DATE).text().startsWith(getCurrentDateFormatDayMonthYear()),
                Ensure.that(COL_PAY_ID).text().isEqualTo(infoPay.getPayId()),
                Ensure.that(COL_PAY_TYPE).text().isEqualTo(VALUE_PAY_TYPE_MANUAL_PAYROLL),
                Ensure.that(COL_TOTAL_PAYMENTS).text().isEqualTo(infoPay.getQuantity()),
                Ensure.that(COL_PAYMENTS_IN_PROCCESS).text().isNotEmpty(),
                Ensure.that(COL_PAYMENTS_WITH_ERROR).text().isNotEmpty(),
                Ensure.that(COL_TAG).text().isEqualTo(infoPay.getTag()),
                Ensure.that(formatValueBigDecimal(Text.of(COL_VALUE_PAY).answeredBy(OnStage.theActorInTheSpotlight())))
                        .isEqualTo(BigDecimal.valueOf(Integer.parseInt(infoPay.getQuantity()) * Double.parseDouble(infoPay.getPayValue())).setScale(2, RoundingMode.FLOOR)),
                Ensure.that(COL_STATUS_PAY).text().isNotEmpty()
        );
    }

    @When("{string} goes to {string} menu and save the payroll pay transaction with current date")
    public void actorGoesToPayrollMenuAndSaveThePayrollPayTransactionWithCurrentDate(String actor, String payType, Payment infoPay){
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectManualPayType.forContinue(payType),
                SelectOriginProduct.forExecutePayTransaction(infoPay),
                EnterDetailsPay.toIdentifyTheCurrentPayTransaction(infoPay),
                AddPayments.toPayList(infoPay),
                SavePay.forUseThisPaymentLater()
        );
    }

    @Then("{string} verifies the payroll pay saved successfull message")
    public void actorVerfiesThePayrollPaySavedSuccessfullMessage(String actor){
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_WITH_TITLE_OF_MESSAGE_ABOUT_PAY_SAVED_SUCCESSFULL).text().isEqualTo("¡Pago guardado!"),
                Ensure.that(LABEL_WITH_CONTENT_OF_MESSAGE_ABOUT_PAY_SAVED_SUCCESSFULL).text().isEqualTo("Puedes acceder y completar tu pago mas tarde.")
        );
    }

    @When("{string} looks for the record correct of payroll pay in saved payments table")
    public void actorLooksForTheRecordCorrectOfPayrollPayInSavedPaymentsTable(String actor, Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectPaymentsSavedOption.fromMainMenu(),
                OrderSavedPaymentsList.forFindTheCorrectRecord(),
                LookForTheCorrectRecord.inSavedPaymentsTable(infoPay)
        );
    }

    @Then("{string} verifies the information present in the record payroll pay found")
    public void actorVerifiesTheInformationPresentInTheRecordPayrollPayFound(String actor, Payment infoPay) {
        int row = OnStage.theActorInTheSpotlight().recall("numRow");
        OnStage.theActorInTheSpotlight().attemptsTo(Ensure.that("pay ID value", inPaySaved(ROW_ID_PAY, row)).isEqualTo(infoPay.getPayId()),
                Ensure.that("amount payments ", inPaySaved(ROW_AMOUNT_PAYMENTS, row)).isEqualTo(infoPay.getQuantity()),
                Ensure.that("type pay", inPaySaved(ROW_PAY_TYPE, row)).isEqualTo(VALUE_PAY_TYPE_MANUAL_PAYROLL),
                Ensure.that("creation date", inPaySaved(ROW_CREATE_DATE_PAY, row)).isEqualTo(infoPay.getCreateDate()),
                Ensure.that("tag", inPaySaved(ROW_TAG_PAY, row)).isEqualTo(infoPay.getTag()),
                Ensure.that("total value pay", inRecordPaySaved(ROW_TOTAL_VALUE_PAY, row))
                        .isEqualTo(BigDecimal.valueOf(Integer.parseInt(infoPay.getQuantity()) * Double.parseDouble(infoPay.getPayValue())).setScale(2, RoundingMode.FLOOR)));
    }

    @When("{string} looks for the payroll pay in the saved payments table and delete it")
    public void actorLooksForThePayrollPayInTheSavedPaymentsTableAndDeleteIt(String actor, Payment infoPay){
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectPaymentsSavedOption.fromMainMenu(),
                OrderSavedPaymentsList.forFindTheCorrectRecord(),
                LookForTheCorrectRecord.inSavedPaymentsTable(infoPay),
                DeletePay.fromSavedPaymentsTable()
        );
    }

    @Then("{string} verifies that payroll payment was deleted successfull")
    public void actorVerifiesThatPayrollPaymentWasDeletedSuccessfull(String actor){

    }

}
