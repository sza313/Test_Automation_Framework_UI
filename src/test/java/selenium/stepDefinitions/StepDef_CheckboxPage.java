package selenium.stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.pages.CheckboxPage;

public class StepDef_CheckboxPage {
    private CheckboxPage checkboxPage = new CheckboxPage();

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
