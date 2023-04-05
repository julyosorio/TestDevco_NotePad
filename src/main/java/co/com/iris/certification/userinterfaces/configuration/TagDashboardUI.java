package co.com.iris.certification.userinterfaces.configuration;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class TagDashboardUI {
    public static final Target BTN_CREATE = Target.the("button that show the options create category or create tag")
            .located(By.xpath("//button[contains(.,'Crear categoría')]/parent::div/preceding-sibling::button"));
    public static final Target OPT_CREATE_CATEGORY = Target.the("option to access to category creation form")
            .located(By.xpath("//button[contains(.,'Crear categoría')]"));
    public static final Target OPT_CREATE_TAG = Target.the("option to access to tag creation form")
            .located(By.xpath("//button[contains(.,'Crear etiqueta')]"));
}
