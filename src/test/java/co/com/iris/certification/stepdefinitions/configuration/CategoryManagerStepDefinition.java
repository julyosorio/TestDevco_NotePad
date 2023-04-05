package co.com.iris.certification.stepdefinitions.configuration;

import co.com.iris.certification.models.configuration.Category;
import co.com.iris.certification.tasks.configuration.CompleteCategoryCreationForm;
import co.com.iris.certification.tasks.configuration.SelectTagOption;
import static co.com.iris.certification.userinterfaces.configuration.CreateCategoryUI.*;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import java.util.Map;

public class CategoryManagerStepDefinition {

    @DataTableType
    public Category setCategory(Map<String, String> mapCategory) {
        return new Category(mapCategory.get("categoryName"),
                mapCategory.get("tagsList"),
                mapCategory.get("numberCategoryColor"));
    }

    @When("{string} completes the category creation form")
    public void actorCompletesTheCategoryCreationForm(String actor, Category infoCategory) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectTagOption.fromConfigurationMenu(),
                CompleteCategoryCreationForm.forCreateANewCategory(infoCategory)
        );
    }

    @Then("{string} verifies that message the category  created successful was showed")
    public void actorVerifiesThatMessageTheCategoryCreatedSuccessfulWasShowed(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_CATEGORY_CREATED_SUCCESSFUL).text().isEqualTo("Etiqueta creada exitosamente.").then(
                        Click.on(LABEL_CATEGORY_CREATED_SUCCESSFUL)));
    }
}
