package selenium.pages.seleniumeasy;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.seleniumeasy.MainPageObjects;

public class SeleniumEasyMainPage extends MainPageObjects {

    public SeleniumEasyMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * clickToMenuItem method calls the clickToElement method and gives the target menu element.
     *
     * @param menuName: This identifies the menu name which will be clicked
     */
    public void clickToMenuItem(String menuName) {
        menuName = menuName.toLowerCase();
        switch (menuName) {
            case "input_forms":
                Assert.assertTrue("Could not click to " + menuName, clickToElement(this.inputFormsMenuItem));
                break;
            case "progress_bars":
                Assert.assertTrue("Could not click to " + menuName, clickToElement(this.progressBarsMenuItem));
                break;
            case "date_pickers":
                Assert.assertTrue("Could not click to " + menuName, clickToElement(this.datePickersMenuItem));
                break;
            case "others":
                Assert.assertTrue("Could not click to " + menuName, clickToElement(this.othersMenuItem));
                break;
            default:
                Assert.fail("Could not find the requested item: " + menuName);
        }
    }

    /**
     * clickToSubmenuItem method calls the clickToElement method and gives the target menu element.
     *
     * @param submenuName: This identifies the submenu name which will be clicked
     */
    public void clickToSubmenuItem(String submenuName) {
        submenuName = submenuName.toLowerCase();
        switch (submenuName) {
            case "simple_form_demo":
                Assert.assertTrue("Could not click to " + submenuName, clickToElement(this.simpleFormDemoSubmenuItem));
                break;
            case "checkbox_demo":
                Assert.assertTrue("Could not click to " + submenuName, clickToElement(this.checkboxDemoSubmenuItem));
                break;
            case "drag_&_drop_sliders":
                Assert.assertTrue("Could not click to " + submenuName, clickToElement(this.dragAndDropSlidersSubmenuItem));
                break;
            case "bootstrap_date_picker":
                Assert.assertTrue("Could not click to " + submenuName, clickToElement(this.bootstrapDatePickerSubmenuItem));
                break;
            case "jquery_dropdown":
                Assert.assertTrue("Could not click to " + submenuName, clickToElement(this.jQueryDropDownSubmenuItem));
                break;
            case "drag_and_drop":
                Assert.assertTrue("Could not click to " + submenuName, clickToElement(this.dragAndDropSubmenuItem));
                break;
            default:
                Assert.fail("Could not find the requested item: " + submenuName);
        }

    }

    public void drawBorderAroundElement(String elementName) {
        elementName = elementName.toLowerCase();
        switch (elementName) {
            case "site_name":
                Assert.assertTrue("Could not draw border to " + elementName, drawBorder(this.siteName));
                break;
            default:
                Assert.fail("Could not found the following item:" + elementName);

        }
    }

    public void clickToMenuItemWhitVisualization(String menuName) {
        switch (menuName) {
            case "Input_Forms":
                Assert.assertTrue("Could not click with visualization to " + menuName, clickToElementWithVisualization(this.inputFormsMenuItem));
                break;
            default:
                Assert.fail("Could not find the requested item: " + menuName);
        }
    }

    public void validateRedBorderAppears(String menuName) {
        switch (menuName) {
            case "Input_Forms":
                Assert.assertTrue("Input forms item is not displayed with red border", this.inputFormsMenuItem.getAttribute("style")
                        .contains("solid red"));
                break;
            default:
                Assert.fail("Could not find the requested item: " + menuName);
        }
    }

    public void validateSubmenuItemIsVisible(String submenuName) {
        switch (submenuName) {
            case "Simple_Form_Demo":
                Assert.assertTrue("Simple Form Demo submenu item is not displayed", this.simpleFormDemoSubmenuItem.isDisplayed());
                break;
            default:
                Assert.fail("Could not find the requested item: " + submenuName);
        }
    }

    public void clickToElementWithJS(String elementName) {
        switch (elementName) {
            case "Input_Forms":
                Assert.assertTrue("Could not click with javascript to " + elementName, clickToElementWithJS(this.inputFormsMenuItem));
                break;
            case "Simple_Form_Demo":
                Assert.assertTrue("Could not click with javascript to " + elementName, clickToElementWithJS(this.simpleFormDemoSubmenuItem));
                break;
            default:
                Assert.fail("Could not find the requested item: " + elementName);
        }
    }

    public void scrollToElementOnMainPage(String elementName) {
        switch (elementName) {
            case "Tutorials_Menu":
                Assert.assertTrue("Could not scroll to " + elementName + " element", scrollToElementWithJS(this.tutorialsMenuTitle));
                break;
            default:
                Assert.fail("Could not find the requested item: " + elementName);
        }
    }

    public void scrollToElementWithOffsetOnMainPage(String elementName, int xOffset, int yOffset) {
        switch (elementName) {
            case "Tutorials_Menu":
                Assert.assertTrue("Could not scroll to " + elementName + " element with the requested offset", scrollToElementWithOffset(this.tutorialsMenuTitle, xOffset, yOffset));
                break;
            default:
                Assert.fail("Could not find the requested item: " + elementName);
        }
    }

    public void failTheTest() {
        Assert.assertTrue("This test is doomed to fail!", false);
    }

}
