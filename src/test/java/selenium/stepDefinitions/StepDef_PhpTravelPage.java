package selenium.stepDefinitions;

import cucumber.api.java.en.When;
import selenium.pages.PhpTravelPage;

public class StepDef_PhpTravelPage {
    private PhpTravelPage phpTravelPage = new PhpTravelPage();

    @When("Click to '(.*)' menu item on PhpTravels$")
    public void clickToMenuItem(String menuName) {
        phpTravelPage.clickToMenuItem(menuName);
    }

    @When("Click to '(.*)' submenu item on PhpTravels$")
    public void clickToSubmenuItem(String submenuName) {
        phpTravelPage.clickToSubmenuItem(submenuName);
    }
}
