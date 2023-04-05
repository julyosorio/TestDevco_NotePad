package co.com.iris.certification.models.irispay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class BillingData {
    private String customerName;
    private String documentType;
    private String documentNumber;
    private String customerEmail;
    private String billingConcept;
    private String reference1;
    private String withOrWithoutReference1;
    private String referenceNumber1;
    private String addReference;
    private String reference2;
    private String withOrWithoutReference2;
    private String referenceNumber2;
    private String tag;
    private String billingDetail;
    private String totalValue;
    private String withOrWithoutIVA;
    private String expirationDate;
    private String fileName;
}
