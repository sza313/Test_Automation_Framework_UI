package selenium.stepDefinitions;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import selenium.pages.PhpConfirmationPage;
import selenium.utils.DriverUtil;

public class stepDef_PhpConfirmationPage extends DriverUtil {
    private PhpConfirmationPage phpConfirmationPage = new PhpConfirmationPage(driver);

    @Then("Click to '(.*)' button on Confirmation page$")
    public void clickToButton(String buttonName) {
        Assert.assertTrue("Could not click to " + buttonName + " item", phpConfirmationPage.clickToItem(buttonName));
    }

    @Then("Wait for Preliminary page is loaded$")
    public void waitForPageLoadingPreliminary() {
        Assert.assertTrue("The preliminary page is not loaded " , waitForPageLoaded());
    }

    @Then("Wait until '(.*)' element is visible$")
    public void waitForInvoiceElementVisible(String element) {
        Assert.assertTrue("The Invoice element is not visible " , phpConfirmationPage.waitForElement(element));
    }

    @Then("Wait for Invoice page is loaded$")
    public void waitForPageLoading() {
        Assert.assertTrue("The Invoice page is not loaded " , waitForPageLoaded());
    }

}
