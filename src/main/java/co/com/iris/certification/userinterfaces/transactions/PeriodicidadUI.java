package co.com.iris.certification.userinterfaces.transactions;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PeriodicidadUI {
    public static final Target LIST_PERIODICITY = Target.the("dropdown list to select the periodicity").located(By.xpath("//div[@role='combobox']"));
    public static final Target OPTLST_PERIODICITY = Target.the("option to select the periodicity").located(By.xpath("//div[@role='option']/span"));
    public static final Target VALUE_PERIODICITY = Target.the("field that shows the default value of the periodicity").located(By.xpath("//div[2]/span[2]"));
    public static final Target CALENDAR_START_DATE = Target.the("input that open the calendar to choose start date transaction").located(By.xpath("(//input[@placeholder='Seleccionar fecha'])[1]"));
    public static final Target CALENDAR_FINAL_DATE = Target.the("input that open the calendar to choose final date transaction").located(By.xpath("(//input[@placeholder='Seleccionar fecha'])[2]"));
    public static final Target CALENDAR_EXECUTE_DATE = Target.the("input that open the calendar to choose execute date to complete a pay").located(By.xpath("(//input[@placeholder='Seleccionar fecha'])[1]"));

    private PeriodicidadUI(){

    }

}
