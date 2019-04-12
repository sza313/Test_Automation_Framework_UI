package selenium.stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.pages.BootstrapDatePickerPage;

public class StepDef_BootstrapDatePickerPage {
    private BootstrapDatePickerPage bootstrapDatePickerPage = new BootstrapDatePickerPage();

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
