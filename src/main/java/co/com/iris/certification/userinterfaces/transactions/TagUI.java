package co.com.iris.certification.userinterfaces.transactions;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TagUI {
    public static final Target LIST_TAG = Target.the("dropdown list to select a tag").located(By.xpath("//div[contains(text(),'etiqueta')]/parent::div"));
    public static final Target OPTLST_TAG = Target.the("select a tag from the dropdown list").located(By.xpath("//div[@class='tag']/span"));
    public static final Target TEXT_DESCRIPTION = Target.the("input to enter the optional description for transaction").located(By.id("details"));

    public static final Target BTN_CLOSE_TAG = Target.the("button to close tag window").located(By.xpath("//a[@class='close-drawer']"));

    private TagUI(){
    }
}
