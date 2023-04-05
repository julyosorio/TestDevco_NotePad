package co.com.iris.certification.userinterfaces.transactionshistory.payments;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentsAndBatchesHistoricTableUI {
    public static final Target FIELD_CREATION_DATE = Target.the("column with the creation date of pay transaction")
            .located(By.xpath("//tr/th[contains(.,'creación')]"));
    public static final Target COL_CREATION_DATE = Target.the("column with the value of creation date for the pay record")
            .located(By.xpath("//tr[1]/td[1]"));

    public static final Target COL_EXECUTION_DATE = Target.the("column with the date and time execution for the pay transaction of record")
            .located(By.xpath("//tr[1]/td[2]"));
    public static final Target COL_PAY_ID = Target.the("column with the pay ID for the pay record")
            .located(By.xpath("//tr[1]/td[3]"));
    public static final Target COL_PAY_TYPE = Target.the("column with the pay type selected for the pay record")
            .located(By.xpath("//tr[1]/td[4]"));
    public static final Target COL_TOTAL_PAYMENTS = Target.the("column that show the quantity total payments included in the pay record")
            .located(By.xpath("//tr[1]/td[5]"));
    public static final Target COL_PAYMENTS_IN_PROCCESS = Target.the("column with the quantity payments that are in proccess from total payments included in the pay record")
            .located(By.xpath("//tr[1]/td[6]"));
    public static final Target COL_PAYMENTS_WITH_ERROR = Target.the("column that show the quantity payments that were proccessed with error from total payments included in the pay record")
            .located(By.xpath("//tr[1]/td[7]"));

    public static final Target COL_TAG = Target.the("column with the selected tag for the pay record")
            .located(By.xpath("//tr[1]/td[8]"));
    public static final Target COL_VALUE_PAY = Target.the("column with the total value for the pay record")
            .located(By.xpath("//tr[1]/td[9]"));
    public static final Target COL_STATUS_PAY = Target.the("column with the status for the pay record")
            .located(By.xpath("//tr[1]/td[10]"));

    private PaymentsAndBatchesHistoricTableUI(){
    }
}
