package selenium.stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import selenium.pages.BootstrapAlertsPage;
import selenium.utils.DriverUtil;

public class StepDef_BootstrapAlertPage extends DriverUtil {

   private BootstrapAlertsPage bootstrapAlertPage = new BootstrapAlertsPage(driver);

    @Then("The bootstrap alerts page opens")
    public void validateBootstrapAlertsPageOpens() {
        Assert.assertTrue("The title of the page is not correct.", bootstrapAlertPage.validateBootstrapAlertsPageTitle());
    }

    @When("Click to all of the normal bootstrap alert buttons")
    public void clickToAllOfTheNormalBootstrapAlertButtons() {
        Assert.assertTrue("Could not click to the requested items.", bootstrapAlertPage.clickToAllNormalAlerts());
    }

    @Then("All of the alert messages show up")
    public void validateAllNormalAlertMessageShowsUp() {
        Assert.assertTrue("The expected alert messages did not show up", bootstrapAlertPage.validateNormalAlertMessages());
    }

    @When("Click on '(.*)' button")
    public void clickOnAutoclosableAlertButton(String alertName) {
        Assert.assertTrue("Could not click on the " + alertName + " button", bootstrapAlertPage.clickOnAlertButton(alertName));
    }

    @Then("Then the '(.*)' message disappears after '(.*)' seconds")
    public void validateAutoclosableAlertMessageDisappears(String alertName, int seconds) {
        Assert.assertTrue("The " + alertName + " message did not close after " + seconds + " seconds.", bootstrapAlertPage.validatAutoclosableAlertMessageDisappearsAfterGivenTime(alertName, seconds));
    }
}
