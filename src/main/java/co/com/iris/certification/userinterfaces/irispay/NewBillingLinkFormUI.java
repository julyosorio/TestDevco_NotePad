package co.com.iris.certification.userinterfaces.irispay;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class NewBillingLinkFormUI {

    public static final Target BTN_LOAD_XML_FILE =Target.the("button to upload xml file corresponding to invoice")
            .located(By.xpath("//ngx-dropzone-label[@class='row ng-star-inserted']//span[contains(.,'Carga')]"));

    public static final Target TEXT_LOAD_XML_FILE =Target.the("Field to upload xml file corresponding to invoice")
            .located(By.xpath("//input[@type='file']"));
    public static final Target TEXT_CUSTOMER_NAME = Target.the("Field to enter the name of the customer to whom the collection link will be generated.")
            .located(By.xpath("//input[@formcontrolname='customerName']"));
    public static final Target LIST_DOCUMENT_TYPE = Target.the("Field that with the list of document types to select")
            .located(By.xpath("//ng-select[@formcontrolname='customerDocumentType']"));
    public static final Target OPTLST_DOCUMENT_TYPE = Target.the("Document types list options")
            .located(By.xpath("//div[@role='option']"));
    public static final Target TEXT_DOCUMENT_NUMBER = Target.the("Field to enter the document number")
            .located(By.xpath("//input[@formcontrolname='customerDocumentNumber']"));
    public static final Target TEXT_CUSTOMER_EMAIL= Target.the("")
            .located(By.xpath("//input[@type='email']"));
    public static final Target TEXT_BILLING_CONCEPT = Target.the("Field to enter the billing concept")
            .located(By.xpath("//input[@formcontrolname='collectionReason']"));
    public static final Target LIST_REFERENCE_ONE = Target.the("Field with the list of existing billing references")
            .located(By.xpath("(//div[@class='row']/div/ng-select[@formcontrolname='name'])[1]"));
    public static final Target OPTLST_REFERENCE = Target.the("Option with billing references")
            .located(By.xpath("//div[@role='option']"));
    public static final Target RADIO_WITHOUT_REFERENCE_ONE = Target.the("select enter reference number")
            .located(By.xpath("(//input[@type='radio'][@id='flexRadioDefault1'])[1]"));
    public static final Target RADIO_WITH_REFERENCE_ONE = Target.the("do not enter reference number")
            .located(By.xpath("(//input[@type='radio'][@id='flexRadioDefault2'])[1]"));
    public static final Target TEXT_FIRST_REFERENCE_NUMBER = Target.the("Field to enter number of the first reference")
            .located(By.xpath("(//input[@formcontrolname='value'])[1]"));
    public static final Target LINK_OTHER_REFERENCE = Target.the("Link to add a reference")
            .located(By.xpath("//a/span[contains(.,'Usar otra referencia')]"));
    public static final Target LIST_REFERENCE_TWO = Target.the("Field with the list of existing billing references")
            .located(By.xpath("(//form/div[@class='row']//ng-select[@formcontrolname='name'])[2]"));
    public static final Target RADIO_WITHOUT_REFERENCE_TWO = Target.the("selection without reference number")
            .located(By.xpath("(//input[@type='radio'][@id='flexRadioDefault1'])[2]"));
    public static final Target RADIO_WITH_REFERENCE_TWO = Target.the("selection with reference number")
            .located(By.xpath("(//input[@type='radio'][@id='flexRadioDefault2'])[2]"));
    public static final Target TEXT_SECOND_REFERENCE_NUMBER = Target.the("Field to enter number of the second reference")
            .located(By.xpath("(//input[@formcontrolname='value'])[2]"));

    public static final Target LIST_TAG = Target.the("Field with the list of existing tags")
            .located(By.xpath("//ng-select[@formcontrolname='tagId']"));
    public static final Target OPTLST_TAG = Target.the("select a tag from the dropdown list")
            .located(By.xpath("//iris-component-tag[@class='ng-star-inserted']/div[@class='tag']/span"));
    public static final Target TEXT_BILLING_DETAIL = Target.the("Field to enter the billing detail")
            .located(By.xpath("//div/label[contains(.,'Detalle del cobro')]//following-sibling::textarea[@id='paymentDetails']"));
    public static final Target TEXT_TOTAL_VALUE = Target.the("field to enter the total gross value of the billing")
            .located(By.xpath("//input[@formcontrolname='totalGrossValue']"));
    public static final Target RADIO_APPLY_IVA = Target.the("Selection to apply IVA")
            .located(By.xpath("//input[@id='flexRadioApplyIva1']"));
    public static final Target RADIO_NOT_APPLY_IVA = Target.the("Selection to Not apply IVA")
            .located(By.xpath("//input[@id='flexRadioApplyIva0']"));
    public static final Target LABEL_TOTAL_VALUE = Target.the("text with the total value of the billing")
            .located(By.xpath("//input[@id='totalValue']"));
    public static final Target TEXT_EXPIRATION_DATE = Target.the("field to select expiration date")
            .located(By.xpath("//input[@placeholder='Seleccionar fecha']"));
    public static Target VALUE_EXPIRATION_DATE = null;
    public static final Target BTN_CREATE_NEW_BILLING_LINK = Target.the("button to create and save the new billing link")
            .located(By.xpath("//button[@type='submit'][contains(.,'Crear')]"));

    public NewBillingLinkFormUI(){

    }
}
