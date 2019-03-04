package selenium.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import selenium.pages.PhpLoginPage;
import selenium.pages.PhpMyAccountPage;
import selenium.utils.DriverUtil;

public class stepDef_PhpMyAccountPage extends DriverUtil {
    private PhpMyAccountPage phpMyAccountPage = new PhpMyAccountPage(driver);

    @Then("Click to '(.*)' menu item on MyAccount page$")
    public void clickToMenuItem(String menuName) {
        Assert.assertTrue("Could not click to " + menuName + " menu", phpMyAccountPage.clickToMenuItem(menuName));
    }

    @And("Wait for HOTELS page is loaded$")
    public void waitForPageLoading() {
        Assert.assertTrue("The HOTELS page is not loaded " , waitForPageLoaded());
    }
}
