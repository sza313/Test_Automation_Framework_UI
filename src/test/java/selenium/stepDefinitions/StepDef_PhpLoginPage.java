package selenium.stepDefinitions;

import cucumber.api.java.en.When;
import org.junit.Assert;
import selenium.pages.PhpLoginPage;
import selenium.utils.DriverUtil;
import java.util.concurrent.TimeUnit;

public class StepDef_PhpLoginPage extends DriverUtil {
    private PhpLoginPage phpLoginPage = new PhpLoginPage(driver);

    @When("Login to the PhpTravels page$")
    public void loginToPhpTravelPage() throws Throwable{
        Assert.assertTrue("Could not clear the text box Email" , phpLoginPage.clearLoginElement("Email"));
        Assert.assertTrue("Could not clear the text box Password" , phpLoginPage.clearLoginElement("Password"));

        Assert.assertTrue("Could not send the text to the text box Email" , phpLoginPage.sendLoginText("Email",properties.getProperty("Email_php")));
        Assert.assertTrue("Could not send the text to the text box Password" , phpLoginPage.sendLoginText("Password",properties.getProperty("Password_php")));

        //Thread.sleep(2000); //If you want to see it for longer time
        Assert.assertTrue("Could not click the item Login" , phpLoginPage.clickLoginItem("Login"));

    }

    @When("Wait for My Account page is loaded$")
    public void waitForPageLoading() throws Throwable{
        Assert.assertTrue("The My Account page is not loaded " , phpLoginPage.validatePageLoading());
    }

}
