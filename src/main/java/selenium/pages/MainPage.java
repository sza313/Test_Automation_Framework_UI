package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.MainPageObjects;

public class MainPage extends MainPageObjects {


    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**clickToMenuItem method calls the clickToElement method and gives the target menu element.
     *
     * @param menuName: This identifies the menu name which will be clicked
     * @return with a boolean to get the navigation status
     */
    public boolean clickToMenuItem(String menuName){
        menuName = menuName.toLowerCase();

        switch (menuName) {
            case "input_forms":
                Assert.assertTrue("Could not click to " + menuName, clickToElement(this.inputFormsMenuItem));
                return true;
            case "progress_bars":
                Assert.assertTrue("Could not click to "+menuName, clickToElement(this.progressBarsMenuItem));
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
        submenuName = submenuName.toLowerCase();

        switch (submenuName) {
            case "simple_form_demo":
                Assert.assertTrue("Could not click to " + submenuName, clickToElement(this.simpleFormDemoSubmenuItem));
                return true;
            case "checkbox_demo":
                Assert.assertTrue("Could not click to "+submenuName, clickToElement(this.checkboxDemoSubmenuItem));
                return true;
            case "drag_&_drop_sliders":
                Assert.assertTrue("Could not click to "+submenuName, clickToElement(this.dragAndDropSlidersSubmenuItem));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + submenuName);
                return false;
        }

    }

    public boolean drawBorderAroundElement(String elementName) {
        elementName=elementName.toLowerCase();

        switch (elementName) {
            case "site_name":
            Assert.assertTrue("Could not draw border to " + elementName, drawBorder(this.siteName));
            return true;
            default:
                Assert.fail("Could not found the following item:" + elementName);
                return false;

        }
    }
}
