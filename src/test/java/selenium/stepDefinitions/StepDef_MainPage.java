package selenium.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import selenium.pages.MainPage;
import selenium.utils.DriverUtil;

public class StepDef_MainPage extends DriverUtil {

    private MainPage mainPage = new MainPage(driver);

    @Given("Open site")
    public void openBrowser() {
        String url;

        if (System.getProperty("url") != null) {
            url = System.getProperty("url");
        } else if (properties.getProperty("url") != null) {
            url = properties.getProperty("url");
        } else {
            url = "https://www.seleniumeasy.com/test/";
        }
        driver.get(url);
    }

    @Given("This step will fail")
    public void thisStepWillFail() {
        Assert.assertTrue("This test should present a failed scenario", false);
    }

    @When("Click to '(.*)' menu item$")
    public void clickToMenuItem(String menuName) {
        Assert.assertTrue("Could not click to " + menuName + " menu", mainPage.clickToMenuItem(menuName));
    }

    @When("Click to '(.*)' submenu item$")
    public void clickToSubmenuItem(String submenuName) {
        Assert.assertTrue("Could not click to " + submenuName + " menu", mainPage.clickToSubmenuItem(submenuName));
    }

    @Then("Draw border around '(.*)'")
    public void drawBorderAroundTheElement(String elementName) {
        Assert.assertTrue("Could not draw border to " + elementName + " menu", mainPage.drawBorderAroundElement(elementName));

    }

    @When("Click with visualization to '(.*)' menu item")
    public void clickWithVisualizationToMenuItem(String menuName) {
        Assert.assertTrue("Could not click to " + menuName + " menu with visualization", mainPage.clickToMenuItemWhitVisualization(menuName));
    }

    @Then( "A red border around '(.*)' menu item appears")
    public void validateRedBorderAppears(String menuName) {
        Assert.assertTrue("Couldn't draw border around " + menuName + " menu item.", mainPage.validateRedBorderAppears(menuName));
}

    @Then("'(.*)' submenu item becomes visible")
    public  void validateSubmenuItemIsVisible(String submenuName) {
        Assert.assertTrue(submenuName + " submenu item is not visible.", mainPage.validateSubmenuItemIsVisible(submenuName));
    }

    @When("Click with javascript to {string} menu item")
    public void clickWithJavascriptToInput_FormsMenuItem(String menuName) {
        Assert.assertTrue("Could not click with javascript to " + menuName + " menu", mainPage.clickToMenuItemWithJS(menuName));
    }

    @When("Click with javascript to {string} submenu item")
    public void clickWithJavascriptToSimple_Form_DemoSubmenuItem(String submenuName) {
        Assert.assertTrue("Could not click with javascript to " + submenuName + " menu", mainPage.clickToSubmenuItemWithJS(submenuName));
    }
}