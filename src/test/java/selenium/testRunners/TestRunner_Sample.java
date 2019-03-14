package selenium.testRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "selenium/stepDefinitions",
        plugin = { "pretty", "html:target/test_result/html-result","json:target/test_result/test-report.json","junit:target/test_result/result.xml" },
        tags = {"@DeleteOnSampleForm"},
        monochrome = true)
public class TestRunner_Sample {

}