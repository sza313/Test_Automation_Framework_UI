package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import selenium.pageObjects.PhpConfirmationPageObjects;

public class PhpConfirmationPage extends PhpConfirmationPageObjects {
    public PhpConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public boolean clickToItem(String itemName) {
        switch (itemName) {
            case "CONFIRM THIS BOOKING":
                scrollToElementWithJS(this.confirmThisBooking);
                Assert.assertTrue("Could not click to " + itemName, clickToElement(this.confirmThisBooking));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + itemName);
                return false;
        }
    }

    public boolean waitForElement(String element) {
        switch (element) {
            case "Invoice":
                Assert.assertTrue("Element is not visible: " + element, waitUntilElementVisible(this.invoiceRoomElement));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + element);
                return false;
        }
    }
}
