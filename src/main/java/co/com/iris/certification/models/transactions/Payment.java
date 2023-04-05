package co.com.iris.certification.models.transactions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends InfoTrx {
    private String payId;
    private String quantity;
    private String payValue;
    private String payType;
    private String createDate;
    private String executeDate;
    private String totalPaymentValue;
    private String paymentQuantityDelete;

    public Payment(String originAccountNumber, String payId, String tag, String quantity, String destinationBank,
                   String destinationAccountNumber, String payValue, String payType, String creationDate,String executeDate,
                   String totalPaymentValue, String emailUser, String paymentQuantityDelete) {
        super.setOriginAccountNumber(originAccountNumber);
        this.payId = payId;
        super.setTag(tag);
        this.quantity = quantity;
        super.setDestinationBank(destinationBank);
        super.setDestinationAccountNumber(destinationAccountNumber);
        this.payValue = payValue;
        this.payType = payType;
        this.createDate = creationDate;
        this.executeDate = executeDate;
        this.totalPaymentValue = totalPaymentValue;
        this.paymentQuantityDelete = paymentQuantityDelete;
        super.setEmailUser(emailUser);
    }
}
