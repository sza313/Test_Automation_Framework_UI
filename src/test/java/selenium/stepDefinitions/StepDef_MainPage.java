package selenium.stepDefinitions;

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
        Assert.assertTrue("Could not draw border to "+elementName+" menu",mainPage.drawBorderAroundElement(elementName));

    }


}
