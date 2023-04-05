package co.com.iris.certification.userinterfaces.transactions;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardTransactionsUI {
    public static final Target LABEL_REGISTERED_ACCOUNTS = Target.the("button to go the menu of registered accounts").located(By.xpath("//app-box-card/div/div[@class='box-card img-cuentas-inscritas']"));
    public static final Target LABEL_OWN_ACCOUNTS = Target.the("option menu for own account transactions").located(By.xpath("//app-box-card/div/div[@class='box-card img-cuentas-propias']"));
    public static final Target LABEL_IRIS_ACCOUNTS = Target.the("option menu for transactions with iris accounts").located(By.xpath("//app-box-card/div/div[@class='box-card img-banco-iris']"));
    public static final Target LABEL_OTHER_BANKS_ACCOUNTS = Target.the("option menu for transactions with another banks accounts").located(By.xpath("//app-box-card/div/div[@class='box-card img-otros-bancos']"));
    public static final Target LABEL_IN_BATCH = Target.the("option menu for in batch transactions").located(By.xpath("//app-box-card/div/div[@class='box-card img-en-lote']"));


    private DashboardTransactionsUI(){
    }
}
