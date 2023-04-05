package co.com.iris.certification.userinterfaces.transactions;

import co.com.iris.certification.utils.SetData;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static co.com.iris.certification.utils.Constants.SELECT_VALUE_CALENDAR;


public class CalendarUI {
    public static final Target BTN_YEAR_DATE = Target.the("button to open years list").located(By.xpath("//button[contains(text()," + SetData.getCurrentYear() + ")]"));
    public static final Target BTN_MONTH_DATE = Target.the("button to open months list").located(By.xpath("//button[@title='Elegir un mes']"));
    public static final Target CALENDAR_YEAR_DATE = Target.the("input to view the avaliables years").located(By.xpath(SELECT_VALUE_CALENDAR));
    public static final Target CALENDAR_MONTH_DATE = Target.the("input to view the avaliables months").located(By.xpath(SELECT_VALUE_CALENDAR));
    public static final Target CALENDAR_DAY_DATE = Target.the("input to view the avaliables days").located(By.xpath(SELECT_VALUE_CALENDAR));
    public static String VALUE_XPATH_START_DATE = "//td[contains(@title,'startDate')]";
    public static String VALUE_XPATH_DATE = "//td[contains(@title,'date')]";
    public static String VALUE_XPATH_FINAL_DATE = "//td[contains(@title,'finalDate')]";
    public static String VALUE_XPATH_EXECUTE_DATE = "//td[contains(@title,'executeDate')]";
    public static Target VALUE_START_DATE = null;
    public static Target VALUE_DATE = null;
    public static Target VALUE_FINAL_DATE = null;
    public static Target VALUE_EXECUTE_DATE = null;
    private CalendarUI() {

    }
}
