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

    public boolean clickShowMessageButton(String button) {
        switch (button) {
            case "Show_message":
                Assert.assertTrue("Could not click on " + button + " button.", clickToElement(this.showMessageButton));
                return true;
            default:
                Assert.fail("Could not find the requested button: " + button + " button.");
                return false;
        }
    }

    public boolean validateMessage(String expectedMessage) {
        return validateString(this.displayedMessage, expectedMessage);
        }

    public boolean checkDisplayedMessageIsEmpty(String displayedMessage) {
        return validateFieldIsEmpty(this.displayedMessage);
    }
}
