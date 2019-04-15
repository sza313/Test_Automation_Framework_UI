package selenium.stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import selenium.pages.CheckboxPage;
import selenium.parallel.context.CucumberTestContext;

public class StepDef_CheckboxPage {
    private final static Logger LOG = LogManager.getLogger();
    private CheckboxPage checkboxPage;

    public StepDef_CheckboxPage(CucumberTestContext testContext) {
        checkboxPage = new CheckboxPage(testContext.getWebDriver());
        LOG.info("initialized.");
    }

    @When("I set the value of the '(.*)' checkbox to '(.*)' on the checkbox page")
    public void setCheckboxValue(String checkboxName, String checkboxValueToSet) {
        boolean toCheck = Boolean.valueOf(checkboxValueToSet);
        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, checkboxPage.clickCheckbox(checkboxName, toCheck));
    }

    @Then("The message '(.*)' shows up on the checkbox page")
    public void validateSuccessMessage(String message) {
        Assert.assertTrue("The expected message '" + message + "' did not show up.", checkboxPage.validateSuccessMessage(message));
    }

    @Then("The checkbox page opens")
    public void validateCheckboxPageOpens() {
        Assert.assertTrue("The title of the page is not correct.", checkboxPage.validateCheckboxPageTitle());
    }
}
