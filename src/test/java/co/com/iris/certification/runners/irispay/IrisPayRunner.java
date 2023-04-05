package co.com.iris.certification.runners.irispay;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/IrisPay.feature",
        glue = "co.com.iris.certification.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class IrisPayRunner {
}

