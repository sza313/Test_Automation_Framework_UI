package selenium.stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.pages.SimpleFormPage;
import selenium.utils.DriverUtil;

public class StepDef_SimpleFormPage extends DriverUtil {

    private SimpleFormPage simpleFormPage = new SimpleFormPage(driver);

    @When("I write a '(.*)' to the '(.*)' textbox on the simple form page$")
    public void writeToSimpleFormTextBox(String text, String textBoxName) {
        Assert.assertTrue("Could not write to "+textBoxName+" menu", simpleFormPage.writeToSimpleFormTextBox(textBoxName, text));
    }

    @When("I click on the '(.*)' button on the simple form page")
    public void clickOnShowMessageButton(String buttonName) {
        Assert.assertTrue("Could not click on " + buttonName+ " button", simpleFormPage.clickOnShowMessageButton(buttonName));
    }

    @Then("The simple form page opens")
    public void validateSimpleFormPageOpens() {
        Assert.assertTrue("The title of the page is not correct.", simpleFormPage.validateSimpleFormPageTitle());
    }

    @Then("The same '(.*)' shows up at the user message display section on the simple form page")
    public void validateThatCorrectMessageShowsUp(String expectedMessage){
        Assert.assertTrue("The displayed user message is not '" + expectedMessage+ "'.", simpleFormPage.validateUserMessage(expectedMessage));
}
}
