package selenium.stepDefinitions;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import selenium.pages.PhpTestingHotelPage;
import selenium.utils.DriverUtil;

public class StepDef_PhpTestingHotelPage extends DriverUtil {
    private PhpTestingHotelPage phpTesting2HotelPage = new PhpTestingHotelPage(driver);

    @Then("I set the value of the '(.*)' checkbox to '(.*)' on the Testing2 Hotel page$")
    public void setCheckboxValue(String checkboxName, String checkboxValueToSet) {
        boolean toCheck = Boolean.valueOf(checkboxValueToSet);
        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, phpTesting2HotelPage.clickCheckbox(checkboxName, toCheck));
    }

    @Then("Click to '(.*)' button$")
    public void clickToButton(String buttonName) {
        Assert.assertTrue("Could not click to " + buttonName + " item", phpTesting2HotelPage.clickToItem(buttonName));
    }

    @Then("Wait for Confirmation page is loaded$")
    public void waitForPageLoading() {
        Assert.assertTrue("The Confirmation page is not loaded " , waitForPageLoaded());
    }

}
