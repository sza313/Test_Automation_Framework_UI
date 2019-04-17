package selenium.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cucumber.api.java.en.When;
import selenium.pages.PhpLoginPage;
import selenium.parallel.context.CucumberTestContext;

public class StepDef_PhpLoginPage {
    private final static Logger LOG = LogManager.getLogger();
    private PhpLoginPage phpLoginPage;

    public StepDef_PhpLoginPage(CucumberTestContext testContext) {
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
