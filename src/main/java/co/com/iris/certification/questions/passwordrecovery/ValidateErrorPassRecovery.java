package co.com.iris.certification.questions.passwordrecovery;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static co.com.iris.certification.userinterfaces.passwordrecovery.PasswordRecoveryUI.LABEL_MESSAGE_ERROR;
import static co.com.iris.certification.userinterfaces.passwordrecovery.PasswordRecoveryUI.LABEL_MESSAGE_ERROR_FIELD;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidateErrorPassRecovery implements Question<Boolean> {

    private String scenario;

    public ValidateErrorPassRecovery(String scenario) {
        this.scenario = scenario;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElementFacade> listErrors = LABEL_MESSAGE_ERROR_FIELD.resolveAllFor(actor);
        switch (this.scenario) {
            case "non-existant user":
            case "non-existant nit":
            case "email and user don't match":
            case "user and nit don't match":
            case "document and user don't match":
                actor.attemptsTo(
                        WaitUntil.the(LABEL_MESSAGE_ERROR, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                        Ensure.that(LABEL_MESSAGE_ERROR).textContent().contains("Error al resetear contraseña"));
                return LABEL_MESSAGE_ERROR.resolveFor(actor).getText().contains("Error al resetear contraseña");
            case "email without @":
            case "email without domain":
            case "email with incomplete domain":
            case "without email":
                return verifyErrorMessage(listErrors, "Correo electrónico es requerido");
            case "without nit":
                return verifyErrorMessage(listErrors, "Número de NIT es requerido");
            case "without document":
                return verifyErrorMessage(listErrors, "Número del documento es requerido");
            case "without user":
                return verifyErrorMessage(listErrors, "Nombre de Usuario es requerido");
            case "empty fields":
                return verifyListErrorMessage(listErrors);
            default:
                break;
        }
        return false;
    }

    public static boolean verifyErrorMessage(List<WebElementFacade> list, String message) {
        boolean response = false;
        for (WebElementFacade element : list) {
            if (element.getTextContent().contains(message) && element.isVisible()) {
                response = true;
                break;
            }
        }
        return response;
    }

    public static boolean verifyListErrorMessage(List<WebElementFacade> list) {
        List<Boolean> listMessages = new ArrayList<>();
        for (WebElementFacade element : list) {
            if (element.getTextContent().contains("Correo electrónico es requerido") && element.isVisible()) {
                listMessages.add(true);
            } else if (element.getTextContent().contains("Número de NIT es requerido") && element.isVisible()) {
                listMessages.add(true);
            } else if (element.getTextContent().contains("Número del documento es requerido") && element.isVisible()) {
                listMessages.add(true);
            } else if (element.getTextContent().contains("Nombre de Usuario es requerido") && element.isVisible()) {
                listMessages.add(true);
            }
        }
        return !listMessages.contains(false);
    }

    public static ValidateErrorPassRecovery withTheScenario(String scenario) {
        return new ValidateErrorPassRecovery(scenario);
    }
}
