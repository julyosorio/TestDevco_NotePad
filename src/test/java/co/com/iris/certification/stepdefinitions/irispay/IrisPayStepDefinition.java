package co.com.iris.certification.stepdefinitions.irispay;

import co.com.iris.certification.models.irispay.BillingData;
import co.com.iris.certification.tasks.irispay.BillingLink;
import co.com.iris.certification.tasks.irispay.BillingLinkFromInvoice;
import co.com.iris.certification.tasks.irispay.IrisPay;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.Map;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.MENU_IRISPAY;
import static co.com.iris.certification.userinterfaces.irispay.PopUpNewBillingLinkUI.*;

public class IrisPayStepDefinition {

    private BillingData billingData;

    @DataTableType
    public BillingData billingData(Map<String, String> billingData) {
        return new BillingData(
                billingData.get("customerName"),
                billingData.get("documentType"),
                billingData.get("documentNumber"),
                billingData.get("customerEmail"),
                billingData.get("billingConcept"),
                billingData.get("reference1"),
                billingData.get("withOrWithoutReference1"),
                billingData.get("referenceNumber1"),
                billingData.get("addReference"),
                billingData.get("reference2"),
                billingData.get("withOrWithoutReference2"),
                billingData.get("referenceNumber2"),
                billingData.get("tag"),
                billingData.get("billingDetail"),
                billingData.get("totalValue"),
                billingData.get("withOrWithoutIVA"),
                billingData.get("expirationDate"),
                billingData.get("fileName")
        );
    }

    @When("{string} creates a new billing link in the irispay module")
    public void createsANewBillingLinkInTheIrispayModule(String actor, BillingData billingData) {
        this.billingData = billingData;
        OnStage.theActorInTheSpotlight().attemptsTo(
                IrisPay.goToMenu(),
                BillingLink.createNew(billingData)
        );
    }

    @Then("{string} validates the final message of the link creation, successful")
    public void validatesTheFinalMessageOfTheLinkCreationSuccessful(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_POP_UP_TITLE).isEnabled().then(Click.on(BTN_CLOSE_POP_UP))
        );

    }

    @When("{string} creates a new billing link from an invoice in the irispay module")
    public void createsANewBillingLinkFromAnInvoiceInTheIrispayModule(String actor, BillingData billingData) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IrisPay.goToMenu(),
                BillingLinkFromInvoice.createNew(billingData)
        );
    }
}
