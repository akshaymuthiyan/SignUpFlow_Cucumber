package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/Features",  
    glue = "stepDefinitions",
    monochrome = true,
    plugin = {"pretty", "html:target/cucumber.html"}
)
public class TestRun {
}
