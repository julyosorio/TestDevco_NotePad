package co.com.iris.certification.userinterfaces.usermanagement.roles;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RolesFiltersUI {
    public static final Target BTN_FILTERS = Target.the("button to open filter window")
            .located(By.className("filter-btn-content"));
    public static final Target LIST_ROLE_NAME = Target.the("list with the role names avaliable to select ")
            .located(By.xpath("//ng-select[@formcontrolname='roles']"));

    public static final Target OPT_LST_ROLE_NAME = Target.the("values avaliable in the list that contains the role names")
            .located(By.xpath("//div[@role='option']"));
    public static final Target BTN_APPLY_FILTERS = Target.the("button to apply filters selected")
            .located(By.xpath("//button[@type='submit']"));
    private RolesFiltersUI(){}
}
