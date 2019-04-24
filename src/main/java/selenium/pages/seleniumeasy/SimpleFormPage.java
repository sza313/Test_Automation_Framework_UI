package selenium.pages.seleniumeasy;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.seleniumeasy.SimpleFormPageObjects;

public class SimpleFormPage extends SimpleFormPageObjects {

    private String randomString = "";

    public SimpleFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void writeToSimpleFormTextBox(String textBoxName, String text) {
        switch (textBoxName) {
            case "Message":
                Assert.assertTrue("Could not write to " + textBoxName + " textbox.", writeIntoTextBox(this.messageTextBox, text));
                break;
            default:
                Assert.fail("Could not find the requested item: " + textBoxName + " textbox.");
        }
    }

    public void writeRandomAlphabeticStringToSimpleFormTextBox(String textBoxName, int chars) {
        randomString = createRandomAlphabeticString(chars);
        switch (textBoxName) {
            case "Message":
                Assert.assertTrue("Could not write to " + textBoxName + " textbox.", writeIntoTextBox(this.messageTextBox, randomString));
                break;
            default:
                Assert.fail("Could not find the requested item: " + textBoxName + " textbox.");
        }
    }

    public void writeRandomNumericStringToSimpleFormTextBox(String textBoxName, int chars) {
        randomString = createRandomNumericString(chars);
        switch (textBoxName) {
            case "Message":
                Assert.assertTrue("Could not write to " + textBoxName + " textbox.", writeIntoTextBox(this.messageTextBox, randomString));
                break;
            case "Number1":
                Assert.assertTrue("Could not write to " + textBoxName + " textbox.", writeIntoTextBox(this.number1Field, randomString));
                break;
            case "Number2":
                Assert.assertTrue("Could not write to " + textBoxName + " textbox.", writeIntoTextBox(this.number2Field, randomString));
                break;
            default:
                Assert.fail("Could not find the requested item: " + textBoxName + " textbox.");
        }
    }

    public void writeRandomAlphanumericStringToSimpleFormTextBox(String textBoxName, int chars) {
        randomString = createRandomAlphanumericString(chars);
        switch (textBoxName) {
            case "Message":
                Assert.assertTrue("Could not write to " + textBoxName + " textbox.", writeIntoTextBox(this.messageTextBox, randomString));
                break;
            default:
                Assert.fail("Could not find the requested item: " + textBoxName + " textbox.");
        }
    }

    public void clearMessageFieldWithBackspace(String textBoxName) {
        switch (textBoxName) {
            case "Message":
                Assert.assertTrue("Could not delete from " + textBoxName + " textbox.", clearFieldWithBackspace(this.enterMessageField));
                break;
            default:
                Assert.fail("Could not find the requested item: " + textBoxName);
        }
    }

    public void clearMessageField(String textBoxName) {
        switch (textBoxName) {
            case "Message":
                Assert.assertTrue("Could not delete from " + textBoxName + " textbox.", clearTextBox(this.enterMessageField));
                break;
            default:
                Assert.fail("Could not find the requested item: " + textBoxName);
        }
    }

    public void clickOnButton(String buttonName) {
        switch (buttonName) {
            case "Show_Message":
                Assert.assertTrue("Could not click on " + buttonName + " button.", clickToElement(this.showMessageButton));
                break;
            case "Get_Total":
                Assert.assertTrue("Could not click on " + buttonName + " button.", clickToElement(this.getTotalButton));
                break;
            default:
                Assert.fail("Could not find the requested item: " + buttonName + " button.");
        }
    }

    public void validateMessage(String expectedMessage) {
        Assert.assertTrue("The displayed user message is not '" + expectedMessage + "'.", compareString(this.displayedMessage, expectedMessage));
    }

    public void validateRandomStringMessage() {
        Assert.assertTrue("The displayed user message is not identical with the expected message.", compareString(this.displayedMessage, randomString));
    }

    public void checkDisplayedMessageIsEmpty() {
        Assert.assertTrue("The following field is not empty: " + displayedMessage, validateFieldIsEmpty(this.displayedMessage));
    }

    public void validateSimpleFormPageTitle() {
        Assert.assertTrue("The title of the page is not correct.", comparePageTitle("Selenium Easy Demo - Simple Form to Automate using Selenium"));
    }

    public void validateSum() {
        Assert.assertTrue("The displayed sum is not correct.", validateIfSumIsCorrect(this.number1Field, this.number2Field, this.displaySum));
    }
}
