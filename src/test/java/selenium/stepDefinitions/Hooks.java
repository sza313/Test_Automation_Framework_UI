package selenium.stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import selenium.parallel.context.CucumberTestContext;

public class Hooks {
    private final static Logger LOG = LogManager.getLogger();
    private CucumberTestContext testContext;

    public Hooks(CucumberTestContext testContext) {
        this.testContext = testContext;
        LOG.info("class initialized, Cucucumber test context set.");
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        LOG.info("Logging from scneario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        WebDriver driver = testContext.getWebDriver();
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        LOG.info("Attempting to close driver.");
        driver.quit();
    }

}
