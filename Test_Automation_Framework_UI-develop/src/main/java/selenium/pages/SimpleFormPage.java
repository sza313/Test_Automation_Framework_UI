package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.SimpleFormPageObjects;

public class SimpleFormPage extends SimpleFormPageObjects {

    public SimpleFormPage(WebDriver driver) {
        super(driver);
    }

    public boolean writeRandomAlphabeticStringToMessageField(String textBox, int chars) {
        textBox = textBox.toLowerCase();

        switch (textBox) {
            case "simple_form":
                Assert.assertTrue("Could not write to " + textBox, writeRandomAlphabeticString(this.enterMessageField, chars));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBox);
                return false;
        }
    }

    public boolean writeRandomNumericStringToMessageField(String textBox, int chars) {
        textBox = textBox.toLowerCase();

        switch (textBox) {
            case "simple_form":
                Assert.assertTrue("Could not write to " + textBox, writeRandomNumericString(this.enterMessageField, chars));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBox);
                return false;
        }
    }

    public boolean writeRandomAlphanumericStringToMessageField(String textBox, int chars) {
        textBox = textBox.toLowerCase();

        switch (textBox) {
            case "simple_form":
                Assert.assertTrue("Could not write to " + textBox, writeRandomAlphanumericString(this.enterMessageField, chars));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBox);
                return false;
        }
    }

    public boolean clearMessageField(String menuName) {
        menuName = menuName.toLowerCase();

        switch (menuName) {
            case "input_forms":
                Assert.assertTrue("Could not delete from " + menuName, clearField(this.enterMessageField));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + menuName);
                return false;
        }
    }


}
