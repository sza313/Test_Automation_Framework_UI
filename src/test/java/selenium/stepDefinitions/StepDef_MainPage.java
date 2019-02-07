package selenium.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import selenium.pages.MainPage;
import selenium.utils.DriverUtil;

public class StepDef_MainPage extends DriverUtil {

    private MainPage mainPage = new MainPage(driver);

    @Given("Open site")
    public void openChromeBrowser() {
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

    @When("Click to '(.*)' menu item$")
    public void clickToMenuItem(String menuName){
        Assert.assertTrue("Could not click to "+menuName+" menu", mainPage.clickToMenuItem(menuName));
    }

}
