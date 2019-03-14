package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.SimpleFormPageObjects;

public class SimpleFormPage extends SimpleFormPageObjects {
    public SimpleFormPage(WebDriver driver) {
        super(driver);
    }

    private String randomString = "";

    public boolean writeToSimpleFormTextBox(String textBoxName, String text) {
        switch (textBoxName) {
            case "Message":
                Assert.assertTrue("Could not write to " + textBoxName + " textbox.", writeIntoTextBox(this.messageTextBox, text));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBoxName + " textbox.");
                return false;
        }
    }

    public boolean writeRandomAlphabeticStringToSimpleFormTextBox(String textBoxName, int chars) {
        randomString = createRandomAlphabeticString(chars);
        switch (textBoxName) {
            case "Message":
                Assert.assertTrue("Could not write to " + textBoxName + " textbox.", writeIntoTextBox(this.messageTextBox, randomString));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBoxName + " textbox.");
                return false;
        }
    }

    public boolean writeRandomNumericStringToSimpleFormTextBox(String textBoxName, int chars) {
        randomString = createRandomNumericString(chars);
        switch (textBoxName) {
            case "Message":
                Assert.assertTrue("Could not write to " + textBoxName + " textbox.", writeIntoTextBox(this.messageTextBox, randomString));
                return true;
            case "Number1":
                Assert.assertTrue("Could not write to " + textBoxName + " textbox.", writeIntoTextBox(this.number1Field, randomString));
                return true;
            case "Number2":
                Assert.assertTrue("Could not write to " + textBoxName + " textbox.", writeIntoTextBox(this.number2Field, randomString));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBoxName + " textbox.");
                return false;
        }
    }

    public boolean writeRandomAlphanumericStringToSimpleFormTextBox(String textBoxName, int chars) {
        randomString = createRandomAlphanumericString(chars);
        switch (textBoxName) {
            case "Message":
                Assert.assertTrue("Could not write to " + textBoxName + " textbox.", writeIntoTextBox(this.messageTextBox, randomString));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBoxName + " textbox.");
                return false;
        }
    }

    public boolean clearMessageFieldWithBackspace(String textBoxName) {
        switch (textBoxName) {
            case "Message":
                Assert.assertTrue("Could not delete from " + textBoxName + " textbox.", clearFieldWithBackspace(this.enterMessageField));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBoxName);
                return false;
        }
    }

    public boolean clearMessageField(String textBoxName) {
        switch (textBoxName) {
            case "Message":
                Assert.assertTrue("Could not delete from " + textBoxName + " textbox.", clearDataFromField(this.enterMessageField));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBoxName);
                return false;
        }
    }

    public boolean clickOnButton(String buttonName) {
        switch (buttonName) {
            case "Show_Message":
                Assert.assertTrue("Could not click on " + buttonName + " button.", clickToElement(this.showMessageButton));
                return true;
            case "Get_Total":
                Assert.assertTrue("Could not click on " + buttonName + " button.", clickToElement(this.getTotalButton));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + buttonName + " button.");
                return false;
        }
    }

    public boolean validateMessage(String expectedMessage) {
        return compareString(this.displayedMessage, expectedMessage);
        }

    public boolean validateRandomStringMessage() {
        return compareString(this.displayedMessage, randomString);
    }

    public boolean checkDisplayedMessageIsEmpty() {
        return validateFieldIsEmpty(this.displayedMessage);
    }

    public boolean validateSimpleFormPageTitle() {
        return driver.getTitle().equals("Selenium Easy Demo - Simple Form to Automate using Selenium");
    }

    public boolean validateSum() {
        return validateIfSumIsCorrect(this.number1Field, this.number2Field, this.displaySum);
        }
    }
