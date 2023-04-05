package co.com.iris.certification.userinterfaces.transactionshistory;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HistoricTableUI {

    public static final Target LINK_PAYMENTS_AND_BATCHES = Target.the("link to access to payments and batches option")
            .located(By.xpath("//a[contains(.,'Pagos y lotes')]"));

    public static final Target LINK_TRANSACTIONS = Target.the("link to access to transactions option")
            .located(By.xpath("//a[contains(.,'Transacciones')]"));

    private HistoricTableUI(){}
}
