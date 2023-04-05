package co.com.iris.certification.userinterfaces.transactions.scheduledtransaction;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ScheduledTransactionsFilterUI {

    public static final Target BTN_FILTER = Target.the("button to go to the filters form")
            .located(By.xpath("//div[@class='filter-btn-content']"));
    public static final Target LABEL_CLEAN_FILTER = Target.the("button to clear the filter data")
            .located(By.xpath("//div[@class='clean-filters']//a"));
    public static final Target LIST_TRANSACTION_TYPES = Target.the("list with all transaction types")
            .located(By.xpath("//ng-select[@formcontrolname='selectedTypes']"));
    public static final Target LIST_PRODUCTS = Target.the("list with all the available accounts to filter")
            .located(By.xpath("//ng-select[@formcontrolname='selectedProduct']"));
    public static final Target LIST_DESTINATION_BANK = Target.the("list all the available banks with a scheduled transfer")
            .located(By.xpath("//ng-select[@formcontrolname='selectedBanks']"));
    public static final Target LIST_PERIODICITY = Target.the("list with all regularities available")
            .located(By.xpath("//ng-select[@formcontrolname='selectedPeriodicity']"));
    public static final Target CALENDAR_EXECUTION_START_DATE = Target.the("calendar used to filter by an initial date")
            .located(By.xpath("//nz-range-picker/div/input[@placeholder='Fecha inicial']"));
    public static final Target CALENDAR_EXECUTION_FINISH_DATE = Target.the("calendar used to filter by an ending date")
            .located(By.xpath("//nz-range-picker/div/input[@placeholder='Fecha final']"));
    public static final Target LIST_TAGS = Target.the("list with all available tags")
            .located(By.xpath("//ng-select[@formcontrolname='selectedTag']"));
    public static final Target BTN_APPLY_FILTER = Target.the("button to apply all selected filters")
            .located(By.xpath("//button[@type='submit' and contains(text(), 'Aplicar filtros')]"));
    public static final Target BTN_CLOSE_FILTER = Target.the("button to close filter form")
            .located(By.xpath("//a[@class='close-drawer']"));

    private ScheduledTransactionsFilterUI() {
    }
}
