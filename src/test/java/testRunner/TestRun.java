package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/Features",  // Make sure the path to your feature files is correct
    glue = "stepDefinitions",  // Ensure this points to the correct package for step definitions
    monochrome = true,
    plugin = {"pretty", "html:target/cucumber.html"}
)
public class TestRun {
}