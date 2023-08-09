package automationteststore.TestNGRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber->  TestNG, junit

@CucumberOptions(features="src/test/java/automationteststore/features",
        glue="automationteststore.stepDefinitions",
        monochrome=true,
        //tags = "@AccountRegistration",
        //tags = "@RegistrationFunctionality",
        //tags = "@Login",
        //tags = "@BrowserTabs",
        //tags = "@LoginPositive",
        tags = "@Homepage_E2E",
        //tags = "Search_E2E",
        plugin= {"html:target/cucumber.html"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests{
   /*@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		return super.scenarios();
	}*/
	
}
