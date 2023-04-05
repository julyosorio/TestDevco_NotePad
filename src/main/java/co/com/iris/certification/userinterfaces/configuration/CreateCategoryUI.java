package co.com.iris.certification.userinterfaces.configuration;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateCategoryUI {
    public static final Target TEXT_CATEGORY_NAME = Target.the("field to enter the category name")
            .located(By.id("name"));
    public static final Target LIST_TAGS_TO_CATEGORY = Target.the("tags list to selected to the new category")
            .located(By.xpath("//div[@role='combobox']/preceding-sibling::div[contains(.,'Etiquetas')]/parent::div"));
    public static final Target OPTLST_TAGS_TO_ASSIGN_TO_CATEGORY = Target.the("dropdown option to show the tags avaliable for assign to the category")
            .located(By.xpath("//div[@role='option']"));
    public static final Target LIST_TAGS_SELECTED = Target.the("field with the tags list selected for the new category")
            .located(By.xpath("//div[contains(.,'Etiquetas')]/following-sibling::div/span[2]"));
    public static final Target LIST_COLORS = Target.the("colors list to assign to the new category")
            .located(By.xpath("//div[@class='colors-container']/child::div"));

    public static final Target BTN_SAVE_NEW_CATEGORY = Target.the("button to complete and save the new category")
            .located(By.xpath("//button[contains(.,'Guardar')]"));

    public static final Target LABEL_CATEGORY_CREATED_SUCCESSFUL = Target.the("label that indicates the category was created successfully")
            .located(By.xpath("//div[@role='alertdialog']"));
}
