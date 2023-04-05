package co.com.iris.certification.userinterfaces.usermanagement.roles;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsAndComplementsUI {
    public static final Target LIST_PRODUCTS_FOR_ASSOCIATES_TO_THE_ROLE = Target.the("list of products avaliable for associates to the new role")
            .located(By.xpath("//input[@type='checkbox']/following::p"));
    public static final Target LIST_COMPLEMENTS_FOR_ASSOCIATE_TO_THE_ROLE = Target.the("list of complements avaliable for associate to the new role")
            .located(By.xpath("//label[contains(@for,'complement')]"));

    private ProductsAndComplementsUI(){}
}
