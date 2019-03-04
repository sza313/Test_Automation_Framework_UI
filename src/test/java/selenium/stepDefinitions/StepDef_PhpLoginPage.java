package selenium.stepDefinitions;

import cucumber.api.java.en.When;
import org.junit.Assert;
import selenium.pages.PhpLoginPage;
import selenium.utils.DriverUtil;

public class StepDef_PhpLoginPage extends DriverUtil {
    private PhpLoginPage phpLoginPage = new PhpLoginPage(driver);

    @When("Login to the PhpTravels page$")
    public void loginToPhpTravelPage() {
        Assert.assertTrue("The login process was not successful",phpLoginPage.login());
    }

    @When("Wait for My Account page is loaded$")
    public void waitForPageLoading() {
        Assert.assertTrue("The My Account page is not loaded " , phpLoginPage.validatePageLoading());
    }

}
