package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.SimpleFormPageObjects;

public class SimpleFormPage extends SimpleFormPageObjects {
    public SimpleFormPage(WebDriver driver) {
        super(driver);
    }

    String alphabetic = "";

    public boolean writeRandomAlphabeticStringToMessageField(String textBox, int chars) {
        switch (textBox) {
            case "Message_form":
                Assert.assertTrue("Could not write to " + textBox + " textbox.", writeRandomAlphabeticString(this.enterMessageField, chars));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBox + " textbox.");
                return false;
        }
    }

    public boolean writeRandomNumericStringToMessageField(String textBox, int chars) {
        switch (textBox) {
            case "Message_form":
                Assert.assertTrue("Could not write to " + textBox + " textbox.", writeRandomNumericString(this.enterMessageField, chars));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBox + " textbox.");
                return false;
        }
    }

    public boolean writeRandomAlphanumericStringToMessageField(String textBox, int chars) {
        switch (textBox) {
            case "Message_form":
                Assert.assertTrue("Could not write to " + textBox + " textbox.", writeRandomAlphanumericString(this.enterMessageField, chars));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBox + " textbox.");
                return false;
        }
    }

    public boolean clearMessageFieldWithBackspace(String textBox) {
        switch (textBox) {
            case "Message_form":
                Assert.assertTrue("Could not delete from " + textBox + " textbox.", clearFieldWithBackspace(this.enterMessageField));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBox);
                return false;
        }
    }


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

    public boolean clearMessageField(String textBox) {
        switch (textBox) {
            case "Message_form":
                Assert.assertTrue("Could not delete from " + textBox + " textbox.", clearDataFromField(this.enterMessageField));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBox);
                return false;
        }
    }

    public boolean clickShowMessageButton(String button){
                switch (button) {
                    case "Show_message":
                        Assert.assertTrue("Could not click on " + button + " button.", clickToElement(this.showMessageButton));
                        return true;
                    default:
                        Assert.fail("Could not find the requested button: " + button + " button.");
                        return false;
                }
            }

    public boolean clickOnShowMessageButton(String buttonName) {
        switch (buttonName) {
            case "Show_Message":
                Assert.assertTrue("Could not click on " + buttonName + " button.", clickToElement(this.showMessageButton));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + buttonName + " button.");
                return false;
        }
    }

    public boolean validateMessage(String expectedMessage) {
        return validateString(this.displayedMessage, expectedMessage);
        }

    public boolean checkDisplayedMessageIsEmpty(String displayedMessage) {
        return validateFieldIsEmpty(this.displayedMessage);
    }

    public boolean validateSimpleFormPageTitle() {
        return driver.getTitle().equals("Selenium Easy Demo - Simple Form to Automate using Selenium");
    }

    public boolean validateUserMessage(String expectedMessage) {
        return compareString(this.userMessageDisplay, expectedMessage);
    }
}

