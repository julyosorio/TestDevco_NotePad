package co.com.iris.certification.stepdefinitions.authorization;

import co.com.iris.certification.models.transactions.Payment;
import co.com.iris.certification.tasks.authorization.SelectRegister;
import co.com.iris.certification.tasks.payments.*;
import co.com.iris.certification.userinterfaces.payments.PayWithPendingAuthorizationUI;
import co.com.iris.certification.utils.SetData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static co.com.iris.certification.userinterfaces.authorization.MyAuthorizationsUI.LABEL_POP_UP1;
import static co.com.iris.certification.userinterfaces.authorization.MyAuthorizationsUI.LABEL_POP_UP2;
import static co.com.iris.certification.utils.Constants.TYPE_OPERATION_PAYMENTS;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OnlinePaymentAuthorizationStepDefinition {
    private Payment payment;

    @When("{string} goes to {string} menu and completes a payroll pay online without authorization")
    public void actorGoesToPayrollMenuAndCompletesAPayrollPayOnlineWithoutAuthorization(String actor, String payType, Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectManualPayType.forContinue(payType),
                SelectOriginProduct.forExecutePayTransaction(infoPay),
                EnterDetailsPay.toIdentifyTheCurrentPayTransaction(infoPay),
                AddPayments.toPayList(infoPay),
                CompletePay.byTotalValueEnteredInPayList()
        );
    }

    @Then("{string} verifies that message about pay with authorization pending was showed")
    public void actorVerifiesThatMessageAboutPayrollPayWithAuthorizationPendingWasShowed(String actor, Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(PayWithPendingAuthorizationUI.LABEL_PENDING_MESSAGE_PAY).text().containsIgnoringCase("Transacción pendiente"),
                Ensure.that(SetData.removeLineBreak(Text.of(PayWithPendingAuthorizationUI.LABEL_TOTAL_VALUE_PAY).answeredBy(OnStage.theActorInTheSpotlight())))
                        .isEqualTo("Tu pago de $" +
                                BigDecimal.valueOf(Integer.parseInt(infoPay.getQuantity()) * Double.parseDouble(infoPay.getPayValue())).setScale(2, RoundingMode.FLOOR) +
                                " se encuentra pendiente de autorización.")
        );
    }

    @When("{string} goes to {string} menu and completes a supplier pay online without authorization")
    public void actorGoesToSupplierMenuAndCompletesASupplierPayOnlineWithoutAuthorization(String actor, String payType, Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectManualPayType.forContinue(payType),
                SelectOriginProduct.forExecutePayTransaction(infoPay),
                EnterDetailsPay.toIdentifyTheCurrentPayTransaction(infoPay),
                AddPayments.toPayList(infoPay),
                CompletePay.byTotalValueEnteredInPayList()
        );
    }

    @When("{string} goes to {string} menu and completes a scheduled payroll pay without authorization")
    public void actorGoesToPayrollMenuAndCompletesAScheduledPayrollPayWithoutAuthorization(String actor, String payType, Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectManualPayType.forContinue(payType),
                SelectOriginProductAndExecuteDate.forScheduleThePay(infoPay),
                EnterDetailsPay.toIdentifyTheCurrentPayTransaction(infoPay),
                AddPayments.toPayList(infoPay),
                CompletePay.byTotalValueEnteredInPayList()
        );
    }

    @Then("{string} verifies that message about scheduled pay with authorization pending was showed")
    public void actorVerifiesThatMessageAboutScheduledPayWithAuthorizationPendingWasShowed(String actor, Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(PayWithPendingAuthorizationUI.LABEL_PENDING_MESSAGE_PAY).text().containsIgnoringCase("Transacción pendiente"),
                Ensure.that(SetData.removeLineBreak(Text.of(PayWithPendingAuthorizationUI.LABEL_TOTAL_VALUE_PAY).answeredBy(OnStage.theActorInTheSpotlight())))
                        .isEqualTo("Tu pago de $" +
                                BigDecimal.valueOf(Integer.parseInt(infoPay.getQuantity()) * Double.parseDouble(infoPay.getPayValue())).setScale(2, RoundingMode.FLOOR) +
                                " con programación se encuentra pendiente de autorización.")
        );
    }

    @When("{string} goes to {string} menu and completes a scheduled supplier pay without authorization")
    public void actorGoesToSupplierMenuAndCompletesAScheduledSupplierPayWithoutAuthorization(String actor, String payType, Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectManualPayType.forContinue(payType),
                SelectOriginProductAndExecuteDate.forScheduleThePay(infoPay),
                EnterDetailsPay.toIdentifyTheCurrentPayTransaction(infoPay),
                AddPayments.toPayList(infoPay),
                CompletePay.byTotalValueEnteredInPayList()
        );
    }


    @When("{string} looks up and approves the payment pending approval in the table my authorizations")
    public void looksUpAndApprovesThePaymentPendingApprovalInTheTableMyAuthorizations(String actor, Payment payment) {
        this.payment = payment;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AuthorizePaymentsMenu.goToAuthorization(payment, TYPE_OPERATION_PAYMENTS),
                SearchCorrectPaymentRegister.onTableMyAuthorizations(payment, TYPE_OPERATION_PAYMENTS),
                SelectAndAuthorize.pendingPayment(payment)
        );
    }

    @Then("{string} verifies the success of payment approval messages")
    public void verifiesTheSuccessOfPaymentApprovalMessages(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LABEL_POP_UP1, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Check.whether(payment.getQuantity().contains("1"))
                        .andIfSo(Ensure.that(LABEL_POP_UP1).text().contains("Transacción autorizada con éxito."),
                                Ensure.that(LABEL_POP_UP2.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", ""))
                                        .contains("Autorizamos la transacción por un total de $" +
                                                BigDecimal.valueOf(Integer.parseInt(payment.getQuantity()) * Double.parseDouble(payment.getPayValue())).setScale(2, RoundingMode.FLOOR) +
                                                " y ya están en procesamiento."))
                        .otherwise(Ensure.that(LABEL_POP_UP1).text().contains("Transacciones autorizadas con éxito."),
                                Ensure.that(LABEL_POP_UP2.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", ""))
                                        .contains("Autorizamos " + payment.getQuantity() + " transacciones por un total de $" +
                                                BigDecimal.valueOf(Integer.parseInt(payment.getQuantity()) * Double.parseDouble(payment.getPayValue())).setScale(2, RoundingMode.FLOOR) +
                                                " y ya están en procesamiento.")),
                WaitUntil.the(LABEL_POP_UP2, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    @When("{string} searches and approves the payment pending approval in the my approvals table")
    public void searchesAndApprovesThePaymentPendingApprovalInTheMyApprovalsTable(String actor, Payment payment) {
        this.payment = payment;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AuthorizePaymentsMenu.goToAuthorization(payment, TYPE_OPERATION_PAYMENTS),
                SearchCorrectPaymentRegister.onTableMyAuthorizations(payment, TYPE_OPERATION_PAYMENTS),
                SelectRegister.click(),
                AuthorizePayment.fromTheRecordDetail(payment)
        );
    }

    @When("{string} searches for and does not authorize the payment pending authorization in the table my authorizations")
    public void searchesForAndDoesNotAuthorizeThePaymentPendingAuthorizationInTheTableMyAuthorizations(String actor, Payment payment) {
        this.payment = payment;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AuthorizePaymentsMenu.goToAuthorization(payment, TYPE_OPERATION_PAYMENTS),
                SearchCorrectPaymentRegister.onTableMyAuthorizations(payment, TYPE_OPERATION_PAYMENTS),
                SelectAndNoAuthorize.pendingPayments(payment)
        );
    }

    @Then("{string} checks the NO payment authorization message")
    public void checksTheNOPaymentAuthorizationMessage(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Check.whether(payment.getQuantity().equals("1"))
                        .andIfSo(
                                Ensure.that(LABEL_POP_UP1).text().contains("Transacción no autorizada con éxito."),
                                Ensure.that(LABEL_POP_UP2.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", ""))
                                        .contains("No autorizamos la transacción por un total de $" +
                                                BigDecimal.valueOf(Integer.parseInt(payment.getQuantity()) * Double.parseDouble(payment.getPayValue())).setScale(2, RoundingMode.FLOOR) +
                                                ".")
                        )
                        .otherwise(
                                Ensure.that(LABEL_POP_UP1).text().contains("Transacciones no autorizadas con éxito."),
                                Ensure.that(LABEL_POP_UP2.resolveFor(OnStage.theActorInTheSpotlight()).getText().replace(",", ""))
                                        .contains("No autorizamos "+payment.getQuantity()+" transacciones por un total de $" +
                                                BigDecimal.valueOf(Integer.parseInt(payment.getQuantity()) * Double.parseDouble(payment.getPayValue())).setScale(2, RoundingMode.FLOOR) +
                                                ".")
                        ),


                WaitUntil.the(LABEL_POP_UP2, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
        );
    }

    @When("{string} looks for and does not authorize the payment pending authorization from the details of the table my authorizations")
    public void looksForAndDoesNotAuthorizeThePaymentPendingAuthorizationFromTheDetailsOfTheTableMyAuthorizations(String actor, Payment payment) {
        this.payment = payment;
        OnStage.theActorInTheSpotlight().attemptsTo(
                AuthorizePaymentsMenu.goToAuthorization(payment, TYPE_OPERATION_PAYMENTS),
                SearchCorrectPaymentRegister.onTableMyAuthorizations(payment, TYPE_OPERATION_PAYMENTS),
                SelectRegister.click(),
                NoAuthorizePayment.fromTableDetailMyAuthorizations(payment)
        );

    }
}
