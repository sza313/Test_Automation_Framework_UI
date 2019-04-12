package selenium.pages;

import org.junit.Assert;

import selenium.pageObjects.CheckboxPageObjects;

public class CheckboxPage extends CheckboxPageObjects {

    public void validateSuccessMessage(String expectedMessage) {
        Assert.assertTrue("The success message was not as expected: " + expectedMessage, compareString(this.successMessageDisplay, expectedMessage));
    }

    public void clickCheckbox(String checkboxName, String checkboxValueToSet) {
        boolean toCheck = Boolean.valueOf(checkboxValueToSet);
        switch (checkboxName) {
        case "Single_Checkbox_Demo":
            Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.singleCheckbox, toCheck));
            break;
        default:
            Assert.fail("Could not find the requested item: " + checkboxName + ".");
        }
    }

    public void validateCheckboxPageTitle() {
        Assert.assertTrue("Title of Checkbox page was not as expected.", comparePageTitle("Selenium Easy - Checkbox demo for automation using selenium"));
    }
}
