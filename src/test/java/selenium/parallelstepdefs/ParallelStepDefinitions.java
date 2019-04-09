package selenium.parallelstepdefs;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParallelStepDefinitions {
    private final static Logger LOG = LogManager.getLogger();
    private WebDriver driver;
    private DriverController driverController = null;

    @Given("Open site in {string} with url {string}")
    public void openSiteInBrowserOnUrl(String browserType, String url) {
        LOG.info("Starting test.");
        driverController = new DriverController();
        driverController.initializeWebDriver(browserType);
        driver = driverController.getWebDriver();
        driver.get(url);
    }

    @When("I search for {string}")
    public void iSearchForHammer(String query) {
        LOG.info("Interaction on site.");
        driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys(query);
        driver.findElement(By.cssSelector("input[name='btnK']")).submit();
    }

    @Then("search result page is displayed")
    public void searchResultPageIsDisplayed() {
        Assert.assertTrue("Search result page is displayed.", driver.getCurrentUrl().contains("search"));
    }

    @Then("search result page is NOT displayed")
    public void searchResultPageIsNotDisplayed() {
        Assert.fail();
    }

    @After
    public void afterScenario() {
        driverController.cleanUpWebDriver();
    }

}
