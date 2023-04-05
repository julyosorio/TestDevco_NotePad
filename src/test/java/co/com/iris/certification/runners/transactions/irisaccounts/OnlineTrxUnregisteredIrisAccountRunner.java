package co.com.iris.certification.runners.transactions.irisaccounts;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue= "co.com.iris.certification.stepdefinitions",
        features = "src/test/resources/features/OnlineTrxUnregisteredIrisAccount.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class OnlineTrxUnregisteredIrisAccountRunner {
}
