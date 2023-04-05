package co.com.iris.certification.userinterfaces.payments;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddPayToListUI {

    public static final Target LIST_DESTINATION_BANK = Target.the("dropdown list to show the avaliable destination banks for the payment transaction")
            .located(By.xpath("(//div[@role='combobox'])[1]"));
    public static final Target OPTLST_DESTINATION_BANK = Target.the("dropdown option to show available destination banks for the payment transaction")
            .located(By.xpath("//div[@role='option']/span"));
    public static final Target LIST_DESTINATION_ACCOUNT = Target.the("dropdown list to show the avaliable destination accounts for the payment transaction")
            .located(By.xpath("(//div[@role='combobox'])[2]"));
    public static final Target OPTLST_DESTINATION_ACCOUNT = Target.the("dropdown option to show available destination banks for the payment transaction")
            .located(By.xpath("//div[@role='option']/span"));
    public static final Target TEXT_AMOUNT = Target.the("field to enter the transfer value for add payment to the pay list")
            .located(By.id("amount"));
    public static final Target LABEL_MESSAGE_INVALID_VALUE = Target.the("message that indicates the value pay is invalid")
            .located(By.xpath("//div[contains(@class,'invalid-feedback')]"));
    public static final Target BTN_ADD_PAYMENT_TO_THE_LIST = Target.the("button for add the payment to the pay list")
            .located(By.xpath("//button[contains(.,'Añadir')]"));
    public static final Target LABEL_TOAST_MESSAGE_PAY_ADDED_SUCCESSFULLY = Target.the("message that indicates the pay was added successfully to the pay list")
            .located(By.xpath("//div[@role='alertdialog']"));
    public static final Target LABEL_ADD_PAY = Target.the("label that indicates add pay")
            .located(By.xpath("//p[contains(.,'50 pagos manuales')]"));
    public static final Target LABEL_QUATITY_PAYMENTS_ADDED_TO_LIST = Target.the("label that the quantity the payments added in the pay list")
            .located(By.xpath("//h6[contains(@class,'payment-number')]"));

    private AddPayToListUI(){}
}
