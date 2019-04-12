package selenium.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import selenium.utils.DriverCreator;

public class Hooks extends DriverCreator {

    private static final Logger LOGGER = LogManager.getLogger();

    @Before
    public void beforeScenario() {
        LOGGER.info("Test is Starting...");
        createNewDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        LOGGER.info("Test is Ending...");
        driver.quit();
    }

}
