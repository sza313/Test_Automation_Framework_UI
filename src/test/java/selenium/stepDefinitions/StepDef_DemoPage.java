package selenium.stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import selenium.pages.DemoPage;
import selenium.utils.DriverUtil;

public class StepDef_DemoPage extends DriverUtil{
    private DemoPage demoPage = new DemoPage(driver);

    @When("^User clicks to the '(.*)' menu item$")
    public void userClicksToTheComputersMenuItem(String menuName) throws Throwable {
            Assert.assertTrue("Could not click to the "+menuName +" menu item.", demoPage.clickToMenu(menuName));
    }

    @And("^User clicks to the '(.*)' submenu item$")
    public void userClicksToTheDesktopsSubmenuItem(String subMenuName) throws Throwable {
            Assert.assertTrue("Could not click to the "+subMenuName +" menu item.",demoPage.clickToSubmenu(subMenuName));
    }

    @Then("^User is on the '(.*)' page$")
    public void userIsOnTheDesktopsPage(String title) throws Throwable {
        Assert.assertTrue("User is not on the "+title+" page",demoPage.userIsOnTheRightPage(title));
    }

    @When("^User clicks to Add to cart button$")
    public void userClicksToAddToCartButton() throws Throwable {
        Assert.assertTrue("Could not click to add to cart", demoPage.addToCart());
    }

    @When("^User clicks to '(.*)' product$")
    public void userClicksToBuildYourOwnComputerProduct(String productName) throws Throwable {
        Assert.assertTrue("Could not add to cart the following product: "+productName, demoPage.selectProduct(productName));
    }

    @Then("^User wait '(.*)' seconds$")
    public void userWaitSeconds(int seconds) throws Throwable {
        Thread.sleep(seconds*1000);
    }

    @Then("^'(.*)' Item added to the cart successfully$")
    public void itemAddedToTheCartSuccessfully(String number) throws Throwable {
        Assert.assertTrue("Product not added to the cart",demoPage.isAddedToCart(number));
    }
}
