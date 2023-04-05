package co.com.iris.certification.userinterfaces.transactions.registeredaccounts;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisteredAccountsTableUI {

    public static final Target ROW_TABLE_REGISTERED_ACCOUNTS = Target.the("row of the table registered accounts")
            .located(By.xpath("//table/tbody/tr"));
    public static final Target COL_TITLE_DOCUMENT = Target.the("")
            .located(By.xpath("//div/table/thead/tr/th[contains(text(),' Documento')]"));
    public static final Target COL_ACCOUNT_HOLDER = Target.the("column with the name of the account holder")
            .located(By.xpath("//table/tbody/tr/td[1]"));
    public static final Target COL_ACCOUNT_HOLDER_EMAIL = Target.the("account holder columna text with email")
            .located(By.xpath("//table/tbody/tr/td[1]/span"));
    public static final Target COL_DOCUMENT = Target.the("column with the number of the identification document")
            .located(By.xpath("//table/tbody/tr/td[2]"));
    public static final Target COL_DOCUMENT_TYPE = Target.the("column with the type of the document")
            .located(By.xpath("//table/tbody/tr/td[2]/span"));
    public static final Target COL_BANK = Target.the("column with name of bank")
            .located(By.xpath("//table/tbody/tr/td[3]"));
    public static final Target COL_REGISTERED_ACCOUNT = Target.the("column with number of registered account")
            .located(By.xpath("//table/tbody/tr/td[4]"));
    public static final Target COL_TYPE_ACCOUNT = Target.the("column with type of registered account")
            .located(By.xpath("//table/tbody/tr/td[4]/span"));
    public static final Target COL_DESCRIPTION = Target.the("column with the description of registered account")
            .located(By.xpath("//table/tbody/tr/td[5]"));
    public static final Target COL_REGISTRATION_STATUS = Target.the("column with the status of account registration")
            .located(By.xpath("//table/tbody/tr/td[6]"));

    public static final Target BTN_DELETE = Target.the("Button for delete a registered account")
            .located(By.xpath("//button[contains(text(),' Eliminar cuenta')]"));
    public static final Target BTN_POP_UP_DELETE = Target.the("Button to delete a registered account from the pop up")
            .located(By.xpath("//button[@type='button'][contains(text(),'Eliminar')]"));

    public static final Target BTN_UPDATE = Target.the("Button for update a registered account")
            .located(By.xpath("//button[contains(text(),'Actualizar datos')]"));

    public static final Target TEXT_EMAIL_UPDATE = Target.the("Field to enter the email address")
            .located(By.xpath("//div/label[contains(text(),'Correo electrónico')]//following-sibling::input[@formcontrolname='email']"));

    public static final Target TEXT_DESCRIPTION_UPDATE = Target.the("Field to enter the description")
            .located(By.xpath("//div/label[contains(text(),'Descripción')]//following-sibling::input[@formcontrolname='details']"));
    public static final Target RADIO_NOTIFICATION = Target.the("Check box to enable account notifications")
            .located(By.xpath("//span[@class='c-switch-slider']"));
    public static final Target BTN_COMPLETE = Target.the("button to complete the update of the registered account")
            .located(By.xpath("//button[contains(.,'Finalizar')]"));
    public static final Target TEXT_POP_UP = Target.the("Button to delete a registered account from the pop up")
            .located(By.xpath("//div[@role='alertdialog'][@class='ng-tns-c14-0 toast-message ng-star-inserted']"));


    private RegisteredAccountsTableUI(){

    }
}
