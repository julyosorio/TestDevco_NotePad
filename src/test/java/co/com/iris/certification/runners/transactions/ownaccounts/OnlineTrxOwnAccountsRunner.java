package co.com.iris.certification.runners.transactions.ownaccounts;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue= "co.com.iris.certification.stepdefinitions",
        features = "src/test/resources/features/OnlineTrxOwnAccounts.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class OnlineTrxOwnAccountsRunner {
}
