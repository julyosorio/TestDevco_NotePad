package co.com.iris.certification.userinterfaces.transactions.otherbanks;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SelectAccountsOtherBanksUI {
    public static final Target LIST_ORIGIN_ACCOUNT = Target.the("dropdown list to show the avaliable origin accounts for a transaction").located(By.xpath("(//div[@role='combobox'])[1]/input"));
    public static final Target OPTLST_ORIGIN_ACCOUNT = Target.the("dropdown option to show the different own accounts available for the transaction").located(By.xpath("//span[@class='ng-option-label']"));
    public static final Target LIST_DESTINATION_BANK = Target.the("dropdown list to show the avaliable destination banks for a transaction").located(By.xpath("(//div[@role='combobox'])[2]/input"));
    public static final Target OPTLST_DESTINATION_BANK = Target.the("dropdown option to show the different banks available for the transaction").located(By.xpath("//span[@class='ng-option-label']"));
    public static final Target LIST_DESTINATION_ACCOUNT = Target.the("dropdown list to show the avaliable destination accounts for a transaction").located(By.xpath("(//div[@role='combobox'])[3]/input"));
    public static final Target OPTLST_DESTINATION_ACCOUNT = Target.the("dropdown option to show the different destination accounts available for the transaction").located(By.xpath("//span[@class='ng-option-label']"));
    public static final Target BTN_SUBSCRIBE_ACCOUNT = Target.the("button to access to subscribe account form").located(By.xpath("//h6[contains(.,'Nueva cuenta')]"));
    public static final Target LABEL_VALUE_DESTINATION_ACCOUNT = Target.the("label that indicate the value of destination account according with new subscribed account").located(By.xpath("(//span[@class='ng-value-label'])[3]"));
    public static final Target LABEL_VALUE_BANK_SELECTED = Target.the("label that indicate the value of bank selected for the new subscribed account").located(By.xpath("(//span[@class='ng-value-label'])[2]"));

    private SelectAccountsOtherBanksUI(){

    }

}
