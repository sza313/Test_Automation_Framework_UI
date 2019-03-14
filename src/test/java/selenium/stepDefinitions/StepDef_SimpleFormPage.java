package selenium.stepDefinitions;

import cucumber.api.java.en.And;
import selenium.pages.SimpleFormPage;
import selenium.utils.DriverUtil;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import cucumber.api.java.en.When;

public class StepDef_SimpleFormPage extends DriverUtil {

    private SimpleFormPage simpleFormPage = new SimpleFormPage(driver);

    @When("I write a '(.*)' to the '(.*)' textbox on the simple form page$")
    public void writeToSimpleFormTextBox(String text, String textBoxName) {
        Assert.assertTrue("Could not write to "+textBoxName+" menu", simpleFormPage.writeToSimpleFormTextBox(textBoxName, text));
    }

    @And("Write (\\d+) random alphabetic characters in textbox '(.*)'$")
    public void writeRandomAlphabeticStringIntoTheTextbox(int chars, String textBox) {
        Assert.assertTrue("Could not write to " + textBox + " textbox", simpleFormPage.writeRandomAlphabeticStringToSimpleFormTextBox(textBox, chars));
    }

    @And("Write (\\d+) random numeric characters in textbox '(.*)'$")
    public void writeRandomNumericStringIntoTheTextbox(int chars, String textBox) {
        Assert.assertTrue("Could not write to " + textBox + " textbox", simpleFormPage.writeRandomNumericStringToSimpleFormTextBox(textBox, chars));
    }

    @And("Write (\\d+) random alphanumeric characters in textbox '(.*)'$")
    public void writeRandomAlphanumericStringIntoTheTextbox(int chars, String textBox) {
        Assert.assertTrue("Could not write to " + textBox + " textbox", simpleFormPage.writeRandomAlphanumericStringToSimpleFormTextBox(textBox, chars));
    }

    @And("Delete text from '(.*)' with backspace button$")
    public void deleteTextFromTextboxWithBackspace(String textBox) {
        Assert.assertTrue("Could not delete text from " + textBox + " textBox", simpleFormPage.clearMessageFieldWithBackspace(textBox));
    }

    @And("Clear data from '(.*)' textbox$")
    public void clearDataFromTextbox(String textBox) {
        Assert.assertTrue("Could not delete text from " + textBox + " textBox", simpleFormPage.clearMessageField(textBox));
    }

    @Then("The same '(.*)' shows up at the user message display section on the simple form page$")
    public void validateThatCorrectMessageShowsUp(String expectedMessage){
        Assert.assertTrue("The displayed user message is not '" + expectedMessage+ "'.", simpleFormPage.validateMessage(expectedMessage));
    }

    @Then("The same string is shown in the displayed message")
    public void checkDisplayedMessage() {
        Assert.assertTrue("The displayed user message is not identical with the expected message.", simpleFormPage.validateRandomStringMessage());
    }

    @Then("'(.*)' section is empty$")
    public void displayedMessageIsEmpty(String displayedMessage) {
            Assert.assertTrue("The following field is not empty: " + displayedMessage, simpleFormPage.checkDisplayedMessageIsEmpty());
    }

    @When("I click on the '(.*)' button on the simple form page$")
    public void clickOnButton(String buttonName) {
        Assert.assertTrue("Could not click on " + buttonName+ " button", simpleFormPage.clickOnButton(buttonName));
    }

    @Then("The simple form page opens")
    public void validateSimpleFormPageOpens() {
        Assert.assertTrue("The title of the page is not correct.", simpleFormPage.validateSimpleFormPageTitle());
    }

    @Then("The correct sum is displayed")
    public void validateIfCorrectSumIsDisplayed() {
        Assert.assertTrue("The displayed sum is not correct.", simpleFormPage.validateSum());
    }
}
