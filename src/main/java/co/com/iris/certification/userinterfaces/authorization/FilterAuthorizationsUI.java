package co.com.iris.certification.userinterfaces.authorization;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FilterAuthorizationsUI {
    public static final Target BTN_FILTER = Target.the("button to open filter window").located(By.xpath("//button[@class='btn btn-outline-primary btn-filter-drawer']"));
    public static final Target LIST_OPTION_OPERATION = Target.the("field to select the type of operation").located(By.xpath("//ng-select[@formcontrolname='selectedOperation']"));
    public static final Target LIST_TYPE_OPERATION = Target.the("field to select the sub type of operation")
            .located(By.xpath("//ng-select[@formcontrolname='selectedTypes']"));
    public static final Target LIST_TAG = Target.the("field to select the label in the filter of the my authorizations table")
            .located(By.xpath("//ng-select[@formcontrolname='selectedTag']"));
    public static final Target OPTLIST_TAG = Target.the("field to select the label in the filter of the my authorizations table")
            .located(By.xpath("//ng-dropdown-panel[@role='listbox']/div/div/div[@role='option']"));
    public static final Target BTN_APLLY_FILTERS = Target.the("button to apply filters").located(By.xpath("//button[@type='submit']"));

    private FilterAuthorizationsUI(){

    }
}
