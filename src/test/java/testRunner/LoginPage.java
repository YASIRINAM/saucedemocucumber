package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


@CucumberOptions(
		features  = {"src/test/java/features/Login.feature"},
		//dryRun =!true,
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		glue={"Steps","hooks"},
		plugin= {"pretty","html:target/CucumberReports.html"}
	

		)
public class LoginPage extends AbstractTestNGCucumberTests {
	

	

}
