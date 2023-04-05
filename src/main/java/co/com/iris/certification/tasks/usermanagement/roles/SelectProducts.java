package co.com.iris.certification.tasks.usermanagement.roles;

import co.com.iris.certification.models.roles.InfoRole;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;
import java.util.Map;

import static co.com.iris.certification.userinterfaces.usermanagement.roles.ProductsAndComplementsUI.LIST_PRODUCTS_FOR_ASSOCIATES_TO_THE_ROLE;
import static co.com.iris.certification.utils.SetData.*;

public class SelectProducts implements Task {

    private InfoRole infoRole;

    public SelectProducts(InfoRole infoRole){
        this.infoRole = infoRole;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> listProducts = LIST_PRODUCTS_FOR_ASSOCIATES_TO_THE_ROLE.resolveAllFor(actor);

        List<String> listProductsFeature = removeBlankSpacesInElementsOfList(convertStringToList(infoRole.getProductsList()));
        Map<Integer,String> mapFeature = convertListToMap(listProductsFeature);

        if(!listProductsFeature.isEmpty()){
            for (WebElementFacade product:listProducts) {
                if(mapFeature.containsValue(product.getText().replace("*", ""))){
                    actor.attemptsTo(Click.on(product));
                    Serenity.recordReportData().withTitle("A new product was selected").andContents(product.getText());
                }
            }
        }
    }

    public static SelectProducts forNewRole(InfoRole infoRole){
        return Tasks.instrumented(SelectProducts.class, infoRole);
    }
}
