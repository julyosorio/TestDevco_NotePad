package co.com.iris.certification.userinterfaces.transactions;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SubscribedAccountOtherBankUI {

    public static final Target TEXT_OWNER_ACCOUNT = Target.the("field to enter the owner account to be suscribe").located(By.xpath("//input[@formcontrolname='accountOwner']"));
    public static final Target TEXT_EMAIL_SUBSCRIBED_ACCOUNT_OTHER_BANKS = Target.the("field to enter email of account to be subscribed").located(By.xpath("//input[@formcontrolname='email']"));
    public static final Target LIST_DOCUMENT_TYPE = Target.the("field to show the document type options to suscribe account").located(By.xpath("//ng-select[@formcontrolname='documentType']/div"));
    public static final Target OPTLST_DOCUMENT_TYPE = Target.the("field to list the document type options to suscribe account").located(By.xpath("//div[contains(@class,'ng-dropdown')]/div/div/span"));
    public static final Target TEXT_DOCUMENT_NUMBER = Target.the("field to enter document number to suscribe account").located(By.xpath("//input[@formcontrolname='documentNumber']"));
    public static final Target LIST_BANK = Target.the("field to show the bank options to suscribe account").located(By.xpath("//ng-select[@formcontrolname='bank']"));
    public static final Target OPTLST_BANK = Target.the("field to list the bank options to suscribe account").located(By.xpath("//div[@role='option']/span"));
    public static final Target LIST_ACCOUNT_TYPE = Target.the("field to show account type options to suscribe account").located(By.xpath("//ng-select[@formcontrolname='accountType']/div"));
    public static final Target OPTLST_ACCOUNT_TYPE = Target.the("field to list the account type options to suscribe account").located(By.xpath("//div[@role='option']/span"));
    public static final Target TEXT_ACCOUNT_NUMBER_OTHER_BANKS = Target.the("field to enter account number").located(By.xpath("//input[@formcontrolname='accountNumber']"));
    public static final Target TEXT_DESCRIPTION_SUBSCRIBED_ACCOUNT_OTHER_BANKS = Target.the("field to enter account description of account to be subscribed").located(By.id("details"));
    public static final Target RADIO_SAVE_SUSCRIBED_ACCOUNT = Target.the("option to indicate that must to save the information account's entered in this form as a suscribed account").located(By.xpath("(//span[@class='c-switch-slider'])[1]"));
    public static final Target BTN_COMPLETE_SUBSCRIPTION_ACCOUNT_OTHER_BANKS = Target.the("button to save the information of a new destination account").located(By.xpath("//button[@type='submit']"));

    public static final Target RADIO_NOTIFICATION = Target.the("button to enable sending of transfer notifications from the registered account").located(By.xpath("//span[@class='c-switch-slider']"));
    public static final Target LABEL_POP_UP_MESSAGE_TITLE_OTHER_BANKS = Target.the("Text in the pop-up with the title of the message").located(By.xpath("//div[@class='ng-tns-c14-0 toast-title ng-star-inserted']"));
    public static final Target LABEL_POP_UP_MESSAGE_BODY_OTHER_BANKS = Target.the("Text in the pop-up with the body of the message").located(By.xpath("//div[@role='alertdialog']"));
    private SubscribedAccountOtherBankUI() {
    }
}
