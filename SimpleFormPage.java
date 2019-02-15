package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.SimpleFormPageObjects;

public class SimpleFormPage extends SimpleFormPageObjects {

    public SimpleFormPage(WebDriver driver) {
        super(driver);
    }

    public boolean writeRandomAlphabeticStringToMessageField(String textBox, int chars) {

        switch (textBox) {
            case "Message_form":
                Assert.assertTrue("Could not write to " + textBox, writeRandomAlphabeticString(this.enterMessageField, chars));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBox);
                return false;
        }
    }

    public boolean writeRandomNumericStringToMessageField(String textBox, int chars) {

        switch (textBox) {
            case "Message_form":
                Assert.assertTrue("Could not write to " + textBox, writeRandomNumericString(this.enterMessageField, chars));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBox);
                return false;
        }
    }

    public boolean writeRandomAlphanumericStringToMessageField(String textBox, int chars) {

        switch (textBox) {
            case "Message_form":
                Assert.assertTrue("Could not write to " + textBox, writeRandomAlphanumericString(this.enterMessageField, chars));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBox);
                return false;
        }
    }

    public boolean clearMessageFieldWithBackspace(String textBox) {

        switch (textBox) {
            case "Message_form":
                Assert.assertTrue("Could not delete from " + textBox, clearFieldWithBackspace(this.enterMessageField));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBox);
                return false;
        }
    }

    public boolean clearMessageField(String textBox) {

        switch (textBox) {
            case "Message_form":
                Assert.assertTrue("Could not delete from " + textBox, clearDataFromField(this.enterMessageField));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBox);
                return false;
        }
    }

    public boolean clickButton(String button) {

        switch (button) {
            case "Show_message":
                Assert.assertTrue("Could not click on " + button, clickButton(this.showMessageButton));
                return true;
            default:
                Assert.fail("Could not find the requested button: " + button);
                return false;
        }
    }

    public boolean validateMessage(String message) {

        switch (message) {
            case "Your_message":
                Assert.assertTrue("Could not get text from " + message, validateString(this.displayedMessage));
                return true;
            default:
                Assert.fail("Could not find the requested element: " + message);
                return false;
        }
    }
}
