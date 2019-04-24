package selenium.stepDefinitions.seleniumeasy;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import selenium.pages.seleniumeasy.BootstrapDatePickerPage;
import selenium.parallel.context.CucumberTestContext;

public class BootstrapDatePickerPageStepDefinition {
    private final static Logger LOG = LogManager.getLogger();
    private BootstrapDatePickerPage bootstrapDatePickerPage;

    public BootstrapDatePickerPageStepDefinition(CucumberTestContext testContext) {
        bootstrapDatePickerPage = new BootstrapDatePickerPage(testContext.getWebDriver());
        LOG.info("initilized.");
    }

    @Then("The bootstrap date picker page opens and title is '(.+)'")
    public void validateBootstrapDatePickerPageOpens(String title) {
        bootstrapDatePickerPage.validateBootstrapDatePickerPageTitle(title);
    }

    @When("I click on the '(.*)' input field in the date range example section")
    public void clickOnSelectStartDate(String datePickerName) {
        bootstrapDatePickerPage.clickOnSelectDate(datePickerName);
    }

    @When("I select the date '(.*)' from dropdown")
    public void selectDateFromDropdown(String dateString) {
        bootstrapDatePickerPage.selectStartDateFromDropdown(dateString);
    }

    @Then("'(.*)' appears in the start date input field")
    public void validateCorrectStartDateAppears(String dateString) {
        bootstrapDatePickerPage.validateCorrectDateAppears(dateString);
    }
}
