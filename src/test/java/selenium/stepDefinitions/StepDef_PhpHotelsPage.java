package selenium.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import selenium.pages.PhpHotelsPage;
import selenium.utils.DriverUtil;

public class StepDef_PhpHotelsPage extends DriverUtil {
    private PhpHotelsPage phpHotelsPage = new PhpHotelsPage(driver);

    @Then("Click to '(.*)' menu item on Hotels page$")
    public void clickItemsOnHotels(String item) {
        Assert.assertTrue("Could not click to " + item + " menu",phpHotelsPage.clickToMenuItem(item));
    }

    @Then("Write '(.*)' to the '(.*)' box$")
    public void writeTextOnHotels(String text, String textBox) {
        Assert.assertTrue("It was not possible to write text "+text,phpHotelsPage.writeToSimpleFormTextBox(textBox,text));
    }

    @And("Wait for SEARCH page is loaded$")
    public void waitForPageLoading() {
        Assert.assertTrue("The SEARCH page is not loaded " , waitForPageLoaded());
    }

}
