package co.com.iris.certification.userinterfaces.authorization;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MyAuthorizationsUI {

    //TABLE
    public static final Target CHECK_SELECT = Target.the("column with the checkbox for authorizing a row of the my authorizations table ")
            .located(By.xpath("//table/tbody/tr/td[1]"));
    public static final Target COL_OPERATION = Target.the("Column with the type of operation").located(By.xpath("//table/tbody/tr/td[2]"));
    public static final Target COL_TYPE_OPERATION = Target.the("Column with the sub type of operation").located(By.xpath("//table/tbody/tr/td[3]"));
    public static final Target COL_QUANTITY = Target.the("Column with the quantity").located(By.xpath("//table/tbody/tr/td[4]"));
    public static final Target COL_CREATION_DATE = Target.the("Column with the creation date").located(By.xpath("//table/tbody/tr/td[5]"));
    public static final Target COL_EXECUTE_DATE = Target.the("Column with the execute date").located(By.xpath("//table/tbody/tr/td[6]"));
    public static final Target COL_CREATE_BY = Target.the("Column with the create by").located(By.xpath("//table/tbody/tr/td[7]"));
    public static final Target COL_TAGS = Target.the("Column with the tags").located(By.xpath("//table/tbody/tr/td[8]"));
    public static final Target COL_VALUE = Target.the("Column with the value transfer").located(By.xpath("//table/tbody/tr/td[9]"));
    public static final Target ROW_CORRECT = Target.the("Row").located(By.xpath("//table/tbody/tr"));

    //Buttons to authorize pop up
    public static final Target BTN_AUTHORIZE = Target.the("Authorize button window detail")
            .located(By.xpath("(//button[contains(text(),'Autorizar')])[3]"));
    public static final Target BTN_AUTHORIZE_POP_UP = Target.the("Authorize button pop up")
            .located(By.xpath("(//div[@class='text-center']/button[@class='btn btn-primary'])[1]"));
    public static final Target BTN_NO_AUTHORIZE = Target.the("No Authorize button window detail")
            .located(By.xpath("(//button[contains(text(),'No autorizar')])[3]"));
    public static final Target BTN_NO_AUTHORIZE_POP_UP = Target.the("No Authorize button window detail")
            .located(By.xpath("(//button[contains(text(),'No autorizar')])[4]"));

    public static final Target BTN_AUTHORIZE_MAIN = Target.the("Main button authorize")
            .located(By.xpath("(//button[contains(text(),'Autorizar')])[1]"));
    public static final Target BTN_NO_AUTHORIZE_MAIN = Target.the("Main button No authorize")
            .located(By.xpath("(//button[contains(text(),'No autorizar')])[1]"));

    //POP UP TRANSACTION SUCCESSFUL
    public static final Target LABEL_POP_UP1 = Target.the("pop up transaction passed successfully")
            .located(By.xpath("//div[contains(@class, 'toast-title ng-star-inserted')]"));
    public static final Target LABEL_POP_UP2 = Target.the("pop up transaction passed successfully")
            .located(By.xpath("//div[@role='alertdialog']"));

    public static final Target TEXT_REASON = Target.the("field to enter the text of the reason for not authorizing the transaction")
            .located(By.xpath("//input[@type='text']"));


    private MyAuthorizationsUI(){

    }
}
