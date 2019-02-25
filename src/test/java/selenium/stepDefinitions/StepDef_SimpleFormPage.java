package selenium.stepDefinitions;

import cucumber.api.java.en.And;
import selenium.pages.SimpleFormPage;
import selenium.utils.DriverUtil;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class StepDef_SimpleFormPage extends DriverUtil {

    private SimpleFormPage simpleFormPage = new SimpleFormPage(driver);

    @And("Write (\\d+) random alphabetic characters in textbox '(.*)'$")
    public void writeRandomAlphabeticStringIntoTheTextbox(int chars, String textBox) {
        Assert.assertTrue("Could not write to " + textBox + " textbox", simpleFormPage.writeRandomAlphabeticStringToMessageField(textBox, chars));
    }

    @And("Write (\\d+) random numeric characters in textbox '(.*)'$")
    public void writeRandomNumericStringIntoTheTextbox(int chars, String textBox) {
        Assert.assertTrue("Could not write to " + textBox + " textbox", simpleFormPage.writeRandomNumericStringToMessageField(textBox, chars));
    }

    @And("Write (\\d+) random alphanumeric characters in textbox '(.*)'$")
    public void writeRandomAlphanumericStringIntoTheTextbox(int chars, String textBox) {
        Assert.assertTrue("Could not write to " + textBox + " textbox", simpleFormPage.writeRandomAlphanumericStringToMessageField(textBox, chars));
    }

    @And("Delete text from '(.*)' with backspace button")
    public void deleteTextFromTextboxWithBackspace(String textBox) {
        Assert.assertTrue("Could not delete text from " + textBox + " textBox", simpleFormPage.clearMessageFieldWithBackspace(textBox));
    }

    @And("Clear data from '(.*)' textbox")
    public void clearDataFromTextbox(String textBox) {
        Assert.assertTrue("Could not delete text from " + textBox + " textBox", simpleFormPage.clearMessageField(textBox));
    }

    @And("Click '(.*)' button$")
    public void clickShowMessageButton(String button) {
        Assert.assertTrue("Could not click to " + button + " button", simpleFormPage.clickShowMessageButton(button));
    }

    @Then("The same '(.*)' is shown in the displayed message")
    public void checkDisplayedMessage(String expectedMessage) {
        Assert.assertTrue("Could not check " + expectedMessage, simpleFormPage.validateMessage(expectedMessage));
    }

    @Then("'(.*)' section is empty")
    public void displayedMessageSectionIsEmpty(String displayedMessage) {
            Assert.assertTrue("Could not check " + displayedMessage, simpleFormPage.checkDisplayedMessageIsEmpty(displayedMessage));
    }
}
