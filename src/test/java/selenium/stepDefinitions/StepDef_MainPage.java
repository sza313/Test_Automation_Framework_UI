package selenium.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.pages.MainPage;

public class StepDef_MainPage {

    private MainPage mainPage = new MainPage();

    @Given("Open site")
    public void openBrowser() {
        mainPage.opensite();
    }

    @Given("This step will fail")
    public void thisStepWillFail() {
        mainPage.failTheTest();
    }

    @When("Click to '(.*)' menu item$")
    public void clickToMenuItem(String menuName) {
        mainPage.clickToMenuItem(menuName);
    }

    @When("Click to '(.*)' submenu item$")
    public void clickToSubmenuItem(String submenuName) {
        mainPage.clickToSubmenuItem(submenuName);
    }

    @Then("Draw border around '(.*)'")
    public void drawBorderAroundTheElement(String elementName) {
        mainPage.drawBorderAroundElement(elementName);
    }

    @When("Click with visualization to '(.*)' menu item")
    public void clickWithVisualizationToMenuItem(String menuName) {
        mainPage.clickToMenuItemWhitVisualization(menuName);
    }

    @Then("A red border around '(.*)' menu item appears")
    public void validateRedBorderAppears(String menuName) {
        mainPage.validateRedBorderAppears(menuName);
    }

    @Then("'(.*)' submenu item becomes visible")
    public void validateSubmenuItemIsVisible(String submenuName) {
        mainPage.validateSubmenuItemIsVisible(submenuName);
    }

    @When("Click with javascript to '(.*)' element")
    public void clickWithJavascriptToElement(String elementName) {
        mainPage.clickToElementWithJS(elementName);
    }

    @When("Scroll to the '(.*)' webelement on main page")
    public void scrollToWebelement(String elementName) {
        mainPage.scrollToElementOnMainPage(elementName);
    }

    @When("Scroll to the '(.*)' webelement with '(.*)' px offset along the x axis and '(.*)' px offset along the y axis")
    public void scrollToElementWithOffsetOnMainPage(String elementName, int xOffset, int yOffset) {
        mainPage.scrollToElementWithOffsetOnMainPage(elementName, xOffset, yOffset);
    }
}