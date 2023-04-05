package co.com.iris.certification.stepdefinitions.payments;

import co.com.iris.certification.models.transactions.Payment;
import co.com.iris.certification.tasks.payments.paymentssaved.LookForTheCorrectRecord;
import co.com.iris.certification.tasks.payments.paymentssaved.OrderSavedPaymentsList;
import co.com.iris.certification.tasks.payments.paymentssaved.SelectPaymentsSavedOption;
import co.com.iris.certification.tasks.payments.paymentssaved.editpayments.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.iris.certification.userinterfaces.payments.SuccessfulPaySavedUI.LABEL_WITH_CONTENT_OF_MESSAGE_ABOUT_PAY_SAVED_SUCCESSFULL;
import static co.com.iris.certification.userinterfaces.payments.SuccessfulPaySavedUI.LABEL_WITH_TITLE_OF_MESSAGE_ABOUT_PAY_SAVED_SUCCESSFULL;
import static co.com.iris.certification.utils.Constants.*;

public class EditPaymentStepDefinition {

    @When("{string} deletes the payments quantity requested from payments list")
    public void actorDeletesSomePaymentsFromPaymentsList(String actor, Payment infoPay) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectPaymentsSavedOption.fromMainMenu(),
                OrderSavedPaymentsList.forFindTheCorrectRecord(),
                LookForTheCorrectRecord.inSavedPaymentsTable(infoPay),
                SelectEditOption.fromPaymentThatRequestUpdate(),
                DeletePaymentsFromPayList.accordingToQuantityIndicatedForDelete(infoPay),
                CompletePaymentEdition.withTheChangesDone(SCENARIO_DELETE_PAYMENTS_FROM_LIST)
        );
    }

    @Then("{string} verifies that message pay record updated was showed")
    public void actorVerifiesThatMessagePayRecordUpdatedWasShowed(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_WITH_TITLE_OF_MESSAGE_ABOUT_PAY_SAVED_SUCCESSFULL).text().isEqualTo("¡Pago guardado!"),
                Ensure.that(LABEL_WITH_CONTENT_OF_MESSAGE_ABOUT_PAY_SAVED_SUCCESSFULL).text().isEqualTo("Puedes acceder y completar tu pago mas tarde.")
        );
    }

    @When("{string} modifies the origin account selected and saves changes")
    public void actorModifiesTheOriginAccountSelectedAndSavesChanges(String actor, Payment infoPay){
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectPaymentsSavedOption.fromMainMenu(),
                OrderSavedPaymentsList.forFindTheCorrectRecord(),
                LookForTheCorrectRecord.inSavedPaymentsTable(infoPay),
                SelectEditOption.fromPaymentThatRequestUpdate(),
                GoToOriginProductPage.forUpdateTheAccount(),
                EditOriginAccount.withTheNewNumberAccountSend(infoPay),
                CompletePaymentEdition.withTheChangesDone(SCENARIO_UPDATE_ORIGIN_ACCOUNT)
        );
    }
    @When("{string} modifies the execute date selected and saves changes")
    public void actorModifiesTheExecuteDateSelectedAndSavesChanges(String actor, Payment infoPay){
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectPaymentsSavedOption.fromMainMenu(),
                OrderSavedPaymentsList.forFindTheCorrectRecord(),
                LookForTheCorrectRecord.inSavedPaymentsTable(infoPay),
                SelectEditOption.fromPaymentThatRequestUpdate(),
                GoToOriginProductPage.forUpdateTheAccount(),
                EditExecuteDate.withTheNewDateSend(infoPay),
                CompletePaymentEdition.withTheChangesDone(SCENARIO_UPDATE_EXECUTE_DATE)
        );
    }

    @When("{string} addes payments to the pay list and saves changes")
    public void actorAddesPaymentsToThePayListAndSavesChanges(String actor, Payment infoPay){
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectPaymentsSavedOption.fromMainMenu(),
                OrderSavedPaymentsList.forFindTheCorrectRecord(),
                LookForTheCorrectRecord.inSavedPaymentsTable(infoPay),
                SelectEditOption.fromPaymentThatRequestUpdate(),
                AddNewPaymentsToTheList.accordingToPaymentsQuantityIndicatedForAdd(infoPay),
                CompletePaymentEdition.withTheChangesDone(SCENARIO_ADD_PAYMENTS_FROM_LIST)
        );
    }
}
