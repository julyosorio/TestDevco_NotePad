package co.com.iris.certification.stepdefinitions.passwordrecovery;

import co.com.iris.certification.models.login.LoginUsers;
import co.com.iris.certification.models.passwordrecovery.PasswordRecovery;
import co.com.iris.certification.questions.passwordrecovery.ValidateErrorPassRecovery;
import co.com.iris.certification.tasks.login.Login;
import co.com.iris.certification.tasks.passwordrecovery.ConfirmPasswordChange;
import co.com.iris.certification.tasks.passwordrecovery.CreateNewPassword;
import co.com.iris.certification.tasks.passwordrecovery.RequestPasswordChange;
import co.com.iris.certification.tasks.passwordrecovery.RequestPasswordChangeFailed;
import co.com.iris.certification.tasks.validateotp.GetOtp;
import co.com.iris.certification.tasks.validateotp.LoginYopmail;
import co.com.iris.certification.tasks.validateotp.SendCorrectOtp;
import co.com.iris.certification.userinterfaces.login.LoginUI;
import co.com.iris.certification.utils.SetData;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matchers;

import java.time.Duration;
import java.util.Map;

import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static co.com.iris.certification.utils.Constants.WEB_EMPRESAS_QA_PRINCIPAL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class PassRecoveryStepDefinition {

    @DataTableType
    public PasswordRecovery changePasswordEntry(Map<String, String> data){
        return new PasswordRecovery(
                data.get("nit"),
                data.get("documentUser"),
                data.get("username"),
                data.get("email"),
                SetData.setPassword(data.get("password")),
                data.get("scenario"));
    }

    String randomPassword;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} goes to the login page")
    public void actorGoesToTheLoginPage(String user){
        OnStage.theActorCalled(user).wasAbleTo(Open.url(WEB_EMPRESAS_QA_PRINCIPAL));
    }

    @When("{string} performs successful password change")
    public void actorPerformsSuccessfulPasswordChange(String user, PasswordRecovery data){
        randomPassword = data.getPassword();
        OnStage.theActorInTheSpotlight().attemptsTo(RequestPasswordChange.of(data),
                LoginYopmail.withEmail(data.getEmail()),
                ConfirmPasswordChange.from(),
                CreateNewPassword.withTheData(data),
                GetOtp.byEmail(data.getEmail()),
                SendCorrectOtp.with()
                );
    }

    @Then("{string} verifies the successfull password change message")
    public void actorVerifiesTheSuccessfullPasswordChangeMessage(String user){
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LoginUI.LABEL_CONFIRM_PASSWORD_CHANGE, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                Ensure.that(LoginUI.LABEL_CONFIRM_PASSWORD_CHANGE).textContent().contains("Contraseña actualizada"));
    }

    @When("{string} complete the login with the new credentials")
    public void actorCompleteTheLoginWithTheNewCredentials(String user, LoginUsers data){
        data.setPassword(randomPassword);
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withCredencials(data),
                GetOtp.byEmail(data.getEmail()),
                SendCorrectOtp.with()
        );
    }

    @When("{string} tries to recover password with fail data")
    public void actorTriesTorRecoverPasswordWithFailData(String user, PasswordRecovery data){
        OnStage.theActorInTheSpotlight().attemptsTo(
                RequestPasswordChangeFailed.with(data)
        );

    }

    @Then("{string} verifies the error message showed {string}")
    public void verifiesTheErrorMessageShowed(String user, String actualScenario){
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateErrorPassRecovery.withTheScenario(actualScenario), Matchers.is(true)));
    }


}
