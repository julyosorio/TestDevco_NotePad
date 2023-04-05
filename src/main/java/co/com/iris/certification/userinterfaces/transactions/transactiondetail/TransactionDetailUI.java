package co.com.iris.certification.userinterfaces.transactions.transactiondetail;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransactionDetailUI {

    public static final Target BTN_OPEN_SIDEWINDOW_FILTER = Target.the("button to open the filter window")
            .located(By.className("mr-2"));
    public static final Target LABEL_CLEAN_FILTER = Target.the("button to clear the filter data")
            .located(By.xpath("//div[@class='clean-filters']//a"));
    public static final Target LIST_PRODUCTS = Target.the("list with all the available accounts to filter")
            .located(By.name("product"));
    public static final Target LIST_OPERATION_TYPE = Target.the("list with all kinds of operations")
            .located(By.name("operationType"));
    public static final Target LIST_USERS = Target.the("list with all users avalable")
            .located(By.name("user"));
    public static final Target LIST_TAGS = Target.the("list with all available tags").located(By.xpath("//ng-select[@formcontrolname='tagId']"));
    public static final Target OPTLST_TAGS = Target.the("list with all available tags").located(By.xpath("//div[@role='option']"));
    public static final Target CALENDAR_EXECUTION_START_DATE = Target.the("calendar used to filter by an initial date")
            .located(By.xpath("//nz-range-picker/div/input[@placeholder='Fecha inicial']"));
    public static final Target CALENDAR_EXECUTION_FINISH_DATE = Target.the("calendar used to filter by an ending date")
            .located(By.xpath("//nz-range-picker/div/input[@placeholder='Fecha final']"));
    public static final Target BUTTON_APPLY_FILTER = Target.the("button to apply all selected filters")
            .located(By.xpath("//button[@type='submit' and contains(text(), 'Aplicar filtros')]"));
    public static final Target OPTLST_FILTERFILL = Target.the("list with all the available 'option span'")
            .located(By.xpath("//div[@role='option']/span"));
    public static final Target BTN_PAGINATION = Target.the("button pagination").located(By.xpath("//ul[@class='pagination']/li/a[contains(.,'1')]"));

    private TransactionDetailUI() {
    }

}
