package co.com.iris.certification.userinterfaces.transactionshistory.transactions;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransactionHistoryTableUI {

    public static final Target ROW_TRANSACTION_HISTORY_TABLE = Target.the("transaction history table row").located(By.xpath("//table/tbody/tr"));
    public static final Target COL_DATE_CREATE = Target.the("create date column").located(By.xpath("//table/tbody/tr/td[1]"));
    public static final Target COL_HOUR_CREATE = Target.the("create time column").located(By.xpath("//table/tbody/tr/td[1]/span"));
    public static final Target COL_DATE_EXECUTION = Target.the("transaction execution date column").located(By.xpath("//table/tbody/tr/td[2]"));
    public static final Target COL_HOUR_EXECUTION = Target.the("transaction execution time column").located(By.xpath("//table/tbody/tr/td[2]/span"));
    public static final Target COL_TRANSFERS = Target.the("column with the transfer type of the executed transaction").located(By.xpath("//table/tbody/tr/td[3]"));
    public static final Target COL_ORIGIN_PRODUCT = Target.the("column with the number of the origin account of the executed transaction").located(By.xpath("//table/tbody/tr/td[4]/span"));
    public static final Target COL_DEST_BANK = Target.the("column with the destination bank of the executed transaction").located(By.xpath("//table/tbody/tr/td[5]"));
    public static final Target COL_DEST_ACCOUNT = Target.the("column with the destination account of the executed transaction").located(By.xpath("//table/tbody/tr/td[6]/span"));
    public static final Target COL_TAG_TRANSACTION = Target.the("column with the tag of the executed transaction").located(By.xpath("//table/tbody/tr/td[7]"));
    public static final Target COL_AMOUNT_TRANSACTION = Target.the("column with the amount of the executed transaction").located(By.xpath("//table/tbody/tr/td[8]"));
    public static final Target COL_STATUS = Target.the("column with the status of the executed transaction").located(By.xpath("//table/tbody/tr/td[9]"));

    private TransactionHistoryTableUI() {
    }
}
