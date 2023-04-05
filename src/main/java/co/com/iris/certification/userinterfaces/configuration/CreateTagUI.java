package co.com.iris.certification.userinterfaces.configuration;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateTagUI {

    public static final Target TEXT_TAG_NAME = Target.the("field to enter the tag name")
            .located(By.id("name"));

    public static final Target LIST_USERS_TO_ASSIGN_TAG = Target.the("users list assigned to the new tag")
            .located(By.xpath("//div[contains(.,'Usuario')]/following-sibling::div[@role='combobox']/parent::div"));

    public static final Target OPTLST_USERS_TO_ASSIGN_TAG = Target.the("dropdown option to show the users avaliable for assign to the tag")
            .located(By.xpath("//div[@role='option']"));

    public static final Target LIST_USERS_SELECTED = Target.the("field with the users selected")
            .located(By.xpath("//div[contains(.,'Usuario')]/following-sibling::div/span[2]"));

    public static final Target LIST_TYPES_OPERATION_TO_ASSIGN_TAG = Target.the("type operations list assigned to the new tag")
            .located(By.xpath("//div[contains(.,'Tipo de operación')]/following-sibling::div[@role='combobox']/parent::div"));

    public static final Target OPTLST_TYPES_OPERATION_TO_ASSIGN_TAG = Target.the("dropdown option to show the users avaliable for assign to the tag")
            .located(By.xpath("//div[@role='option']"));

    public static final Target LIST_OPERATIONS_SELECTED = Target.the("field with the operation types selected")
            .located(By.xpath("//div[contains(.,'Tipo de operación')]/following-sibling::div/span[2]"));

    public static final Target LIST_CATEGORIES = Target.the("categories list to assign to the new tag")
            .located(By.xpath("//div[contains(.,'Categorías')]/following-sibling::div[@role='combobox']/parent::div"));

    public static final Target OPTLST_CATEGORIES_TO_ASSIGN_TAG = Target.the("dropdown option to show the categories avaliable for assign to the tag")
            .located(By.xpath("//div[@role='option']"));

    public static final Target BTN_SAVE_NEW_TAG = Target.the("button to complete and save the new tag")
            .located(By.xpath("//button[contains(.,'Guardar')]"));

    public static final Target LABEL_TAG_CREATED_SUCCESSFUL = Target.the("label that indicates the tag was created successfully")
            .located(By.xpath("//div[@role='alertdialog']"));
    public static final Target LABEL_TAG_ALREADY_EXISTING = Target.the("label that indicates the tag name already was used")
            .located(By.xpath("//div[@role='alertdialog'][contains(.,'No se permite crear dos tags')]"));
}
