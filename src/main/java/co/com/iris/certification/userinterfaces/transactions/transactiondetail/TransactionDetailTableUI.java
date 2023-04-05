package co.com.iris.certification.userinterfaces.transactions.transactiondetail;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransactionDetailTableUI {

    public static final Target ROW_TRANSACTION_DETAIL_TABLE = Target.the("transaction detail table row").located(By.xpath("//table/tbody/tr"));
    public static final Target COL_DATE_EXECUTE = Target.the("transaction execution date column").located(By.xpath("//table/tbody/tr/td[1]"));
    public static final Target COL_HOUR_EXECUTE = Target.the("transaction execution time column").located(By.xpath("//table/tbody/tr/td[1]/span"));
    public static final Target COL_PRODUCT = Target.the("column with the number of the origin account of the executed transaction").located(By.xpath("//table/tbody/tr/td[2]/span"));
        public static final Target COL_OPERATION_TYPE = Target.the("column with the operation type  of the executed transaction").located(By.xpath("//table/tbody/tr/td[3]/span"));
        public static final Target COL_TRANSACTION_TYPE = Target.the("column with the transaction type  of the executed transaction").located(By.xpath("//table/tbody/tr/td[3]"));
    public static final Target COL_DESTINATION_BANK = Target.the("column with the destination bank of the executed transaction").located(By.xpath("//table/tbody/tr/td[4]"));
    public static final Target COL_DESTINATION_ACCOUNT = Target.the("column with the number of the destination account of the executed transaction").located(By.xpath("//table/tbody/tr/td[4]/span"));
    public static final Target COL_TAG = Target.the("column with the tag of the executed transaction").located(By.xpath("//table/tbody/tr/td[7]"));
    public static final Target COL_AMOUNT = Target.the("column with the amount of the executed transaction").located(By.xpath("//table/tbody/tr/td[8]"));

    private TransactionDetailTableUI(){}
}
