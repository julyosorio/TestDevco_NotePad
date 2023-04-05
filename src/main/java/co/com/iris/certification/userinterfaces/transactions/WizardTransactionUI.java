package co.com.iris.certification.userinterfaces.transactions;

import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.xpath;

public class WizardTransactionUI {
    public static final Target LABEL_ACCOUNT_ORIGIN_LEFT_PANEL = Target.the("label that show the number account origin in the left panel")
            .located(xpath("//label[contains(text(),'origen')]//following-sibling::label"));
    public static final Target LABEL_ACCOUNT_DESTINATION_LEFT_PANEL = Target.the("label that show the number account destination in the left panel")
            .located(xpath("//label[contains(text(),'destino')]//following-sibling::label"));
    public static final Target LABEL_TRANSFER_VALUE_LEFT_PANEL = Target.the("label that show in left panel the transfer value entered before")
            .located(xpath("//label[contains(text(),'Valor')]//following-sibling::p/label"));
    public static final Target LABEL_EXECUTION_DATE_LEFT_PANEL = Target.the("label that show in left panel the execution date of transaction selected before")
            .located(xpath("//label[contains(text(),'ejecución')]//following-sibling::label"));
    public static final Target LABEL_FINAL_DATE_LEFT_PANEL = Target.the("label that show in left panel the final date of transaction, apply only for scheduled transactions")
            .located(xpath("//label[contains(text(),'final')]//following-sibling::label"));
    public static final Target LABEL_PERIODICITY_LEFT_PANEL = Target.the("label that show in left panel the periodicity selected for transaction")
            .located(xpath("//label[contains(text(),'Periodicidad')]//following-sibling::label"));
    public static final Target LABEL_TAG_LEFT_PANEL = Target.the("label that show in left panel the tag asociated for transaction")
            .located(xpath("//label[contains(text(),'Etiqueta')]//following-sibling::label"));
    public static final Target LABEL_DESCRIPTION_LEFT_PANEL = Target.the("label that show in left panel the description entered for transaction")
            .located(xpath("//label[contains(text(),'Descripción')]//following-sibling::label"));
    private WizardTransactionUI(){}
}
