package co.com.iris.certification.userinterfaces.usermanagement.users;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateNewUserUI {

    public static final Target TEXT_NAME_USER = Target.the("field to enter the name user")
            .located(By.xpath("//input[@formcontrolname='name']"));
    public static final Target TEXT_LASTNAME_USER = Target.the("field to enter the lastname user")
            .located(By.xpath("//input[@formcontrolname='lastName']"));
    public static final Target LIST_DOCUMENT_TYPE = Target.the("field to open the list the document types avaliable")
            .located(By.xpath("//ng-select[@formcontrolname='documentType']"));
    public static final Target OPTLST_DOCUMENT_TYPE = Target.the("field to show the values avaliables for document types")
            .located(By.xpath("//div[@role='option']"));
    public static final Target TEXT_DOCUMENT_NUMBER = Target.the("field to enter the document number")
            .located(By.xpath("//input[@formcontrolname='documentId']"));
    public static final Target TEXT_CELLPHONE = Target.the("text to enter the cellphone")
            .located(By.xpath("//input[@formcontrolname='phoneNumber']"));

    public static final Target TEXT_EMAIL = Target.the("field to enter the email user")
            .located(By.xpath("//input[@formcontrolname='email']"));

    public static final Target LIST_ROLE = Target.the("field to open the roles list")
            .located(By.xpath("//ng-select[@formcontrolname='role']"));

    public static final Target OPTLST_ROLE = Target.the("field to show values avaliable for role")
            .located(By.xpath("//div[@role='option']"));

    public static final Target BTN_CREATE_USER = Target.the("button to create the user")
            .located(By.xpath("(//button[contains(text(),'Crear')])[2]"));

    public static final Target LABEL_MESSAGE = Target.the("label with the message in the user form")
            .located(By.xpath("//div[@role='alertdialog']"));

    public static final Target LABEL_MESSAGE_DOCUMENT_WAS_USED = Target.the("label with message that indicates that the document entered already was used")
            .located(By.xpath("//div[contains(text(),'Ya hay un usuario con el mismo documento')]"));

    public static final Target LABEL_MESSAGE_NAME_WAS_USED = Target.the("label with message that indicates that the name entered already was used")
            .located(By.xpath("//div[contains(text(),'Ya hay un usuario con el mismo nombre')]"));

    public static final Target LABEL_MESSAGE_EMAIL_WAS_USED = Target.the("label with message that indicates that the email entered already was used")
            .located(By.xpath("//div[contains(text(),'Ya hay un usuario con el mismo correo electrónico')]"));

    public static final Target BTN_CLOSE_FORM = Target.the("button to session close")
            .located(By.xpath("//a[contains(@class,'close-drawer')]"));

    private CreateNewUserUI(){

    }
}
