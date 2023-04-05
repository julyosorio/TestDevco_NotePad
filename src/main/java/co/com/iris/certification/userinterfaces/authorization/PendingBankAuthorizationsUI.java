package co.com.iris.certification.userinterfaces.authorization;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PendingBankAuthorizationsUI {
    //TABLE
    public static final Target COL_OPERATION = Target.the("Column with the type of operation").located(By.xpath("//table/tbody/tr/td[2]"));
    public static final Target COL_TYPE_OPERATION = Target.the("Column with the sub type of operation").located(By.xpath("//table/tbody/tr/td[3]"));
    public static final Target COL_QUANTITY = Target.the("Column with the quantity").located(By.xpath("//table/tbody/tr/td[4]"));
    public static final Target COL_CREATION_DATE = Target.the("Column with the creation date").located(By.xpath("//table/tbody/tr/td[5]"));
    public static final Target COL_NAME_CREATION_DATE = Target.the("Name column creation date").located(By.xpath("//tr/th[6]"));
    public static final Target COL_EXECUTE_DATE = Target.the("Column with the execute date").located(By.xpath("//table/tbody/tr/td[6]"));
    public static final Target COL_AUTHORIZERS = Target.the("Column with the name of the authorizers ").located(By.xpath("//table/tbody/tr/td[7]"));
    public static final Target COL_TAGS = Target.the("Column with the tags").located(By.xpath("//table/tbody/tr/td[8]"));
    public static final Target COL_VALUE = Target.the("Column with the value transfer").located(By.xpath("//table/tbody/tr/td[9]"));


    private PendingBankAuthorizationsUI(){

    }
}
