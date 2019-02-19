package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.CheckboxPageObjects;

public class CheckboxPage extends CheckboxPageObjects {
    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public boolean validateSuccessMessage(String expectedMessage) {
        switch (expectedMessage) {
            case "Success - Check box is checked":
                return compareString(this.successMessageDisplay, expectedMessage);
            default:
                Assert.fail("Could not find the requested text.");
                return false;
        }
    }

    public boolean clickCheckbox(String checkboxName, boolean checkboxValueToSet) {
        switch (checkboxName) {
            case "Single_Checkbox_Demo":
                Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.singleCheckbox,checkboxValueToSet));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + checkboxName + ".");
                return false;
        }
    }
}
