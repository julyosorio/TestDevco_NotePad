package co.com.iris.certification.userinterfaces.transactions.voucher;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

    public class SuccessfulVoucherUI {
        public static final Target LABEL_ORIGIN_ACCOUNT = Target.the("origin account number")
                .located(By.xpath("//small[contains(text(),'Producto')]//following-sibling::h6"));
        public static final Target LABEL_DESTINATION_ACCOUNT = Target.the("destination account name")
                .located(By.xpath("//small[contains(text(),'Cuenta destino')]//following-sibling::h6"));
        public static final Target LABEL_DESTINATION_OWN_ACCOUNT = Target.the("destination own account name")
                .located(By.xpath("//small[contains(.,'Producto destino')]//following-sibling::h6"));
        public static final Target LABEL_DESTINATION_BANK_VOUCHER = Target.the("destination bank")
                .located(By.xpath("//small[contains(text(),'Banco destino')]//following-sibling::h6"));
        public static final Target LABEL_AMOUNT = Target.the("transaction amount")
                .located(By.xpath("//small[contains(.,'Valor')]//following-sibling::h6"));
        public static final Target LABEL_TRANSACTION_COST = Target.the("Transaction cost")
                .located(By.xpath("//small[contains(.,'Costo de la transacción')]/following-sibling::h6"));
        public static final Target LABEL_DESCRIPTION = Target.the("Label with the description that was added to the transaction")
                .located(By.xpath("//small[contains(text(),'Descripción')]/following-sibling::h6"));
        public static final Target LABEL_TRANSACTION_DATE = Target.the("date when the transaction was done")
                .located(By.xpath("//div[@class='col-12 p-0 text-center']//small"));
        public static final Target LIST_VOUCHER_SEND = Target.the("dropdownlist to display the options to send or generate the voucher")
                .located(By.id("dropdownManual"));
        public static final Target OPTLST_VOUCHER_SEND_BY_EMAIL = Target.the("option to send the voucher by email")
                .located(By.xpath("//button[@id='dropdownManual']//following-sibling::div/button[contains(text(),'Enviar')]"));
        public static final Target TEXT_EMAIL_TO_SEND = Target.the("input to put the email address in which the voucher will be sent")
                .located(By.xpath("//div[@role='combobox']/input"));
        public static final Target BTN_SEND_EMAIL = Target.the("button to send the voucher by email")
                .located(By.xpath("//button[@type='submit' and contains(text(), 'Enviar')]"));
        public static final Target BTN_CLOSE_VOUCHER = Target.the("button to close the voucher")
                .located(By.xpath("//a[@class='close-drawer']"));
        public static final Target BTN_CLOSE_SEND_EMAIL = Target.the("button to close the email send window")
                .located(By.xpath("//button[contains(text(), 'Cerrar esta ventana')]"));

        private SuccessfulVoucherUI(){
        }

    }


