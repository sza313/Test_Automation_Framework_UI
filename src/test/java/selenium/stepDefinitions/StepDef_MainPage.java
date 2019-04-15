package selenium.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import selenium.pages.MainPage;
import selenium.parallel.context.CucumberTestContext;
import selenium.parallel.drivercontroller.DriverController;

public class StepDef_MainPage {
    private final Logger LOG = LogManager.getLogger(getClass());
    private MainPage mainPage;
    private DriverController driverController;
    private CucumberTestContext testContext;

    public StepDef_MainPage(CucumberTestContext testContext) {
        this.testContext = testContext;
        LOG.info("initialized.");
    }

    @Given("Open site with {word}")
    public void openSiteWithBrowser(String browserType) {
        driverController = new DriverController();
        driverController.initializeWebDriver(browserType);
        mainPage = new MainPage(driverController.getWebDriver());
        testContext.setWebDriver(driverController.getWebDriver());
    }

    @And("navigate to url {string}")
    public void navigateToUrl(String url) {
        driverController.getWebDriver().get(url);
    }

    @Given("Open site")
    public void openBrowser() {
        driverController = new DriverController();
        driverController.initializeWebDriver("");
        mainPage = new MainPage(driverController.getWebDriver());
        testContext.setWebDriver(driverController.getWebDriver());

        driverController.getWebDriver().get("https://www.seleniumeasy.com/test/");
    }

    @Given("This step will fail")
    public void thisStepWillFail() {
        Assert.assertTrue("This test should present a failed scenario", false);
    }

    @When("Click to '(.*)' menu item$")
    public void clickToMenuItem(String menuName) {
        Assert.assertTrue("Could not click to " + menuName + " menu", mainPage.clickToMenuItem(menuName));
    }

    @When("Click to '(.*)' submenu item$")
    public void clickToSubmenuItem(String submenuName) {
        Assert.assertTrue("Could not click to " + submenuName + " menu", mainPage.clickToSubmenuItem(submenuName));
    }

    @Then("Draw border around '(.*)'")
    public void drawBorderAroundTheElement(String elementName) {
        Assert.assertTrue("Could not draw border to " + elementName + " menu", mainPage.drawBorderAroundElement(elementName));

    }

    @When("Click with visualization to '(.*)' menu item")
    public void clickWithVisualizationToMenuItem(String menuName) {
        Assert.assertTrue("Could not click to " + menuName + " menu with visualization", mainPage.clickToMenuItemWhitVisualization(menuName));
    }

    @Then("A red border around '(.*)' menu item appears")
    public void validateRedBorderAppears(String menuName) {
        Assert.assertTrue("Couldn't draw border around " + menuName + " menu item.", mainPage.validateRedBorderAppears(menuName));
    }

    @Then("'(.*)' submenu item becomes visible")
    public void validateSubmenuItemIsVisible(String submenuName) {
        Assert.assertTrue(submenuName + " submenu item is not visible.", mainPage.validateSubmenuItemIsVisible(submenuName));
    }

    @When("Click with javascript to '(.*)' element")
    public void clickWithJavascriptToElement(String elementName) {
        Assert.assertTrue("Could not click with javascript to " + elementName + " element", mainPage.clickToElementWithJS(elementName));
    }

    @When("Scroll to the '(.*)' webelement on main page")
    public void scrollToWebelement(String elementName) {
        Assert.assertTrue("Could not scroll to " + elementName + " element", mainPage.scrollToElementOnMainPage(elementName));
    }

    @When("Scroll to the '(.*)' webelement with '(.*)' px offset along the x axis and '(.*)' px offset along the y axis")
    public void scrollToElementWithOffsetOnMainPage(String elementName, int xOffset, int yOffset) {
        Assert.assertTrue("Could not scroll to " + elementName + " element with the requested offsets: X=" + xOffset + ", Y=" + yOffset, mainPage.scrollToElementWithOffsetOnMainPage(elementName, xOffset, yOffset));
    }
}