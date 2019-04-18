package selenium.stepDefinitions.phptravels;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cucumber.api.java.en.When;
import selenium.parallel.context.CucumberTestContext;

public class PhpTravelsPage {
    private final static Logger LOG = LogManager.getLogger();
    private selenium.pages.phptravels.PhpTravelsPage phpTravelPage;

    public PhpTravelsPage(CucumberTestContext testContext) {
        phpTravelPage = new selenium.pages.phptravels.PhpTravelsPage(testContext.getWebDriver());
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
