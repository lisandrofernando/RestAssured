package cucumber.Options;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="Tests/features", glue= {"stepDefinitions"}, tags ="not @ignore", plugin ="json:target/jsonReports/cucumber-report.json")
public class TestRunner {

}
