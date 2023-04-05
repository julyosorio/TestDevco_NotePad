package co.com.iris.certification.stepdefinitions.payments;

import co.com.iris.certification.models.transactions.Payment;
import co.com.iris.certification.tasks.transactions.MenuPendingTransactions;
import co.com.iris.certification.tasks.payments.*;
import co.com.iris.certification.tasks.payments.scheduled.TableScheduledPayments;
import co.com.iris.certification.utils.SetData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static co.com.iris.certification.userinterfaces.payments.SuccessfulPayCompletedUI.LABEL_SUCCESS_MESSAGE_PAY;
import static co.com.iris.certification.userinterfaces.payments.SuccessfulPayCompletedUI.LABEL_TOTAL_VALUE_SCHEDULED_PAY;
import static co.com.iris.certification.userinterfaces.payments.scheduledpayments.ScheduledPaymentsTableUI.*;
import static co.com.iris.certification.utils.Constants.*;

public class ScheduledPayrollPayStepDefinition {

    private Payment payment;
    @When("{string} goes to {string} menu and completes the payroll pay transaction with scheduled date")
    public void actorGoesToPayrollMenuAndCompletesThePayrollPayTransactionWithScheduledDate(String actor, String payType, Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectManualPayType.forContinue(payType),
                SelectOriginProductAndExecuteDate.forScheduleThePay(infoPay),
                EnterDetailsPay.toIdentifyTheCurrentPayTransaction(infoPay),
                AddPayments.toPayList(infoPay),
                CompletePay.byTotalValueEnteredInPayList()
        );
    }

    @Then("{string} verifies the message that indicates the scheduled payroll pay is in process is showed")
    public void actorVerifiesTheMessageThatIndicatesTheScheduledPayrollPayIsInProcessIsShowed(String actor, Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                    Ensure.that(LABEL_SUCCESS_MESSAGE_PAY).text().containsIgnoringCase("Transacción pendiente"),
                Ensure.that(SetData.removeLineBreak(Text.of(LABEL_TOTAL_VALUE_SCHEDULED_PAY).answeredBy(OnStage.theActorInTheSpotlight())))
                        .isEqualTo("Tu pago de $"+BigDecimal.valueOf(Integer.parseInt(infoPay.getQuantity()) * Double.parseDouble(infoPay.getPayValue())).setScale(2, RoundingMode.FLOOR)+ " se encuentra programado.")
        );
    }

    @When("{string} searches in the programmed table for the payroll payment with the following data")
    public void searchesInTheProgrammedTableForThePayrollPaymentWithTheFollowingData(String actor, Payment payment) {
        this.payment = payment;
        OnStage.theActorInTheSpotlight().attemptsTo(
                MenuPendingTransactions.goToTheMenuProgrammed(TYPE_OPERATION_PAYMENTS),
                TableScheduledPayments.applyFilters(payment)
        );
    }

    @Then("{string} verifies that the payroll record information in the programmed table is correct.")
    public void verifiesThatThePayrollRecordInformationInTheProgrammedTableIsCorrect(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(COL_PAYMENT_ID).text().isEqualTo(payment.getPayId()),
                Check.whether(payment.getPayType().equals("Manuales:Nomina"))
                        .andIfSo(Ensure.that(COL_PAYMENT_TYPE).text().isEqualTo(MANUAL_PAYROLL))
                        .otherwise(Ensure.that(COL_PAYMENT_TYPE).text().isEqualTo(IN_LOT_PAYROLL)),
                Ensure.that(COL_QUANTITY).text().isEqualTo(payment.getQuantity()),
                Ensure.that(COL_PAYMENT_TAG).text().isEqualTo(payment.getTag()),
                Ensure.that(COL_DATE_OF_CREATION).text().startsWith(DATE_CURRENT),
                Ensure.that(COL_SCHEDULED_DATE).text().isEqualTo(payment.getExecuteDate()),
                Ensure.that(COL_TOTAL_VALUE.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", ""))
                        .contains("$"+BigDecimal.valueOf(Integer.parseInt(payment.getQuantity()) * Double.parseDouble(payment.getPayValue())))
        );
    }
}
