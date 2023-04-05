package co.com.iris.certification.userinterfaces.transactions.scheduledtransaction;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ScheduledTransactionTableUI {

    public static final Target ROW_REGISTER = Target.the("scheduled transactions table row")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover']/tbody/tr")) ;
    public static final Target COL_TRANSACTIONTYPE = Target.the("transaction type column, from the scheduled transactions table")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover']/tbody/tr/td[2]"));
    public static final Target COL_ELIMINATION_BOX = Target.the("column with the checkbox to select the transaction to be deleted")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover']/tbody/tr/td[1]"));
    public static final Target COL_ORIGINACCOUNT = Target.the("origin account column, from the scheduled transactions table")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover']/tbody/tr/td[3]/span"));
    public static final Target COL_DESTINATIONBANK = Target.the("destination bank column, from the scheduled transactions table")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover']/tbody/tr/td[4]"));
    public static final Target COL_DESTINATIONACCOUNT = Target.the("destination account column, from the scheduled transactions table")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover']/tbody/tr/td[5]"));
    public static final Target COL_INITIALDATE = Target.the("initial date column, from the scheduled transactions table")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover']/tbody/tr/td[6]"));
    public static final Target COL_SCHEDULEDDATE = Target.the("scheduled date column, from the scheduled transactions table")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover']/tbody/tr/td[7]"));
    public static final Target COL_TAG = Target.the("tag column, from the scheduled transactions table")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover']/tbody/tr/td[8]")) ;
    public static final Target COL_AMOUNT = Target.the("amount column, from the scheduled transactions table")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover']/tbody/tr/td[9]")) ;
    public static final Target COL_PERIODICITY = Target.the("periodicity column, from the scheduled transactions table")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover']/tbody/tr/td[10]"));
    public static final Target COL_PERIODICITYDATE = Target.the("periodicity column, from the scheduled transactions table")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover']/tbody/tr/td[10]/span"));

    public static final Target BTN_DELETE_SCHEDULED_TRX = Target.the("button to delete a scheduled transaction from the scheduled transaction table ")
            .located(By.xpath("//button[@class='btn btn-primary'][contains(text(),'Eliminar programación')]"));

    private ScheduledTransactionTableUI(){}


}
