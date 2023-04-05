package co.com.iris.certification.userinterfaces.transactions.registeredaccounts;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisteredAccountsDetailUI {
    public static final Target TEXT_ACCOUNT_HOLDER = Target.the("Label with the account holder's name").located(By.xpath("//div/small[contains(.,'Titular de la cuenta')]/following-sibling::h6"));
    public static final Target TEXT_DOCUMENT_TYPE = Target.the("Label with document type").located(By.xpath("//div/small[contains(.,'Tipo de documento')]/following-sibling::h6"));
    public static final Target TEXT_EMAIL = Target.the("Label with email").located(By.xpath("//div/small[contains(.,'Correo electrónico')]/following-sibling::h6"));
    public static final Target TEXT_EMAIL_EMPTY = Target.the("Label with empty email").located(By.xpath("//div/small[contains(.,'Correo electrónico')]/following-sibling::p"));
    public static final Target TEXT_NUMBER_DOCUMENT = Target.the("Label with number document").located(By.xpath("//div/small[contains(.,'Número de documento')]/following-sibling::h6"));
    public static final Target TEXT_DESTINATION_BANK = Target.the("Label with the name of the destination bank").located(By.xpath("//div/small[contains(.,'Banco destino')]/following-sibling::h6"));
    public static final Target TEXT_ACCOUNT_TYPE = Target.the("Label with account type").located(By.xpath("//div/small[contains(.,'Tipo de cuenta')]/following-sibling::h6"));
    public static final Target TEXT_ACCOUNT_NUMBER = Target.the("Label with account number").located(By.xpath("//div/small[contains(.,'Número de cuenta')]/following-sibling::h6"));
    public static final Target TEXT_ACCOUNT_DESCRIPTION = Target.the("Label with account description").located(By.xpath("//div/small[contains(.,'Descripción de la cuenta')]/following-sibling::h6"));
    public static final Target TEXT_ACCOUNT_DESCRIPTION_EMPTY = Target.the("Label with empty account description").located(By.xpath("//div/small[contains(.,'Descripción de la cuenta')]/following-sibling::p"));


    private RegisteredAccountsDetailUI(){}
}
