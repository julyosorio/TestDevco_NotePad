package co.com.iris.certification.userinterfaces.transactions;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;


public class TransactionSummaryUI {

    public static final Target LABEL_ORIGIN_ACCOUNT_OWNER = Target.the("name of the origin account holder")
            .located(xpath("(//small[contains(text(),'Titular')]//following-sibling::h6)[1]"));
    public static final Target LABEL_TYPE_ORIGIN_ACCOUNT = Target.the("account type of origin account")
            .located(xpath("(//small[contains(text(),' Tipo de cuenta')]//following-sibling::h6)[1]"));
    public static final Target LABEL_ORIGIN_ACCOUNT_NUMBER = Target.the("last four digits of the origin account number")
            .located(xpath("//small[contains(text(),'Producto')]//following-sibling::h6"));
    public static final Target LABEL_DESTINATION_BANK = Target.the("name of the destination bank")
            .located(xpath("//small[contains(text(),'Banco')]//following-sibling::h6"));
    public static final Target LABEL_DESTINATION_ACCOUNT_OWNER = Target.the("name of the destination account holder")
            .located(xpath("(//small[contains(text(),'Titular')]//following-sibling::h6)[2]"));
    public static final Target LABEL_TYPE_DOC_OWNER_ACCOUNT_DESTINATION = Target.the("document type of owner account destination")
            .located(By.xpath("//div[@class='col-12 col-sm-4 form-group px-0 ng-star-inserted']/small"));
    public static final Target LABEL_NUM_DOC_ACCOUNT_DESTINATION = Target.the("number document of owner destination account")
            .located(xpath("(//div/h6[contains(.,'Cuenta destino')]/following::div/h6)[3]"));
    public static final Target LABEL_TYPE_DESTINATION_ACCOUNT = Target.the("account type of destination account")
            .located(xpath("(//small[contains(text(),'Tipo de cuenta')]//following-sibling::h6)[2]"));
    public static final Target LABEL_DESTINATION_OWN_ACCOUNTS = Target.the("number of the destination own account")
            .located(xpath("(//small[contains(text(),'Producto')]//following-sibling::h6)[2]"));
    public static final Target LABEL_DESTINATION_ACCOUNT_NUMBER = Target.the("number of the destination account")
            .located(xpath("//small[contains(text(),'Cuenta')]//following-sibling::h6"));
    public static final Target LABEL_EXECUTION_DATE = Target.the("execution date")
            .located(xpath("//small[contains(text(),' ejecución')]//following-sibling::h6"));
    public static final Target LABEL_FINAL_DATE = Target.the("final date to execution of shcedule transactions")
            .located(xpath("//small[contains(text(),' Fecha final')]//following-sibling::h6"));
    public static final Target LABEL_PERIODICITY = Target.the("periodicity for execution of schedule transactions")
            .located(xpath("//small[contains(text(),' Periodicidad')]//following-sibling::h6"));
    public static final Target LABEL_TAG = Target.the("name of the tag assigned to the transaction")
            .located(xpath("//div[contains(@class,'tag')]/span"));
    public static final Target LABEL_DESCRIPTION_TAG = Target.the("description of the tag assigned for the transaction")
            .located(xpath("//small[contains(text(),'Descripción')]//following-sibling::h6"));
    public static final Target LABEL_TRX_AMMOUNT = Target.the("value to transfer in summary page")
            .located(xpath("//h3[starts-with(.,'$')]"));
    public static final Target LABEL_COST_TRANSACTION = Target.the("cost of the transaction")
            .located(xpath("//small[contains(.,'Costo')]/following-sibling::h6"));
    public static final Target LABEL_MESSAGE_FOR_SCHEDULE_TRANSACTIONS = Target.the("message that shows to scheduled transactions information as periodicity, start date, and final date")
            .located(xpath("//p[contains(.,'transferencia se repetirá')]"));
    public static final Target LABEL_MESSAGE_SUBSCRIPTION_ACCOUNT = Target.the("message that indicate when complete the subscription account is made")
            .located(By.xpath("//p[contains(.,'Guarda esta cuenta')]"));
    public static final Target BTN_EXECUTE_TRANSACTION = Target.the("button to complete and execute the transaction")
            .located(xpath("//button[contains(text(),' Ejecutar ')]"));
    public static final Target LABEL_SUCCESSFUL_TRANSACTION = Target.the("successful transaction message")
            .located(cssSelector("h5.transfer-success"));
    public static final Target LABEL_SUCCESSFUL_TRANSACTION_AMOUNT = Target.the("successfully transfered value")
            .located(xpath("//b[starts-with(.,'$')]"));
    public static final Target BTN_VOUCHER = Target.the("button to display all the voucher available options")
            .located(xpath("//button[@class='dropdown-toggle btn btn-outline-primary removecaret ng-star-inserted']"));
    public static final Target OPTLST_CHECK_VOUCHER = Target.the("option to view the transaction voucher")
            .located(xpath("//button[@class='dropdown-item' and contains(.,'Ver comprobante')]"));

    public static final Target OPTLST_DOWNLOAD_VOUCHER = Target.the("option to download the transaction voucher")
            .located(xpath("//button[@class='dropdown-item' and contains(.,'Descargar PDF')]"));
    public static final Target LABEL_MESSAGE_PENDING_APPROVAL = Target.the("Message with the transaction value and transaction status information")
            .located(By.xpath("//div[@class='row d-flex justify-content-center text-center']"));

    public static final Target BTN_VIEW_PENDING_AUTHORIZATIONS = Target.the("button to go to the table view pending authorizations from the final trx message ")
            .located(By.xpath("//button[@type='button'][contains(.,' Ver Autorizaciones Pendientes')]"));

    private TransactionSummaryUI() {

    }
}
