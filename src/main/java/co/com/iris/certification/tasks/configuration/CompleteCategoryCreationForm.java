package co.com.iris.certification.tasks.configuration;

import co.com.iris.certification.interactions.SelectOption;
import co.com.iris.certification.models.configuration.Category;
import static co.com.iris.certification.userinterfaces.configuration.CreateCategoryUI.*;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.iris.certification.userinterfaces.configuration.CreateTagUI.*;
import static co.com.iris.certification.userinterfaces.configuration.TagDashboardUI.*;
import static co.com.iris.certification.userinterfaces.dashboard.DashboardUI.SPINNER;
import static co.com.iris.certification.utils.Constants.WAITING_TIME;
import static co.com.iris.certification.utils.SetData.convertStringToList;
import static co.com.iris.certification.utils.SetData.removeBlankSpacesInElementsOfList;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompleteCategoryCreationForm implements Task {

    private Category infoCategory;

    public CompleteCategoryCreationForm(Category infoCategory) {
        this.infoCategory = infoCategory;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_CREATE),
                WaitUntil.the(OPT_CREATE_CATEGORY, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(OPT_CREATE_CATEGORY),
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(WAITING_TIME).seconds(),
                Enter.theValue(infoCategory.getCategoryName()).into(TEXT_CATEGORY_NAME)
        );
        selectTags(actor);
        selectColor(actor, infoCategory.getNumberCategoryColor());
        completeCreationCategory(actor);
    }

    public void completeCreationCategory(Actor actor){
        actor.attemptsTo(
                WaitUntil.the(BTN_SAVE_NEW_CATEGORY, isVisible()).forNoMoreThan(WAITING_TIME).seconds(),
                Click.on(BTN_SAVE_NEW_CATEGORY),
                WaitUntil.the(SPINNER,isNotPresent()).forNoMoreThan(WAITING_TIME).seconds());
    }
    public void selectColor(Actor actor,String color){
        List<WebElementFacade> listColors = LIST_COLORS.resolveAllFor(actor);
        int i=0;
        while (i < listColors.size() ) {
            if(Integer.parseInt(color) == (i+1)){
                actor.attemptsTo(Click.on(listColors.get(i)));
                break;
            }
            i++;
        }
    }

    public void selectTags(Actor actor) {
        if(infoCategory.getTagsList()!= null) {
            List<String> listTagsFeature = removeBlankSpacesInElementsOfList(convertStringToList(infoCategory.getTagsList()));
            int i = 0;
            while (i < listTagsFeature.size()) {
                actor.attemptsTo(
                        Click.on(LIST_TAGS_TO_CATEGORY),
                        SelectOption.fromList(OPTLST_CATEGORIES_TO_ASSIGN_TAG, listTagsFeature.get(i)));
                Serenity.recordReportData().withTitle("A new tag was added in the list").andContents(" The tag selected was " + listTagsFeature.get(i));
                i++;
            }
            closeList(actor, LIST_TAGS_TO_CATEGORY, OPTLST_TAGS_TO_ASSIGN_TO_CATEGORY);
            validateListSelected(actor, LIST_TAGS_SELECTED, listTagsFeature.size());
        }
    }

    public static void validateListSelected(Actor actor, Target list,int sizeListFeature) {
        actor.attemptsTo(Ensure.that(list.resolveAllFor(actor).size()).isEqualTo(sizeListFeature));
    }

    public static void closeList(Actor actor, Target list, Target optList) {
        if (optList.isVisibleFor(actor)) {
            actor.attemptsTo(
                    Click.on(list)
            );
        }
    }
    public static CompleteCategoryCreationForm forCreateANewCategory(Category infoCategory) {
        return Tasks.instrumented(CompleteCategoryCreationForm.class, infoCategory);
    }
}
