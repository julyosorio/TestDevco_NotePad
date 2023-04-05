package co.com.iris.certification.userinterfaces.authorization;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VoucherPendingAuthorizationUI {
    public static final Target ROW_RECORD_CORRECT = Target.the("row with the information correct")
            .located(By.xpath("//tbody/tr[1]"));
    public static final Target LABEL_TYPE_TRANSACTION = Target.the("label that shows type transaction done")
            .located(By.xpath("//h5[contains(text(),'Transferencia')]"));
    public static final Target LABEL_NUMBER_ORIGIN_ACCOUNT = Target.the("label with number origin account")
            .located(By.xpath("//small[contains(text(),'Producto')]/following-sibling::h6"));
    public static final Target LABEL_NAME_DESTINATION_BANK = Target.the("name of destination bank")
            .located(By.xpath("//small[contains(text(),'Banco')]/following-sibling::h6"));
    public static final Target LABEL_NUMBER_DESTINATION_ACCOUNT = Target.the("label with number destination account")
            .located(By.xpath("//small[contains(text(),'Número de cuenta')]/following-sibling::h6"));
    public static final Target LABEL_VALUE_REGISTER = Target.the("label with value transfer or pay")
            .located(By.xpath("//small[contains(text(),'Valor')]/following-sibling::h6"));
    public static final Target LABEL_COST_REGISTER = Target.the("label with cost transfer or pay")
            .located(By.xpath("//small[contains(text(),'Costo')]/following-sibling::h6"));
    public static final Target LABEL_CREATION_DATE_VOUCHER = Target.the("label with creation date")
            .located(By.xpath("//small[contains(text(),'creación')]/following-sibling::h6"));
    public static final Target LABEL_EXECUTION_DATE_VOUCHER = Target.the("label with execution date")
            .located(By.xpath("//small[contains(text(),'ejecución')]/following-sibling::h6"));
    public static final Target LABEL_TAG_VOUCHER = Target.the("label with tag")
            .located(By.xpath("//small[contains(text(),'Etiqueta')]/following::span"));
    public static final Target LABEL_DESCRIPTION_VOUCHER = Target.the("label with the description")
            .located(By.xpath("(//small[contains(text(),'Descripción')]/following-sibling::h6)[2]"));
    public static final Target BTN_CLOSE_AUTHORIZATION_VOUCHER = Target.the("button to close the authorization voucher")
            .located(By.xpath("//a[contains(@class,'close')]"));

    private VoucherPendingAuthorizationUI(){}
}
