package selenium.stepDefinitions.seleniumeasy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.parallel.context.CucumberTestContext;

public class SimpleFormPage {
    private final static Logger LOG = LogManager.getLogger();
    private selenium.pages.seleniumeasy.SimpleFormPage simpleFormPage;

    public SimpleFormPage(CucumberTestContext testContext) {
        simpleFormPage = new selenium.pages.seleniumeasy.SimpleFormPage(testContext.getWebDriver());
        LOG.info(getClass().getName() + " initialized.");
    }

    @When("I write a '(.*)' to the '(.*)' textbox on the simple form page$")
    public void writeToSimpleFormTextBox(String text, String textBoxName) {
        simpleFormPage.writeToSimpleFormTextBox(textBoxName, text);
    }

    @And("Write (\\d+) random alphabetic characters in textbox '(.*)'$")
    public void writeRandomAlphabeticStringIntoTheTextbox(int chars, String textBox) {
        simpleFormPage.writeRandomAlphabeticStringToSimpleFormTextBox(textBox, chars);
    }

    @And("Write (\\d+) random numeric characters in textbox '(.*)'$")
    public void writeRandomNumericStringIntoTheTextbox(int chars, String textBox) {
        simpleFormPage.writeRandomNumericStringToSimpleFormTextBox(textBox, chars);
    }

    @And("Write (\\d+) random alphanumeric characters in textbox '(.*)'$")
    public void writeRandomAlphanumericStringIntoTheTextbox(int chars, String textBox) {
        simpleFormPage.writeRandomAlphanumericStringToSimpleFormTextBox(textBox, chars);
    }

    @And("Delete text from '(.*)' with backspace button$")
    public void deleteTextFromTextboxWithBackspace(String textBox) {
        simpleFormPage.clearMessageFieldWithBackspace(textBox);
    }

    @And("Clear data from '(.*)' textbox$")
    public void clearDataFromTextbox(String textBox) {
        simpleFormPage.clearMessageField(textBox);
    }

    @Then("The same '(.*)' shows up at the user message display section on the simple form page$")
    public void validateThatCorrectMessageShowsUp(String expectedMessage) {
        simpleFormPage.validateMessage(expectedMessage);
    }

    @Then("The same string is shown in the displayed message")
    public void checkDisplayedMessage() {
        simpleFormPage.validateRandomStringMessage();
    }

    @Then("'(.*)' section is empty$")
    public void displayedMessageIsEmpty(String displayedMessage) {
        simpleFormPage.checkDisplayedMessageIsEmpty();
    }

    @When("I click on the '(.*)' button on the simple form page$")
    public void clickOnButton(String buttonName) {
        simpleFormPage.clickOnButton(buttonName);
    }

    @Then("The simple form page opens")
    public void validateSimpleFormPageOpens() {
        simpleFormPage.validateSimpleFormPageTitle();
    }

    @Then("The correct sum is displayed")
    public void validateIfCorrectSumIsDisplayed() {
        simpleFormPage.validateSum();
    }
}
