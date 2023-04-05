package co.com.iris.certification.runners.payments;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "co.com.iris.certification.stepdefinitions",
        features = "src/test/resources/features/OnlineSupplierPayIrisAccounts.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class OnlineSupplierPayIrisAccountsRunner {
}
