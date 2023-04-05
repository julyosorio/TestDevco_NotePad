package co.com.iris.certification.userinterfaces.transactionshistory.transactions;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransactionHistoryUI {
     public static final Target BTN_CREATION_DATE_ORDER_DSCD = Target.the("button to reorder the trx data by most recent to less recent")
            .located(By.xpath("//th[@class='asc d-md-table-cell d-none min-date-heading ordered']"));
    public static final Target BTN_GO_FILTER = Target.the("").located(By.xpath("//div[@class='filter-btn-content']"));
    public static final Target LIST_TRANSACTION_TYPES = Target.the("list with all transaction types")
            .located(By.xpath("//ng-select[@formcontrolname='selectedTypes']"));
    public static final Target LIST_ORIGIN_PRODUCT = Target.the("list with all the available accounts to filter")
            .located(By.xpath("//ng-select[@formcontrolname='selectedProduct']"));

    public static final Target LIST_DESTINATION_BANK = Target.the("list all the available banks with a scheduled transfer")
            .located(By.xpath("//ng-select[@formcontrolname='selectedBanks']"));
    public static final Target LIST_TAGS = Target.the("list with all available tags").located(By.xpath("//ng-select[@formcontrolname='selectedTag']"));
    public static final Target OPTLST_TAGS = Target.the("list with all available tags").located(By.xpath("//div[@role='option']"));

    public static final Target BTN_APPLY_FILTER = Target.the("button to apply all selected filters")
            .located(By.xpath("//button[@type='submit' and contains(text(), 'Aplicar filtros')]"));

    public static final Target BTN_PAGINATION = Target.the("button pagination")
            .located(By.xpath("//ul[@class='pagination']/li/a[contains(.,'1')]"));

    private TransactionHistoryUI() {
    }
}
