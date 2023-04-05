package co.com.iris.certification.userinterfaces.transactions.registeredaccounts;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisteredAccountsUI {

    public static final Target BTN_REGISTER_ACCOUNT = Target.the("button to go the form of registered accounts")
            .located(By.xpath("//button[contains(.,'Inscribir cuenta')]"));
    public static final Target BTN_GO_TO_FILTER = Target.the("button to enter the filter form of registered accounts")
            .located(By.xpath("//button[@class='btn btn-outline-primary btn-filter-drawer']"));
    public static final Target TEXT_SEARCH_HOLDER = Target.the("search input by account holder or description")
            .located(By.xpath("//input[@name='description']"));
    public static final Target TEXT_BANK = Target.the("input list of other banks")
            .located(By.xpath("//ng-select[@formcontrolname='destinationBankId']"));
    public static final Target TEXT_ACCOUNT_TYPE = Target.the("input list of accounts types")
            .located(By.xpath("//ng-select[@formcontrolname='destinationAccountType']"));
    public static final Target TEXT_STATUS = Target.the("input account registration status list")
            .located(By.xpath("//ng-select[@formcontrolname='status']"));
    public static final Target BTN_APPLY_FILTERS = Target.the("button to apply filters")
            .located(By.xpath("//button[@type='submit'][contains(.,'Aplicar filtros')]"));
    public static final Target LINK_GO_TO_TRANSFER = Target.the("Link to go to the transfers menu")
            .located(By.xpath("//a[@class='custom-breadcrumb with-back-icon d-none d-lg-flex']"));

    private RegisteredAccountsUI() {
    }
}
