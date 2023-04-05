package co.com.iris.certification.tasks.irispay;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class FileUpload implements Task {

    private String fileName;
    private Target BTN_LOAD;

    public FileUpload(String fileName, Target BTN_LOAD) {
        this.fileName = fileName;
        this.BTN_LOAD = BTN_LOAD;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
         actor.attemptsTo(
                 SendKeys.of(System.getProperty("user.dir") + "/src/test/resources/files/" + fileName).into(BTN_LOAD),
                 WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
         );
    }

    public static FileUpload newFile(String fileName, Target BTN_LOAD) {
        return Tasks.instrumented(FileUpload.class, fileName, BTN_LOAD);
    }
}
