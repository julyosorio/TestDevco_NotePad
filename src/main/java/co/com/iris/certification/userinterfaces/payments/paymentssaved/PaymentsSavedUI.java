package co.com.iris.certification.userinterfaces.payments.paymentssaved;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class PaymentsSavedUI {
    public static final Target COL_CREATE_DATE = Target.the("column for create date of pay saved")
            .located(By.xpath("//th[contains(.,'Fecha')]"));

    public static final Target ROW_RECORD_PAY = Target.the("row with the records viewed in payments saved table")
            .located(By.xpath("//tbody/tr"));
    public static final Target BTN_NEXT_PAGE = Target.the("button to access to the records of the next page")
            .located(By.xpath("//a[contains(@class,'ic-arrow-right')]/parent::li"));
    public static final Target ROW_ID_PAY = Target.the("row with the id of payments saved viewed in table")
            .located(By.xpath("//tbody/tr/td[1]"));
    public static final Target ROW_AMOUNT_PAYMENTS = Target.the("row with the payments amount asociated to the pay saved viewed in table")
            .located(By.xpath("//tbody/tr/td[2]"));
    public static final Target ROW_PAY_TYPE = Target.the("row with the pay type for the pay saved viewed in table")
            .located(By.xpath("//tbody/tr/td[3]"));
    public static final Target ROW_CREATE_DATE_PAY = Target.the("row with the create date for the pay saved viewed in table")
            .located(By.xpath("//tbody/tr/td[4]"));
    public static final Target ROW_TAG_PAY = Target.the("row with the tag asociated to the pay saved viewed in table")
            .located(By.xpath("//tbody/tr/td[5]"));
    public static final Target ROW_TOTAL_VALUE_PAY = Target.the("row with the total value of pay saved viewed in table")
            .located(By.xpath("//tbody/tr/td[6]"));
    public static final Target BTN_OPTIONS_PAY = Target.the("button that display the options for record pay")
            .located(By.xpath("(//i[@id='dropdownOptions'])[num]"));
    public static final Target BTN_DELETE_PAY = Target.the("button to delete record pay")
            .located(By.xpath("//div[contains(@class,'show')]/button[contains(.,'Eliminar')]"));
    public static final Target BTN_CONFIRM_DELETE_PAY = Target.the("button to confirm delete pay")
            .located(By.xpath("//button[contains(.,'Eliminar')]/parent::div[not(contains(@class,'dropdown-menu'))]"));
    public static final Target BTN_EDIT_PAY = Target.the("button to edit pay")
            .located(By.xpath("//div[contains(@class,'show')]/button[contains(.,'Editar')]"));

    private PaymentsSavedUI(){}
}

