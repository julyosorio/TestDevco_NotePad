package co.com.iris.certification.stepdefinitions.configuration;

import co.com.iris.certification.models.configuration.Tag;
import co.com.iris.certification.tasks.configuration.CompleteTagCreationForm;
import co.com.iris.certification.tasks.configuration.SelectTagOption;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.Map;

import static co.com.iris.certification.userinterfaces.configuration.CreateTagUI.LABEL_TAG_CREATED_SUCCESSFUL;

public class TagManagerStepDefinition {

    @DataTableType
    public Tag setTag(Map<String, String> mapTag) {
        return new Tag(mapTag.get("tagName"),
                mapTag.get("usersList"),
                mapTag.get("typeOperationList"),
                mapTag.get("category"));
    }

    @When("{string} completes the tag creation form")
    public void actorCompletesTheTagCreationForm(String actor, Tag infoTag) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectTagOption.fromConfigurationMenu(),
                CompleteTagCreationForm.forCreateANewTag(infoTag)
        );
    }

    @Then("{string} verifies that message the tag created successful was showed")
    public void actorVerifiesThatMessageTheTagCreatedSuccessfulWasShowed(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_TAG_CREATED_SUCCESSFUL).text().isEqualTo("Etiqueta creada exitosamente.").then(
                        Click.on(LABEL_TAG_CREATED_SUCCESSFUL)));
    }
}
