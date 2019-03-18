package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.PhpMyAccountPageObjects;

public class PhpMyAccountPage extends PhpMyAccountPageObjects {

    public PhpMyAccountPage(WebDriver driver) {
        super(driver);
    }

    /**clickToMenuItem method calls the clickToElement method and gives the target menu element.
     *
     * @param menuName: This identifies the menu name which will be clicked
     * @return with a boolean to get the navigation status
     */
    public boolean clickToMenuItem(String menuName){

        switch (menuName) {
            case "HOME":
                Assert.assertTrue("Could not click to " + menuName, clickToElement(this.homeItem));
                return true;
            case "HOTELS":
                Assert.assertTrue("Could not click to "+menuName, clickToElement(this.hotelsItem));
                return true;
            case "FLIGHTS":
                Assert.assertTrue("Could not click to "+menuName, clickToElement(this.flightsItem));
                return true;
            case "TOURS":
                Assert.assertTrue("Could not click to "+menuName, clickToElement(this.toursItem));
                return true;
            case "CARS":
                Assert.assertTrue("Could not click to "+menuName, clickToElement(this.carsItem));
                return true;
            case "VISA":
                Assert.assertTrue("Could not click to "+menuName, clickToElement(this.visaItem));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + menuName);
                return false;
        }

    }

    public boolean waitForElementClickable(String element) {
        switch (element) {
            case "HOTELS":
                Assert.assertTrue("Element is not visible: " + element, waitUntilElementClickable(this.hotelsItem));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + element);
                return false;
        }
    }


}
