package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Cucumber",glue="EcomerceAppliaction.Stepdefinition",monochrome = true,tags = "@Regression",plugin = {"html:target/cucumberReport.html"})
public class TestNgTestRunner extends AbstractTestNGCucumberTests

{

	
}
