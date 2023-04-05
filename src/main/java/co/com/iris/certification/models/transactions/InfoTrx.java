package co.com.iris.certification.models.transactions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfoTrx {

    private String originAccountNumber;
    private String destinationBank;
    private String destinationAccountNumber;
    private String transferValue;
    private String description;
    private String tag;
    private String startTransactionDate;
    private String finalTransactionDate;
    private String periodicity;
    private String emailUser;
    private String ownerDestinationAccount;
    private String docTypeDestinationAccount;
    private String docNumDestinationAccount;
    private String destinationAccountType;
    private String requiresSaveSubscription;
    private String descriptionSubsAccount;
    private String emailSubsAccount;
    private String typeTransaction;

}
