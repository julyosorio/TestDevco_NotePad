package co.com.iris.certification.userinterfaces.transactions.pendingtransaction;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class PendingTransactionVoucherUI {
    public static final Target LABEL_TITLE_WINDOW = Target.the("Title Window").located(By.xpath("//h5[contains(.,'Transferencia')]"));
    public static final Target LABEL_MESSAGE_TRANSACTION_STATUS = Target.the("messagge showing if the transaction is pending for execution")
            .located(By.xpath("//h6[@class='card-title ng-star-inserted']"));
    public static final Target LABEL_PENDING_TRX_ORIGIN_ACCOUNT = Target.the("origin account number")
            .located(By.xpath("//small[contains(.,'Producto')]//following-sibling::h6"));
    public static final Target LABEL_PENDING_TRX_DESTINATION_ACCOUNT = Target.the("destination account name")
            .located(By.xpath("//small[contains(.,'Número de cuenta')]//following-sibling::h6"));
    public static final Target LABEL_PENDING_TRX_DESTINATION_BANK = Target.the("destination bank")
            .located(By.xpath("//small[contains(.,'Banco destino')]//following-sibling::h6"));

    public static final Target LABEL_PENDING_VALUE = Target.the("").located(By.xpath("//small[contains(.,'Valor')]//following-sibling::h6"));
    public static final Target LABEL_PENDING_DESCRIPTION = Target.the("").located(By.xpath("(//small[contains(.,'Descripción')]//following-sibling::h6)[2]"));

    private PendingTransactionVoucherUI(){

    }

}
