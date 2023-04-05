package co.com.iris.certification.userinterfaces.transactions.pendingtransaction;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PendingTransactionUI {
    public static final Target LABEL_SCHEDULED = Target.the("option to go to the menu of scheduled transactions").located(By.xpath("//div[@class='box-card img-programadas']"));
    public static final Target LABEL_AUTHORIZATION = Target.the("option to go to the authorization menu").located(By.xpath("//div[@class='box-card img-autorizacion']"));
    public static final Target LABEL_GO_TO_PAYMENTS = Target.the("option to go to the table of scheduled payments").located(By.xpath("//li[@class='nav-item ng-star-inserted']/a[contains(.,'Pagos')]"));
    public static final Target LABEL_GO_TO_TRANSACTIONS = Target.the("option to go to the table of programmed transactions").located(By.xpath("//li[@class='nav-item']/a[contains(.,'Transacciones')]"));


    private PendingTransactionUI(){}
}
