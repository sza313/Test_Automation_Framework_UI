package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.PhpSearchResPageObjects;

public class PhpSearchResPage extends PhpSearchResPageObjects {

    public PhpSearchResPage(WebDriver driver) {
        super(driver);
    }

    public boolean clickCheckbox(String checkboxName, boolean checkboxValueToSet) {
        switch (checkboxName) {
            case "STAR GRADE":
                Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.starGrade5, checkboxValueToSet));
                return true;

            default:
                Assert.fail("Could not find the requested item: " + checkboxName + ".");
                return false;
        }
    }
}
