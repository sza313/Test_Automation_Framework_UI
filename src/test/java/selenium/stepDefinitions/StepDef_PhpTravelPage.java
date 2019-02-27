package selenium.stepDefinitions;

import cucumber.api.java.en.When;
import org.junit.Assert;
import selenium.pages.PhpTravelPage;
import selenium.utils.DriverUtil;


public class StepDef_PhpTravelPage extends DriverUtil {
    private PhpTravelPage phpTravelPage = new PhpTravelPage(driver);

    @When("Click to '(.*)' menu item on PhpTravels$")
    public void clickToMenuItem(String menuName) {
        Assert.assertTrue("Could not click to " + menuName + " menu", phpTravelPage.clickToMenuItem(menuName));
    }

    @When("Click to '(.*)' submenu item on PhpTravels$")
    public void clickToSubmenuItem(String submenuName) {
        Assert.assertTrue("Could not click to " + submenuName + " menu", phpTravelPage.clickToSubmenuItem(submenuName));
    }
}
