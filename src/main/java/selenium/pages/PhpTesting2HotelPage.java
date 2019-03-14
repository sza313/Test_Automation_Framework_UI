package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import selenium.pageObjects.PhpTesting2HotelPageObjects;

public class PhpTesting2HotelPage extends PhpTesting2HotelPageObjects {
    public PhpTesting2HotelPage(WebDriver driver) {
        super(driver);
    }

    public boolean clickCheckbox(String checkboxName, boolean checkboxValueToSet) {
        switch (checkboxName) {
            case "STANDARD ROOM":
                /*Actions actions=new Actions(driver);
                actions.moveToElement(this.selectStandardRoom).build().perform();*/
                scrollToElementWithJS(this.selectStandardRoom);
                Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, setCheckboxValue(this.selectStandardRoom, checkboxValueToSet));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + checkboxName + ".");
                return false;
        }
    }

    public boolean clickToItem(String itemName) {
        switch (itemName) {
            case "BOOK NOW":
                scrollToElementWithJS(this.bookNow);
                Assert.assertTrue("Could not click to " + itemName, clickToElement(this.bookNow));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + itemName);
                return false;
        }
    }


}
