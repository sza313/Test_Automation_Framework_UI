package selenium.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cucumber.api.java.en.When;
import selenium.pages.PhpTravelPage;
import selenium.parallel.context.CucumberTestContext;

public class StepDef_PhpTravelPage {
    private final static Logger LOG = LogManager.getLogger();
    private PhpTravelPage phpTravelPage;

    public StepDef_PhpTravelPage(CucumberTestContext testContext) {
        phpTravelPage = new PhpTravelPage(testContext.getWebDriver());
        LOG.info("initialized.");
    }

    @When("Click to '(.*)' menu item on PhpTravels$")
    public void clickToMenuItem(String menuName) {
        phpTravelPage.clickToMenuItem(menuName);
    }

    @When("Click to '(.*)' submenu item on PhpTravels$")
    public void clickToSubmenuItem(String submenuName) {
        phpTravelPage.clickToSubmenuItem(submenuName);
    }
}
