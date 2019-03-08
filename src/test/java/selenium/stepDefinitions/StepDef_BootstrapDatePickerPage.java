package selenium.stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.pages.BootstrapDatePickerPage;
import selenium.utils.DriverUtil;

public class StepDef_BootstrapDatePickerPage extends DriverUtil {
    private BootstrapDatePickerPage bootstrapDatePickerPage = new BootstrapDatePickerPage(driver);

    @Then("The bootstrap date picker page opens")
    public void validateSBootstrapDatePickerPageOpens() {
        Assert.assertTrue("The title of the page is not correct.", bootstrapDatePickerPage.validateBootstrapDatePickerPageTitle());
    }

    @When("I click on the '(.*)' input field in the date range example section")
    public void clickOnSelectStartDate(String datePickerName) {
        Assert.assertTrue("Could not click to " + datePickerName + " input field.", bootstrapDatePickerPage.clickOnSelectDate(datePickerName));
    }

    @When("I select the date '(.*)' from dropdown")
    public void selectDateFromDropdown(String dateString) {
        Assert.assertTrue("Could not set the date to '" + dateString + "'.", bootstrapDatePickerPage.selectStartDateFromDropdown(dateString));
    }

    @Then("'(.*)' appears in the start date input field")
    public void validateCorrectStartDateAppears(String dateString) {
        Assert.assertTrue("The date that appears in the textbox is not correct.", bootstrapDatePickerPage.validateCorrectDateAppears(dateString));
    }
}
