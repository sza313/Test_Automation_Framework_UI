package selenium.stepDefinitions.seleniumeasy;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import selenium.pages.seleniumeasy.SeleniumEasyMainPage;
import selenium.parallel.context.CucumberTestContext;
import selenium.parallel.drivercontroller.DriverController;

public class MainPageStepDefinition {
    private final Logger LOG = LogManager.getLogger(getClass());
    private SeleniumEasyMainPage seleniumEasyMainPage;
    private DriverController driverController;
    private CucumberTestContext testContext;

    public MainPageStepDefinition(CucumberTestContext testContext) {
        this.testContext = testContext;
        LOG.info("initialized.");
    }

    @Given("Open site with {word}")
    public void openSiteWithBrowser(String browserType) {
        driverController = new DriverController();
        driverController.initializeWebDriver(browserType);
        seleniumEasyMainPage = new SeleniumEasyMainPage(driverController.getWebDriver());
        testContext.setWebDriver(driverController.getWebDriver());

    }

    @And("navigate to url {string}")
    public void navigateToUrl(String url) {
        driverController.getWebDriver()
                .get(url);
    }

    @Given("Open site")
    public void openBrowser() {
        this.openSiteWithBrowser("");
        driverController.getWebDriver()
                .get("https://www.seleniumeasy.com/test/");
    }

    @Given("This step will fail")
    public void thisStepWillFail() {
        seleniumEasyMainPage.failTheTest();
    }

    @When("Click to '(.*)' menu item$")
    public void clickToMenuItem(String menuName) {
        seleniumEasyMainPage.clickToMenuItem(menuName);
    }

    @When("Click to '(.*)' submenu item$")
    public void clickToSubmenuItem(String submenuName) {
        seleniumEasyMainPage.clickToSubmenuItem(submenuName);
    }

    @Then("Draw border around '(.*)'")
    public void drawBorderAroundTheElement(String elementName) {
        seleniumEasyMainPage.drawBorderAroundElement(elementName);
    }

    @When("Click with visualization to '(.*)' menu item")
    public void clickWithVisualizationToMenuItem(String menuName) {
        seleniumEasyMainPage.clickToMenuItemWhitVisualization(menuName);
    }

    @Then("A red border around '(.*)' menu item appears")
    public void validateRedBorderAppears(String menuName) {
        seleniumEasyMainPage.validateRedBorderAppears(menuName);
    }

    @Then("'(.*)' submenu item becomes visible")
    public void validateSubmenuItemIsVisible(String submenuName) {
        seleniumEasyMainPage.validateSubmenuItemIsVisible(submenuName);
    }

    @When("Click with javascript to '(.*)' element")
    public void clickWithJavascriptToElement(String elementName) {
        seleniumEasyMainPage.clickToElementWithJS(elementName);
    }

    @When("Scroll to the '(.*)' webelement on main page")
    public void scrollToWebelement(String elementName) {
        seleniumEasyMainPage.scrollToElementOnMainPage(elementName);
    }

    @When("Scroll to the '(.*)' webelement with '(.*)' px offset along the x axis and '(.*)' px offset along the y axis")
    public void scrollToElementWithOffsetOnMainPage(String elementName, int xOffset, int yOffset) {
        seleniumEasyMainPage.scrollToElementWithOffsetOnMainPage(elementName, xOffset, yOffset);
    }
}