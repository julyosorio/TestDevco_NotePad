package co.com.iris.certification.tasks.irispay;

import co.com.iris.certification.interactions.SelectDate;
import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.interactions.SelectTag;
import co.com.iris.certification.models.irispay.BillingData;
import co.com.iris.certification.utils.SetData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static co.com.iris.certification.userinterfaces.SpinnerUI.LOADSCREEN_SPINNER;
import static co.com.iris.certification.userinterfaces.irispay.IrisPayUI.BTN_NEW_COLLECTION_LINK;
import static co.com.iris.certification.userinterfaces.irispay.NewBillingLinkFormUI.*;
import static co.com.iris.certification.userinterfaces.transactions.CalendarUI.*;
import static co.com.iris.certification.userinterfaces.transactions.PeriodicidadUI.CALENDAR_START_DATE;
import static co.com.iris.certification.utils.Constants.SEPARATOR_FORMAT_DATE;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class BillingLinkFromInvoice implements Task {
    private BillingData billingData;

    public BillingLinkFromInvoice(BillingData billingData) {
        this.billingData = billingData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                WaitUntil.the(BTN_NEW_COLLECTION_LINK, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_NEW_COLLECTION_LINK),
                WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                FileUpload.newFile(billingData.getFileName()+".xml", TEXT_LOAD_XML_FILE)
        );
        billingConcept(actor,billingData);
    }

    public static void billingConcept(Actor actor, BillingData billingData) {
        actor.attemptsTo(
                Enter.theValue(billingData.getBillingConcept()).into(TEXT_BILLING_CONCEPT)
        );
        addReference(actor, billingData);
    }

    public static void addReference(Actor actor, BillingData billingData) {
        if (billingData.getAddReference().equalsIgnoreCase("SI")) {
            actor.attemptsTo(
                    Click.on(LINK_OTHER_REFERENCE),
                    MoveMouse.to(LIST_REFERENCE_TWO),
                    Click.on(LIST_REFERENCE_TWO),
                    SelectOption.fromList(OPTLST_REFERENCE, billingData.getReference2())
            );
            numberReferenceTwo(actor, billingData);
        } else {
            enterTagAndDetail(actor, billingData);
        }
    }

    public static void numberReferenceTwo(Actor actor, BillingData billingData) {
        if (billingData.getWithOrWithoutReference2().equalsIgnoreCase("NO")) {
            actor.attemptsTo(
                    Click.on(RADIO_WITH_REFERENCE_TWO),
                    MoveMouse.to(TEXT_SECOND_REFERENCE_NUMBER),
                    Enter.theValue(billingData.getReferenceNumber2()).into(TEXT_SECOND_REFERENCE_NUMBER)
            );
        } else {
            actor.attemptsTo(
                    Click.on(RADIO_WITHOUT_REFERENCE_TWO)
            );
        }
        enterTagAndDetail(actor, billingData);
    }

    public static void enterTagAndDetail(Actor actor, BillingData billingData) {
        actor.attemptsTo(
                MoveMouse.to(LIST_TAG),
                Click.on(LIST_TAG),
                WaitUntil.the(OPTLST_TAG, isClickable()).forNoMoreThan(WAITING_TIME).seconds(),
                SelectTag.fromList(OPTLST_TAG, billingData.getTag()),
                MoveMouse.to(TEXT_BILLING_DETAIL),
                Clear.field(TEXT_BILLING_DETAIL),
                Enter.theValue(billingData.getBillingDetail()).into(TEXT_BILLING_DETAIL)
        );
        expirationDate(actor, billingData);
    }

    public static void expirationDate(Actor actor, BillingData billingData) {
        String[] expirationDateArray;
        actor.attemptsTo(
                Click.on(TEXT_EXPIRATION_DATE)
        );
        if (billingData.getExpirationDate() != null) {
            expirationDateArray = SetData.dateInDayMonthYearFormat(billingData.getExpirationDate(), SEPARATOR_FORMAT_DATE);
            String valueExpirationDate = VALUE_XPATH_DATE.replace("date", convertDate(expirationDateArray));
            VALUE_DATE = Target.the("field that contains the expiration date to select").located(By.xpath(valueExpirationDate));
            actor.attemptsTo(
                    SelectDate.toShceduleTransaction(CALENDAR_START_DATE, BTN_YEAR_DATE, CALENDAR_YEAR_DATE,
                            BTN_MONTH_DATE, CALENDAR_MONTH_DATE, VALUE_DATE,
                            SetData.convertMonth(expirationDateArray[1]), expirationDateArray[2]),
                    WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(BTN_CREATE_NEW_BILLING_LINK),
                    WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
            );
        } else {
            actor.attemptsTo(
                    Click.on(BTN_CREATE_NEW_BILLING_LINK),
                    WaitUntil.the(LOADSCREEN_SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds()
            );
        }
    }

    public static String convertDate(String date[]) {
        return SetData.convertDayAndMonth(date[0]).concat("/" + SetData.convertDayAndMonth(date[1])).concat("/" + date[2]);
    }

    public static BillingLinkFromInvoice createNew(BillingData billingData) {
        return Tasks.instrumented(BillingLinkFromInvoice.class, billingData);
    }
}
