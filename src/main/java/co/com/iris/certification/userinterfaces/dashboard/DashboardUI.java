package co.com.iris.certification.userinterfaces.dashboard;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardUI {

    public static final Target LABEL_WELCOME = Target.the("Welcome Text")
            .located(By.xpath("//div[@class='d-none d-xl-block']/p/b"));
    public static final Target BTN_INIT_EXIT = Target.the("initial exit button")
            .located(By.xpath("//*/button[@class='btn btn-sm btn-primary text-white']"));
    public static final Target BTN_CONFIRM_EXIT = Target.the("confirm exit button")
            .located(By.xpath("//*/button[@class= 'btn btn-primary' and text()=' Salir ']"));
    public static final Target MENU_SUMMARY = Target.the("Dashboard option to show the account summary")
            .located(By.xpath("//div[@href='#'][contains(.,'Resumen')]"));
    public static final Target MENU_TRANSACTIONS = Target.the("Dashboard option to show the account transactions")
            .located(By.xpath("//div/p[contains(.,'Transferencias')]"));
    public static final Target MENU_PAYMENTS = Target.the("Dashboard option to show payments menu")
            .located(By.xpath("//div/p[contains(.,'Pagos')]"));
    public static final Target MENU_PENDING_TRX = Target.the("Dashboard option to show pending transactions menu")
            .located(By.xpath("//div/p[contains(.,'Transacciones pendientes')]"));
    public static final Target MENU_TRX_HISTORY = Target.the("Dashboard option to show the transaction history")
            .located(By.xpath("//div/p[contains(.,'Histórico de transacciones')]/preceding-sibling::img"));

    public static final Target MENU_USER_ADMINISTRATION = Target.the("Dashboard option to show the user administration menu")
            .located(By.xpath("//div/p[contains(.,'Administración de usuarios')]"));

    public static final Target MENU_CONFIGURATION = Target.the("Dashboard option to show the configuration menu")
            .located(By.xpath("//div/p[contains(.,'Configuración')]"));

    public static final Target MENU_IRISPAY = Target.the("Dashboard option to show the irispay menu")
            .located(By.xpath("//div[@href='#'][contains(.,'IrisPay')]"));
    public static final Target WAIT_LOADER = Target.the("Element that shows when is loading any action in the iris app")
            .located(By.tagName("iris-spinner"));

    public static final Target SPINNER = Target.the("Element that shows when is loading any action in the iris app")
            .located(By.id("spinner"));
    public static final Target BTN_TRANSACTION_DETAIL = Target.the("Dashboard button to show the transaction detail, called 'ver todo'")
            .located(By.xpath("//button[contains(., 'Ver todo')]"));

    private DashboardUI() {
    }
}
