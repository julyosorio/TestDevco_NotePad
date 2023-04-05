package co.com.iris.certification.userinterfaces.usermanagement.roles;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ListRolesUI {

    public static final Target LABEL_ROLE_NAME = Target.the("field of card that contains the name role")
            .located(By.xpath("//div[contains(@class,'card link')]/following::h6[1]"));

    public static final Target LIST_TAGS_WITH_COMPLEMENTS_SELECTED_IN_ROLE = Target.the("list with the tags about the complements that contains the role")
            .located(By.xpath("//div[@class='tag']/span"));

    public static final Target LINK_DETAILS_ROLE = Target.the("link to access to detail of role viewed in card")
            .located(By.cssSelector("a.link"));

    public static final Target LABEL_DESCRIPTION_ROLE = Target.the("field of card that contains the description role")
            .located(By.xpath("(//p[contains(@class,'card-description')])[2]"));

    public static final Target LABEL_NUMBER_USERS_WITH_THE_ROLE = Target.the("label that contains count of user associated to this role")
            .located(By.xpath("//label[contains(text(),'USUARIOS')]/following::span[1]"));

    public static final Target LABEL_NUMBER_PRODUCTS_INCLUDED_IN_THE_ROLE = Target.the("label that contains count of products associated to this role")
            .located(By.xpath("//label[contains(text(),'PRODUCTOS')]/following::span[1]"));

    public static final Target LABEL_STATUS_ROLE = Target.the("label with the status of role")
            .located(By.xpath("//h6[contains(text(),'Activo')]"));

    public static final Target CHECK_STATUS_ROLE = Target.the("check to change the status role")
            .located(By.xpath("//h6[contains(text(),'Activo')]/following-sibling::label/span"));

    private ListRolesUI() {

    }
}
