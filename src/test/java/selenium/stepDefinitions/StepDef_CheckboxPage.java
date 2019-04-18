package selenium.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
        checkboxPage.clickCheckbox(checkboxName, checkboxValueToSet);
    }

    @Then("The message '(.*)' shows up on the checkbox page")
    public void validateSuccessMessage(String message) {
        checkboxPage.validateSuccessMessage(message);
    }

    @Then("The checkbox page opens")
    public void validateCheckboxPageOpens() {
        checkboxPage.validateCheckboxPageTitle();
    }
}
