package selenium.stepDefinitions.phptravels;

import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import selenium.pages.phptravels.PhpLoginPage;
import selenium.parallel.context.CucumberTestContext;

@Deprecated
public class PhpTravelsLoginPageStepDefinition {
    private final static Logger LOG = LogManager.getLogger();
    private PhpLoginPage phpLoginPage;

    public PhpTravelsLoginPageStepDefinition(CucumberTestContext testContext) {
        phpLoginPage = new PhpLoginPage(testContext.getWebDriver());
        LOG.info("initialized.");
    }

    @When("Login to the PhpTravels page$")
    public void loginToPhpTravelPage() {
        phpLoginPage.enterLoginCredentialAndClickLogin();
    }

    @When("Wait for My Account page is loaded$")
    public void waitForPageLoading() {
        phpLoginPage.validatePageLoading();
    }

}
