package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.MainPageObjects;

public class MainPage extends MainPageObjects {


    public MainPage(WebDriver driver){
        super(driver);
    }

    public boolean clickToMenuItem(String menuName){
        menuName = menuName.toLowerCase();

        switch (menuName){
            case "input_forms":
                Assert.assertTrue("Could not click to "+menuName, clickToElement(this.inputFormsMenuItem));
                return true;
            case "others":
                Assert.assertTrue("Could not click to "+menuName, clickToElement(this.othersMenuItem));
                return true;
            default:
                Assert.fail("Could not found the requested item: "+menuName);
                return false;
        }
    }

    public boolean clickToSubmenuItem(String submenuName){
        submenuName = submenuName.toLowerCase();

        switch (submenuName){
            case "simple_form_demo":
                Assert.assertTrue("Could not click to "+submenuName, clickToElement(this.simpleFormDemoSubmenuItem));
                return true;
            case "jquery_dropdown":
                Assert.assertTrue("Could not click to "+submenuName, clickToElement(this.jQueryDropDownSubmenuItem));
                return true;
            case "drag_and_drop":
                Assert.assertTrue("Could not click to "+submenuName, clickToElement(this.dragAndDropSubmenuItem));
                return true;
            default:
                Assert.fail("Could not found the requested item: "+submenuName);
                return false;
        }

    }
}
