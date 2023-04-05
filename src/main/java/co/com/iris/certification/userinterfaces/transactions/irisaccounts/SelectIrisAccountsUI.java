package co.com.iris.certification.userinterfaces.transactions.irisaccounts;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SelectIrisAccountsUI {

    public static final Target LIST_ORIGINACCOUNT = Target.the("dropdown list to show the avaliable origin iris accounts for a transaction").located(By.xpath("(//div[@role='combobox'])[1]/input"));
    public static final Target OPTLST_ORIGINACCOUNT = Target.the("dropdown option to show the different iris origin accounts available for the transaction").located(By.xpath("//div[@role='option']"));
    public static final Target LIST_DESTINATIONACCOUNT  = Target.the("dropdown list to show the avaliable iris destination accounts for a transaction").located(By.xpath("(//div[@role='combobox'])[2]/input"));
    public static final Target OPTLST_DESTINATIONACCOUNT = Target.the("dropdown option to show the different iris destination accounts available for the transaction").located(By.xpath("//span[@class='ng-option-label']"));

    private SelectIrisAccountsUI(){

    }
}
