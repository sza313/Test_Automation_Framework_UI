package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.MainPageObjects;

public class MainPage extends MainPageObjects {


    public MainPage(WebDriver driver){
        super(driver);
    }

    /**clickToMenuItem method calls the clickToElement method and gives the target menu element.
     *
     * @param menuName: This identifies the menu name which will be clicked
     * @return with a boolean to get the navigation status
     */
    public boolean clickToMenuItem(String menuName){
        menuName = menuName.toLowerCase();

        switch (menuName){
            case "input_forms":
                Assert.assertTrue("Could not click to "+menuName, clickToElement(this.inputFormsMenuItem));
                return true;
            default:
                Assert.fail("Could not found the requested item: "+menuName);
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

        switch (submenuName){
            case "simple_form_demo":
                Assert.assertTrue("Could not click to "+submenuName, clickToElement(this.simpleFormDemoSubmenuItem));
                return true;
            default:
                Assert.fail("Could not found the requested item: "+submenuName);
                return false;
        }

    }
}
