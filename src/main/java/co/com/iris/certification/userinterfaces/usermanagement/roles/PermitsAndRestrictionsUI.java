package co.com.iris.certification.userinterfaces.usermanagement.roles;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PermitsAndRestrictionsUI {
    public static final Target CHECK_PERMITS_GENERAL_BANKING = Target.the("check to select all permits for banking")
            .located(By.xpath("//input[@id='module-permissions']/parent::div"));
    public static final Target CHECK_PERMITS_FOR_SUMMARY_GROUP = Target.the("check with the specified permits for summary group")
            .located(By.xpath("//input[@id='module-SUMMARY']/parent::div"));
    public static final Target CHECK_PERMITS_FOR_TRANSACTION_GROUP = Target.the("check with the specified permits for transaction group")
            .located(By.xpath("//input[@id='module-TRANSACTIONS']/parent::div"));
    public static final Target CHECK_PERMITS_FOR_PAYMENTS_GROUP = Target.the("check with the specified permits for payments group")
            .located(By.xpath("//input[@id='module-PAYMENTS']/parent::div"));
    public static final Target CHECK_PERMITS_FOR_PSE_GROUP = Target.the("check with the specified permits for pse group")
            .located(By.xpath("//input[@id='module-PSE']/parent::div"));
    public static final Target CHECK_PERMITS_FOR_CONFIGURATION_GROUP = Target.the("check with the specified permits for configuration group")
            .located(By.xpath("//input[@id='module-ADMINISTRATION']/parent::div"));
    public static final Target LIST_AUTHORIZER_ROLES_ASSOCIATED_TO_EACH_OPERATION =Target.the("list with the authorizer roles for associate to each operation that require it")
            .located(By.xpath("//div[not(contains(@class,'card-role-authorizers'))]/following::td/ng-select"));
    public static final Target OPT_LIST_AUTHORIZER_ROLES_ASSOCIATED_TO_EACH_OPERATION = Target.the("values of list authorizer roles for associate to each operation that require authorization")
            .located(By.xpath("//div[@role='option']"));
    public static final Target CHECK_PERMITS_TO_MANAGEMENT_COMPLEMENT_SELECTED = Target.the("check to select all permits for management the complement selected")
            .located(By.xpath("//input[@id='module-permissions']/parent::div"));

    public static final Target CHECK_REQUIRES_AUTHORIZER = Target.the("check to operation that requires authorization")
            .located(By.xpath("//input[contains(@id,'authorize')]/parent::label"));

    private PermitsAndRestrictionsUI(){}
}
