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
                Assert.assertTrue("Could not write to " + textBoxName + " textbox.", writeIntoTextbox(this.messageTextBox, text));
                return true;
            default:
                Assert.fail("Could not found the requested item: " + textBoxName + " textbox.");
                return false;
        }
    }


}
