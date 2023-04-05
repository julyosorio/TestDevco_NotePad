package co.com.iris.certification.userinterfaces.payments;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ManualPaymentUI {
    public static final Target PAYROLL_PAYMENT = Target.the("option payroll payment")
            .located(By.xpath("//h3[contains(.,'Nómina')]"));
    public static final Target SUPPLIERS_PAYMENT = Target.the("option suppliers payment")
            .located(By.xpath("//h3[contains(.,'Proveedores')]"));
    public static final Target LIST_ORIGIN_ACCOUNT = Target.the("dropdown list to show the avaliable origin accounts for the payment transaction")
            .located(By.xpath("//div[@role='combobox']"));
    public static final Target LIST_ORIGIN_ACCOUNT_EDITING_PAY = Target.the("dropdown list to show the avaliable origin accounts for the payment transaction")
            .located(By.xpath("(//div[@role='combobox']/following::span)[3]"));
    public static final Target OPTLST_ORIGIN_ACCOUNT = Target.the("dropdown option to show the different own accounts available for the payment transaction")
            .located(By.xpath("//div[@role='option']/span"));

    public static final Target BTN_NEXT = Target.the("button for continue with the payment transaction")
            .located(By.xpath("//button[contains(.,'Siguiente')]"));

    public static final Target BTN_BACK = Target.the("button for back in the payment transaction")
            .located(By.xpath("//button[contains(.,'Volver')]"));
    public static final Target TEXT_PAYMENT_ID = Target.the("field to enter the identificator for the payment transaction")
            .located(By.id("details"));
    public static final Target LABEL_ID_PAY_ERROR_MESSAGE = Target.the("label that show error message when the pay id entered already exists")
            .located(By.xpath("//a[contains(.,'identificación debe ser única')]"));
    public static final Target BTN_SEND_BATCH = Target.the("button for complete the pay transaction and send batch")
            .located(By.xpath("//button[contains(.,'Enviar lote')]"));
    public static final Target BTN_SAVE_PAY = Target.the("button for save the pay transaction for use it later")
            .located(By.xpath("//button[contains(.,'Guardar')]"));

    private ManualPaymentUI(){}
}
