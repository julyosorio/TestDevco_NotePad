package co.com.iris.certification.userinterfaces.payments.scheduledpayments;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ScheduledPaymentsTableUI {

    public static final Target COL_PAYMENT_ID = Target.the("column with payment identification")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover ng-star-inserted']/tbody/tr/td[2]"));
    public static final Target COL_PAYMENT_TYPE = Target.the("column with manual payment type")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover ng-star-inserted']/tbody/tr/td[3]"));
    public static final Target COL_QUANTITY = Target.the("column with the quantity")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover ng-star-inserted']/tbody/tr/td[4]"));
    public static final Target COL_PAYMENT_TAG = Target.the("column with the payment tag")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover ng-star-inserted']/tbody/tr/td[5]"));
    public static final Target COL_DATE_OF_CREATION = Target.the("column with the date the payment was created")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover ng-star-inserted']/tbody/tr/td[6]"));

    public static final Target COL_HOUR_OF_CREATION = Target.the("column with the date the payment was created")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover ng-star-inserted']/tbody/tr/td[6]/span"));
    public static final Target COL_SCHEDULED_DATE = Target.the("column with the scheduled date of payment")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover ng-star-inserted']/tbody/tr/td[7]"));
    public static final Target COL_TOTAL_VALUE = Target.the("column with the total value of the payment")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover ng-star-inserted']/tbody/tr/td[8]"));

    public static final Target ROW = Target.the("scheduled table rows, for payments")
            .located(By.xpath("//table[@class='table table-sm table-borderless table-hover ng-star-inserted']/tbody/tr"));
    //filters
    public static final Target BTN_FILTERS = Target.the("button to go to the filter form of the scheduled payments table")
            .located(By.xpath("//button[@class='btn btn-outline-primary btn-filter-drawer']"));
    public static final Target TEXT_PAYMENT_ID = Target.the("button to go to the filter form of the scheduled payments table")
            .located(By.xpath("//input[@formcontrolname='selectedDetails']"));
    public static final Target LIST_PAYMENT_TYPE = Target.the("field with the list of payment types")
            .located(By.xpath("//ng-select[@name='paymentType']"));
    public static final Target LIST_TAG = Target.the("field with the list of tags")
            .located(By.xpath("//ng-select[@name='tag']"));
    public static final Target BTN_APPLY_FILTERS = Target.the("Apply filters button")
            .located(By.xpath("//button[@type='submit'][contains(text(),'Aplicar filtros')]"));

}
