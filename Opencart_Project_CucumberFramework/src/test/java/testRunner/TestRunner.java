package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		//features=".//Features//Registration.feature",
		features= {".//Features/LoginWithDDT.feature"},
		//features= {".//Features/LoginDDTWithExcel.feature"},
		glue="stepDefination",
		//features="@target/rerun.txt",
		plugin= {
				"pretty",
				"html:Reports/htmlReport.html",
				"rerun:target/rerun.txt",
		        },	
		dryRun=false,
		monochrome=true
		
		)

public class TestRunner {

}
