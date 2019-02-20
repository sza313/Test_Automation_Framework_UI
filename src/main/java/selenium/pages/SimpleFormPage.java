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

    public boolean validatePageTitle(String pageName) {
        switch (pageName) {
            case "Simple_Form":
                return driver.getTitle().equals("Selenium Easy Demo - Simple Form to Automate using Selenium");
            case "Checkbox":
                return driver.getTitle().equals("Selenium Easy - Checkbox demo for automation using selenium");
            case "Range_Sliders":
                return driver.getTitle().equals("Selenium Easy - Drag and Drop Range Sliders");
            default:
                Assert.fail("Could not get the title of the page: " +pageName+ " .");
                return false;
        }
    }

    public boolean validateUserMessage(String expectedMessage,String displayName) {
        switch (displayName) {
            case "User_Message_Display":
                return compareString(this.userMessageDisplay, expectedMessage);
            default:
                Assert.fail("Could not find the requested item: the text of " +displayName+ " .");
                return false;
        }
    }
}
