package co.com.iris.certification.userinterfaces.transactionshistory.payments;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentsHistoricFiltersUI {
    public static final Target BTN_FILTERS = Target.the("button to open the form to enter the search filters desired")
            .located(By.xpath("//button/div[contains(.,'Filtros')]"));
    public static final Target LIST_PAY_TYPE = Target.the("list with the pay type avaliable as filter")
            .located(By.name("paymentType"));

    public static final Target LIST_STATUS_PAY_TRANSACTION = Target.the("list with the status avaliable to pay transaction")
            .located(By.name("paymentStatus"));
    public static final Target LIST_TAG_PAY_TRANSACTION = Target.the("list with the tags avaliable to pay transaction")
            .located(By.name("tag"));
    public static final Target BTN_APPLY_FILTERS = Target.the("button to save and apply the filter entered")
            .located(By.xpath("//button[contains(.,'Aplicar filtros')]"));

    private PaymentsHistoricFiltersUI(){}
}
