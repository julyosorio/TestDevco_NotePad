package co.com.iris.certification.userinterfaces.usermanagement.users;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserFiltersUI {

    public static final Target BTN_USER_FILTERS = Target.the("button to open the form with the user filters")
            .located(By.xpath("//div[contains(@class,'filter')]"));
    public static final Target NAME_USER = Target.the("field to enter the name filter")
            .located(By.id("filter-name"));
    public static final Target BTN_FILTERS_USERPROFILE = Target.the("button to open the filter form for the table user profiles")
            .located(By.xpath("//button[@class='btn btn-outline-primary btn-filter-drawer']"));
    public static final Target TEXT_FILTER_NAME_USER = Target.the("field to enter the full name of the user you want to filter by")
            .located(By.xpath("//div/label[@for='filter-name']//following-sibling::input[@placeholder='Búsqueda de Nombre']"));
    public static final Target LIST_FILTER_ROL = Target.the("button for scrolling the list of roles ")
            .located(By.xpath("//ng-select[@formcontrolname='selectedRole']"));
    public static final Target OPTLST_FILTER_ROL = Target.the("List of roles")
            .located(By.xpath("//div/div[@role='option']"));
    public static final Target LIST_FILTER_STATUS = Target.the("button for scrolling the list of states ")
            .located(By.xpath("//ng-select[@formcontrolname='selectedStatus']"));
    public static final Target OPTLST_FILTER_STATUS = Target.the("List of status")
            .located(By.xpath("//div/div[@role='option']"));
    public static final Target BTN_APPLY_FILTERS = Target.the("Button to apply the filter to the user profile table.")
            .located(By.xpath("//button[@type='submit'][contains(.,'Aplicar filtros')]"));
    private UserFiltersUI(){

    }
}
