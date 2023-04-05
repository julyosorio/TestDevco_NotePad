package co.com.iris.certification.userinterfaces.usermanagement.users;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserDetailUI {

    public static final Target LABEL_EDIT_USER = Target.the("Link to edit user data")
            .located(By.xpath("//div[@class='d-none d-md-table-cell px-3 align-self-center']/h6[@type='button'][contains(.,'Editar')]"));
    public static final Target TEXT_PHONE_CHANGED = Target.the("Field to enter the new cell phone number")
            .located(By.xpath("//label[@for='user-phonenumber'][contains(.,'Celular')]//following-sibling::input[@type='tel']"));
    public static final Target TEXT_EMAIL_CHANGED = Target.the("Field to enter the new e-mail address")
            .located(By.xpath("//label[@for='user-phonenumber'][contains(.,'Correo electrónico*')]//following-sibling::input[@type='email']"));
    public static final Target LIST_ROL_CHANGED = Target.the("drop-down list to select new Role")
            .located(By.xpath("//div/label[contains(.,'Rol')]//following-sibling::ng-select"));
    public static final Target OPTLST_ROL_CHANGED = Target.the("options to select new Role")
            .located(By.xpath("//div[@role='option']"));
    public static final Target BTN_SAVE_CHANGES = Target.the("")
            .located(By.xpath("//div[@class='row buttons mobileOrder1']/div/button[@type='submit'][contains(.,'Guardar')]"));

    public static final Target LABEL_FINAL_MESSAGE = Target.the("Final message when saving new user data")
            .located(By.xpath("//div[@class='ng-tns-c14-1 toast-title ng-star-inserted']"));

    private UserDetailUI() {
    }

}
