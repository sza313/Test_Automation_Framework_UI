package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import selenium.pageObjects.SimpleFormPageObjects;

public class SimpleFormPage extends SimpleFormPageObjects {
    public SimpleFormPage(WebDriver driver) {
        super(driver);
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

    public boolean validateSimpleFormPageTitle() {
        return driver.getTitle().equals("Selenium Easy Demo - Simple Form to Automate using Selenium");
    }

    public boolean validateUserMessage(String expectedMessage) {
        return compareString(this.userMessageDisplay, expectedMessage);
    }
}

