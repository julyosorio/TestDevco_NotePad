package co.com.iris.certification.tasks.configuration;

import co.com.iris.certification.exceptions.TagNameUsedBefore;
import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.configuration.Tag;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static co.com.iris.certification.userinterfaces.configuration.CreateTagUI.*;
import static co.com.iris.certification.userinterfaces.configuration.TagDashboardUI.BTN_CREATE;
import static co.com.iris.certification.userinterfaces.configuration.TagDashboardUI.OPT_CREATE_TAG;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.SPINNER;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static co.com.iris.certification.utils.SetData.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class CompleteTagCreationForm implements Task {
    private Tag infoTag;

    public CompleteTagCreationForm(Tag infoTag) {
        this.infoTag = infoTag;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_CREATE),
                WaitUntil.the(OPT_CREATE_TAG, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(OPT_CREATE_TAG),
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Enter.theValue(infoTag.getTagName()).into(TEXT_TAG_NAME));
        selectUsers(actor);
        selectOperationsToTheTag(actor, infoTag);
        selectCategory(actor, infoTag);
        completeTagCreation(actor);
    }

    public void completeTagCreation(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_SAVE_NEW_TAG, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_SAVE_NEW_TAG)
        );
        actor.should(seeThat(the(LABEL_TAG_ALREADY_EXISTING), isNotPresent())
                .orComplainWith(TagNameUsedBefore.class, "The tag name already was used"));
    }

    public void selectUsers(Actor actor) {
        if (infoTag.getUsersList() != null) {
            List<String> listUsersFeature = removeBlankSpacesInElementsOfList(convertStringToList(infoTag.getUsersList()));
            int i = 0;
            while (i < listUsersFeature.size()) {
                actor.attemptsTo(
                        Click.on(LIST_USERS_TO_ASSIGN_TAG),
                        SelectOption.fromList(OPTLST_USERS_TO_ASSIGN_TAG, listUsersFeature.get(i)));
                Serenity.recordReportData().withTitle("A new user was added in the list");
                i++;
            }
            closeList(actor, LIST_USERS_TO_ASSIGN_TAG, OPTLST_USERS_TO_ASSIGN_TAG);
            validateListSelected(actor, LIST_USERS_SELECTED, listUsersFeature.size());
        }
    }


    public static void selectOperationsToTheTag(Actor actor, Tag infoTag) {
        if (infoTag.getTypeOperationList() != null) {
            List<String> listOperationsFeature = removeBlankSpacesInElementsOfList(convertStringToList(infoTag.getTypeOperationList()));
            Map<Integer, String> mapFeature = convertListToMap(listOperationsFeature);
                showList(actor, LIST_TYPES_OPERATION_TO_ASSIGN_TAG, OPTLST_TYPES_OPERATION_TO_ASSIGN_TAG);
                List<WebElementFacade> listOperation = OPTLST_TYPES_OPERATION_TO_ASSIGN_TAG.resolveAllFor(actor);
                int i = 0;
                while (i < listOperation.size()) {
                    if (mapFeature.containsValue(listOperation.get(i).getText().toLowerCase())) {
                        actor.attemptsTo(
                                MoveMouse.to(listOperation.get(i)),
                                Click.on(listOperation.get(i)));
                        Serenity.recordReportData().withTitle("A new operation was added in the list");
                    }
                    showList(actor, LIST_TYPES_OPERATION_TO_ASSIGN_TAG, OPTLST_TYPES_OPERATION_TO_ASSIGN_TAG);
                    i++;
                    listOperation = OPTLST_TYPES_OPERATION_TO_ASSIGN_TAG.resolveAllFor(actor);
                }
                closeList(actor, LIST_TYPES_OPERATION_TO_ASSIGN_TAG, OPTLST_TYPES_OPERATION_TO_ASSIGN_TAG);
                validateListSelected(actor, LIST_OPERATIONS_SELECTED, listOperationsFeature.size());

        }
    }

    public static void selectCategory(Actor actor, Tag infoTag) {
        actor.attemptsTo(
                WaitUntil.the(LIST_CATEGORIES, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(LIST_CATEGORIES),
                SelectOption.fromList(OPTLST_CATEGORIES_TO_ASSIGN_TAG, infoTag.getCategory())
        );
    }

    public static void validateListSelected(Actor actor, Target list, int sizeListFeature) {
        actor.attemptsTo(Ensure.that(list.resolveAllFor(actor).size()).isEqualTo(sizeListFeature));
    }

    public static void closeList(Actor actor, Target list, Target optList) {
        if (optList.isVisibleFor(actor)) {
            actor.attemptsTo(
                    Click.on(list)
            );
        }
    }

    public static void showList(Actor actor, Target list, Target optList) {
        while (!optList.isVisibleFor(actor)) {
            actor.attemptsTo(
                    WaitUntil.the(list, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                    Click.on(list)
            );
        }
    }

    public static CompleteTagCreationForm forCreateANewTag(Tag infoTag) {
        return Tasks.instrumented(CompleteTagCreationForm.class, infoTag);
    }
}
