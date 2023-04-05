package co.com.iris.certification.userinterfaces.transactions.scheduledtransaction;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PeriodicTransactionDetailUI {
    public static final Target LABEL_TITLE_MESSAGE = Target.the("voucher Initial Message").located(By.xpath("//h6[@class='card-title']"));
    public static final Target LABEL_TITLE = Target.the("Title of the voucher or detail of the selected record").located(By.xpath("//h5[@class='drawer-title']"));
    public static final Target LABEL_SUBTITLE_MESSAGE = Target.the("voucher Initial Message")
            .located(By.xpath("//p[@class='card-subtitle']"));
    public static final Target LABEL_ACCOUNT_ORIGIN = Target.the("text with the origin account number")
            .located(By.xpath("//small[contains(.,'Producto')]//following-sibling::h6"));
    public static final Target LABEL_DESTINED_BANK = Target.the("text with the destination bank")
            .located(By.xpath("//small[contains(.,' Banco destino ')]//following-sibling::h6"));
    public static final Target LABEL_DESTINATION_ACCOUNT = Target.the("text with the destination account")
            .located(By.xpath("//small[contains(.,' Número de cuenta ')]//following-sibling::h6"));
    public static final Target LABEL_CREATION_DATE = Target.the("transaction creation date")
            .located(By.xpath("//small[contains(.,' Fecha de creación ')]//following-sibling::h6"));
    public static final Target LABEL_EXECUTE_DATE = Target.the("transaction execute date")
            .located(By.xpath("//small[contains(.,' Fecha de ejecución ')]//following-sibling::h6"));
    public static final Target LABEL_AMOUNT = Target.the("value transfer")
            .located(By.xpath("//small[contains(.,' Valor ')]//following-sibling::h6"));
    public static final Target LABEL_COST_TRX = Target.the("cost of the transaction")
            .located(By.xpath("//small[contains(.,'Costo de la transacción')]//following-sibling::h6"));

    public static final Target LABEL_TAG_PERIODIC = Target.the("the transaction tag")
            .located(By.xpath("//small[contains(.,'Etiqueta')]/following-sibling::iris-component-tag/div[@class='tag']"));

    public static final Target LABEL_DESCRIPTION= Target.the("description")
            .located(By.xpath("(//small[contains(.,'Descripción')]//following-sibling::h6)[2]"));

    public static final Target BTN_ELIMINATION_TRX=Target.the("button to delete a scheduled transaction from the detail of a selected record of the scheduled transactions table.")
            .located(By.xpath("//button[@class='btn btn-primary ng-star-inserted'][contains(text(),'Eliminar programación')]"));

    public static final Target BTN_DELETE_POP_UP =Target.the("button to confirm deletion of scheduled transaction ")
            .located(By.xpath("//div[@class='text-center']/button[@class='btn btn-primary'][contains(text(),'Eliminar')]"));

    public static final Target TEXT_MSG1_POP_UP = Target.the("title of the pop-up message when deleting a transaction")
            .located(By.xpath("//div[@class='overlay-container']/div/div/div[@class='ng-tns-c14-1 toast-title ng-star-inserted']"));

    public static final Target TEXT_MSG2_POP_UP = Target.the("pop-up message body when deleting a transaction ")
            .located(By.xpath("//div[@class='overlay-container']/div/div/div[@class='ng-tns-c14-1 toast-message ng-star-inserted']\n"));

    private PeriodicTransactionDetailUI(){
    }
}
