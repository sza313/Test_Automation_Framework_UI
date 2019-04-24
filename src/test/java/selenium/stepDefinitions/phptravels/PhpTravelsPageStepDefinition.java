package selenium.stepDefinitions.phptravels;

import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import selenium.pages.phptravels.PhpTravelsPage;
import selenium.parallel.context.CucumberTestContext;

@Deprecated
public class PhpTravelsPageStepDefinition {
    private final static Logger LOG = LogManager.getLogger();
    private PhpTravelsPage phpTravelPage;

    public PhpTravelsPageStepDefinition(CucumberTestContext testContext) {
        phpTravelPage = new PhpTravelsPage(testContext.getWebDriver());
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
