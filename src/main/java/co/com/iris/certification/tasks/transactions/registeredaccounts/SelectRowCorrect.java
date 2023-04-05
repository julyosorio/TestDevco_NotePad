package co.com.iris.certification.tasks.transactions.registeredaccounts;

import co.com.iris.certification.models.transactions.InfoTrx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.transactions.registeredaccounts.RegisteredAccountsTableUI.*;
import static co.com.iris.certification.userinterfaces.transactions.voucher.SuccessfulVoucherUI.BTN_CLOSE_VOUCHER;
import static co.com.iris.certification.utils.Constants.OTHER_BANKS;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class SelectRowCorrect implements Task {

    private InfoTrx infoTrx;
    private String typeTransaction;


    public SelectRowCorrect(InfoTrx infoTrx, String typeTransaction) {
        this.infoTrx = infoTrx;
        this.typeTransaction = typeTransaction;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String textAccountHolder;
        String textDocumentNumber;
        String textTypeDocument;

        if (typeTransaction.equals(OTHER_BANKS)) {
            actor.attemptsTo(
                    Check.whether(COL_ACCOUNT_HOLDER.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains(infoTrx.getOwnerDestinationAccount()) &&
                            COL_DOCUMENT.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains(infoTrx.getDocNumDestinationAccount()) &&
                            COL_DOCUMENT_TYPE.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains(infoTrx.getDocTypeDestinationAccount()) &&
                            COL_BANK.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains(infoTrx.getDestinationBank()) &&
                            COL_REGISTERED_ACCOUNT.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains(infoTrx.getDestinationAccountNumber())
                    ).andIfSo(
                            WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                            MoveMouse.to(ROW_TABLE_REGISTERED_ACCOUNTS),
                            Scroll.to(ROW_TABLE_REGISTERED_ACCOUNTS),
                            Click.on(ROW_TABLE_REGISTERED_ACCOUNTS),
                            WaitUntil.the(BTN_CLOSE_VOUCHER, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))
                    )
            );
        } else {
            actor.attemptsTo(
                    Check.whether(
                                    COL_BANK.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains("Iris") &&
                                            COL_REGISTERED_ACCOUNT.resolveFor(OnStage.theActorInTheSpotlight()).getText().contains(infoTrx.getDestinationAccountNumber()))
                            .andIfSo(
                                    WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME)),
                                    MoveMouse.to(ROW_TABLE_REGISTERED_ACCOUNTS),
                                    Scroll.to(ROW_TABLE_REGISTERED_ACCOUNTS),
                                    Click.on(ROW_TABLE_REGISTERED_ACCOUNTS),
                                    WaitUntil.the(BTN_CLOSE_VOUCHER, isVisible()).forNoMoreThan(Duration.ofSeconds(WAITING_TIME))
                            )
            );
        }

        textAccountHolder =  COL_ACCOUNT_HOLDER.resolveFor(OnStage.theActorInTheSpotlight()).getText().replaceAll("\\R"+infoTrx.getEmailSubsAccount(),"");
        textTypeDocument = COL_DOCUMENT_TYPE.resolveFor(OnStage.theActorInTheSpotlight()).getText();
        textDocumentNumber =  COL_DOCUMENT.resolveFor(OnStage.theActorInTheSpotlight()).getText().replaceAll("\\R"+textTypeDocument,"");

        actor.remember("accountHolder", textAccountHolder);
        actor.remember("documentNumber", textDocumentNumber);
        actor.remember("typeDocument", textTypeDocument);
    }

    public static SelectRowCorrect registeredAccountsTable(InfoTrx infoTrx, String typeTransaction) {
        return Tasks.instrumented(SelectRowCorrect.class, infoTrx, typeTransaction);
    }
}
