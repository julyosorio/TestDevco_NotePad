
package co.com.iris.certification.stepdefinitions.login;

import co.com.iris.certification.interactions.RefreshWebPage;
import co.com.iris.certification.models.login.LoginUsers;
import co.com.iris.certification.tasks.login.Login;
import co.com.iris.certification.tasks.login.LoginExpiratedCredentials;
import co.com.iris.certification.tasks.login.RenewPass;
import co.com.iris.certification.tasks.validateotp.GetOtp;
import co.com.iris.certification.tasks.validateotp.SendCorrectOtp;
import co.com.iris.certification.tasks.validateotp.SendWrongOtp;
import co.com.iris.certification.userinterfaces.login.LoginUI;
import co.com.iris.certification.userinterfaces.passwordrecovery.ChangePasswordUI;
import co.com.iris.certification.userinterfaces.validateotp.ValidateOtpUI;
import co.com.iris.certification.utils.SetData;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.Map;

import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.LABEL_WELCOME;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static co.com.iris.certification.utils.Constants.WEB_EMPRESAS_QA_PRINCIPAL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class LoginStepDefinition {

    @Before
    public void actorConfig() {
        OnStage.setTheStage(new OnlineCast());
    }

    @DataTableType
    public LoginUsers loginUsers(Map<String, String> dataUsers) {
        return new LoginUsers(
                dataUsers.get("nit"),
                dataUsers.get("username"),
                dataUsers.get("password"),
                dataUsers.get("email"),
                dataUsers.get("otp"),
                dataUsers.get("expiratedPass"),
                SetData.setPassword(dataUsers.get("newPass"))
        );
    }

    @When("The {string} authenticates to the Iris website using the following credentials:")
    public void theIrisUserAuthenticatesToTheIrisWebsiteUsingTheFollowingCredentials(String user, LoginUsers listUsers) {
        OnStage.theActorCalled(user).attemptsTo(
                Open.url(WEB_EMPRESAS_QA_PRINCIPAL),
                Login.withCredencials(listUsers)
                //,GetOtp.byEmail(listUsers.getEmail()),
                //SendCorrectOtp.with()
        );
    }

    @Then("{string} verifies successful authenticate to the Iris website")
    @Then("{string} verifies a successful login with the new password")
    public void heVerifiesSuccessfulAuthenticateToTheIrisWebsite(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_WELCOME.waitingForNoMoreThan(Duration.ofSeconds(WAITING_TIME))).isDisplayed()
        );

    }

    @When("The {string} authenticates with wrong OTP to the Iris website with credentials:")
    public void theIrisUserAuthenticatesWithWrongOTPToTheIrisWebsiteWithCredentials(String user, LoginUsers listUsers) {
        OnStage.theActorCalled(user).attemptsTo(
                Open.url(WEB_EMPRESAS_QA_PRINCIPAL),
                Login.withCredencials(listUsers),
                SendWrongOtp.sendWrongOTP(listUsers)
        );
    }

    @Then("{string} shouldn't access Iris web site")
    public void IrisUserShouldnTAccessIrisWebSite(String user) {
        OnStage.theActorCalled(user).attemptsTo(
                WaitUntil.the(ValidateOtpUI.LABEL_MSG_ERROR_OTP, WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
                Ensure.that(ValidateOtpUI.LABEL_MSG_ERROR_OTP).textContent().contains("Error al validar"),
                Click.on(ValidateOtpUI.LABEL_CANCEL)
        );
    }

    @When("The {string} authenticates with wrong credentials to the Iris website as follows:")
    public void theIrisUserAuthenticatesWithWrongCredentialsToTheIrisWebsiteAsFollows(String user, LoginUsers listUsers) {
        OnStage.theActorCalled(user).attemptsTo(
                Open.url(WEB_EMPRESAS_QA_PRINCIPAL),
                RefreshWebPage.refresh(),
                Login.withCredencials(listUsers)
        );

    }

    @Then("{string} shouldn't access Iris web site, due to credential error")
    public void IrisUserShouldnTAccessIrisWebSiteDueToCredentialError(String user) {
        OnStage.theActorCalled(user).attemptsTo(
                WaitUntil.the(ValidateOtpUI.LABEL_MSG_ERROR_CREDENTIALS, isVisible()).forNoMoreThan(Duration.ofSeconds(20)),
                Ensure.that(ValidateOtpUI.LABEL_MSG_ERROR_CREDENTIALS).textContent().contains("incorrecta")
        );
    }

    @When("{string} enter expirated credentials in login page")
    public void actorEnterExpiratedCredentialsInLoginPage(String user, LoginUsers data) {
        OnStage.theActorCalled(user).attemptsTo(
                Open.url(WEB_EMPRESAS_QA_PRINCIPAL),
                LoginExpiratedCredentials.with(data),
                RenewPass.with(data),
                GetOtp.byEmail(data.getEmail()),
                SendCorrectOtp.with()
        );
    }

    @Then("{string} verifies that system allows to change password")
    public void actorVerifiesThatSystemAllowsToChangePassword(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LoginUI.LABEL_CONFIRM_PASSWORD_RENEWED, WebElementStateMatchers.isVisible()),
                Ensure.that(LoginUI.LABEL_CONFIRM_PASSWORD_RENEWED).textContent().contains("Contraseña actualizada")
        );
    }

    @When("{string} complete the login with the renewed password")
    public void actorCompleteTheLoginWithTheRenewedPassword(String user, LoginUsers data) {
        data.setPassword(OnStage.theActorCalled(user).recall("newPass"));
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withCredencials(data),
                GetOtp.byEmail(data.getEmail()),
                SendCorrectOtp.with()
        );
    }

    @When("{string} tries to login with expirated password")
    public void actorTriesToLoginWithExpiratedPassword(String user, LoginUsers data) {
        OnStage.theActorCalled(user).attemptsTo(
                Open.url(WEB_EMPRESAS_QA_PRINCIPAL),
                LoginExpiratedCredentials.with(data)
        );
    }

    @Then("{string} verifies that systems requires to renew password")
    public void actorVerifiesThatSystemsRequiresToRenewPassword(String user) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ChangePasswordUI.LABEL_FIELD_PASSWORD_NEW, WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
                Ensure.that(ChangePasswordUI.LABEL_FIELD_PASSWORD_NEW).textContent().containsIgnoringCase("Ingresar nueva contraseña"),
                WaitUntil.the(ChangePasswordUI.LABEL_FIELD_CONFIRM_PASSWORD, WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
                Ensure.that(ChangePasswordUI.LABEL_FIELD_CONFIRM_PASSWORD).textContent().containsIgnoringCase("Repetir nueva contraseña")
        );
    }

}
