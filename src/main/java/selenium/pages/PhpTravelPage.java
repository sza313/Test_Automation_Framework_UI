package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.PhpTravelPageObjects;

public class PhpTravelPage extends PhpTravelPageObjects {

    public PhpTravelPage(WebDriver driver) {
        super(driver);
    }

    /**clickToMenuItem method calls the clickToElement method and gives the target menu element.
     *
     * @param menuName: This identifies the menu name which will be clicked
     * @return with a boolean to get the navigation status
     */
    public boolean clickToMenuItem(String menuName){

        switch (menuName) {
            case "MY ACCOUNT":
                Assert.assertTrue("Could not click to " + menuName, clickToElement(this.myAccountItem));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + menuName);
                return false;
        }
    }

    /**clickToSubmenuItem method calls the clickToElement method and gives the target menu element.
     *
     * @param submenuName: This identifies the submenu name which will be clicked
     * @return with a boolean to get the navigation status
     */
    public boolean clickToSubmenuItem(String submenuName){

        switch (submenuName) {
            case "Login":
                Assert.assertTrue("Could not click to " + submenuName, clickToElement(this.loginSubmenuItem));
                return true;
            case "Sign Up":
                Assert.assertTrue("Could not click to "+submenuName, clickToElement(this.signUpSubmenuItem));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + submenuName);
                return false;
        }
    }



}
