package selenium.pages.phptravels;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import selenium.pageObjects.phptravels.PhpTravelPageObjects;

public class PhpTravelsPage extends PhpTravelPageObjects {

    public PhpTravelsPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * clickToMenuItem method calls the clickToElement method and gives the target menu element.
     *
     * @param menuName: This identifies the menu name which will be clicked
     * @return with a boolean to get the navigation status
     */
    public void clickToMenuItem(String menuName) {
        switch (menuName) {
        case "MY ACCOUNT":
            Assert.assertTrue("Could not click to " + menuName, clickToElement(this.myAccountItem));
            break;
        default:
            Assert.fail("Could not find the requested item: " + menuName);
        }
    }

    /**
     * clickToSubmenuItem method calls the clickToElement method and gives the target menu element.
     *
     * @param submenuName: This identifies the submenu name which will be clicked
     * @return with a boolean to get the navigation status
     */
    public void clickToSubmenuItem(String submenuName) {
        switch (submenuName) {
        case "Login":
            Assert.assertTrue("Could not click to " + submenuName, clickToElement(this.loginSubmenuItem));
            break;
        case "Sign Up":
            Assert.assertTrue("Could not click to " + submenuName, clickToElement(this.signUpSubmenuItem));
            break;
        default:
            Assert.fail("Could not find the requested item: " + submenuName);
        }
    }

}
