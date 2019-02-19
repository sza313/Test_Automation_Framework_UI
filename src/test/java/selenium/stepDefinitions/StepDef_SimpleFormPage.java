package selenium.stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
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

    @Then("The '(.*)' page opens")
    public void validateThatSimpleFormPageOpens(String pageName) {
        Assert.assertTrue("The title of the page is not '" + pageName+ "'.", simpleFormPage.validatePageTitle(pageName));
    }

    @Then("The same '(.*)' shows up at the '(.*)' section on the simple form page")
    public void validateThatCorrectMessageShowsUp(String expectedMessage, String displayName){
        Assert.assertTrue("The displayed user message is not '" + expectedMessage+ "'.", simpleFormPage.validateUserMessage(expectedMessage, displayName));
}
}
