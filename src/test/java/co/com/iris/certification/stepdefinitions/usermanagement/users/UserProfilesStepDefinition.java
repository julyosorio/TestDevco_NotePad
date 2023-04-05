package co.com.iris.certification.stepdefinitions.usermanagement.users;

import co.com.iris.certification.models.users.InfoUser;
import co.com.iris.certification.tasks.usermanagement.users.*;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.Map;

import static co.com.iris.certification.userinterfaces.usermanagement.users.TableUserProfileUI.*;
import static co.com.iris.certification.userinterfaces.usermanagement.users.UserDetailUI.LABEL_FINAL_MESSAGE;
import static co.com.iris.certification.utils.Constants.USER_CREATION;
import static co.com.iris.certification.utils.Constants.USER_MODIFICATION;

public class UserProfilesStepDefinition {

    @DataTableType
    public InfoUser createUser(Map<String, String> data) {
        return new InfoUser(data.get("nameUser"),
                data.get("lastnameUser"),
                data.get("documentType"),
                data.get("documentNumber"),
                data.get("cellphone"),
                data.get("emailNewUser"),
                data.get("role"),
                data.get("updateRole"));
    }

    @When("{string} completes the form for send request access to the user")
    public void actorCompletesTheFormForSendRequestAccessToTheUser(String actor, InfoUser infoUser) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                UserAdministration.goToMenu(),
                SelectCreateUserMenu.forContinue(),
                EnterUserData.forNewUser(infoUser),
                VerifyMessageUserCreation.forNewUser(),
                ApplyUserFilters.forGetTheUserRecord(infoUser, USER_CREATION)
        );
    }

    @Then("{string} verifies the user record in users table")
    public void actorVerifiesTheUserRecordInUsersTable(String actor, InfoUser infoUser) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(COL_NAME_USER).text().isEqualTo(infoUser.getNameUser() + " " + infoUser.getLastnameUser()),
                Ensure.that(COL_ROLE_USER).text().isEqualToIgnoringCase(infoUser.getRole()),
                Ensure.that(COL_STATUS_USER).text().isEqualTo("Pendiente")
        );
    }

    @When("{string} Update or modify the data of an user")
    public void updateOrModifyTheDataOfAnUser(String actor, InfoUser infoUser) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                UserAdministration.goToMenu(),
                ApplyUserFilters.forGetTheUserRecord(infoUser, USER_MODIFICATION),
                SelectARegister.fromUserProfileTable(infoUser),
                EditUserData.newData(infoUser)
        );
    }

    @Then("{string} verifies the final message of the saved data")
    public void verifiesTheFinalMessageOfTheSavedData(String actor) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_FINAL_MESSAGE).text().contains("Cuenta guardada exitosamente.")
                        .then(Click.on(LABEL_FINAL_MESSAGE))
        );
    }
}
