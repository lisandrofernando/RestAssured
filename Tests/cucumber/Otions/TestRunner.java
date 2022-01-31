package cucumber.Otions;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="Tests/features", glue= {"stepDefinitions"}, tags ="@DeletePlace", plugin ="json:target/jsonReports/cucumber-report.json")
public class TestRunner {

}
