package co.com.iris.certification.stepdefinitions.usermanagement.roles;

import co.com.iris.certification.models.roles.InfoRole;
import co.com.iris.certification.tasks.usermanagement.roles.*;
import co.com.iris.certification.utils.GetComplementList;
import co.com.iris.certification.utils.SetData;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.support.Color;

import java.util.List;
import java.util.Map;

import static co.com.iris.certification.userinterfaces.usermanagement.roles.ListRolesUI.*;


public class CreateNewRoleStepDefinition {

    @DataTableType
    public InfoRole createRole(Map<String, String> data) {
        return new InfoRole(data.get("roleName"),
                data.get("roleDescription"),
                data.get("productsList"),
                data.get("complementsList"),
                data.get("permitsGroupsList"),
                data.get("emailUser"));
    }

    @When("{string} registers an new user role in banking")
    public void actorRegistersAnNewUserRoleInBanking(String actor, InfoRole infoRole) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectRolesAndLimitsMenu.forContinue(),
                SelectCreateNewRole.andEnterBasicInformationForRole(infoRole),
                SelectProducts.forNewRole(infoRole),
                SelectComplements.forNewRole(infoRole),
                SelectPermitsGroups.forNewRole(infoRole),
                SelectPermitsComplements.forCompleteItsConfiguration(infoRole),
                AssignAuthorizerRoles.forEachOperation(infoRole),
                CompleteNewRoleCreation.forAssignToTheUsersBanking(infoRole),
                VerifyMessage.ofNewRoleCreated(),
                FilterTheRolesList.forSearchTheNewRoleCreated(infoRole)

        );
    }

    @Then("{string} verifies that in the list roles appears the new role created")
    public void actorVerifiesThatInTheListRolesAppearsTheNewRoleCreated(String actor, InfoRole infoRole) {
        List<String> complementsList = SetData.convertListToLowerCase(LIST_TAGS_WITH_COMPLEMENTS_SELECTED_IN_ROLE.resolveAllFor(OnStage.theActorInTheSpotlight()).texts());
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_ROLE_NAME).text().isEqualTo(infoRole.getRoleName()),
                Ensure.that(LABEL_DESCRIPTION_ROLE).text().isEqualToIgnoringCase(infoRole.getRoleDescription()),
                Ensure.that(complementsList).containsOnlyElementsFrom(GetComplementList.fromFeature(infoRole.getComplementsList())),
                Ensure.that(LINK_DETAILS_ROLE).isEnabled(),
                Ensure.that(LINK_DETAILS_ROLE).text().isEqualToIgnoringCase("Ver detalle de rol"),
                Ensure.that(LABEL_NUMBER_USERS_WITH_THE_ROLE).text().asAnInteger().isEqualTo(0),
                Ensure.that(LABEL_NUMBER_PRODUCTS_INCLUDED_IN_THE_ROLE).text().asAnInteger().isEqualTo(SetData.convertStringToList(infoRole.getProductsList()).size()),
                Ensure.that(LABEL_STATUS_ROLE).text().isEqualTo("Activo"),
                Ensure.that(Color.fromString(CHECK_STATUS_ROLE.resolveFor(OnStage.theActorInTheSpotlight()).getCssValue("color")).asHex()).isEqualToIgnoringCase("#4DF367")
        );

    }
}
