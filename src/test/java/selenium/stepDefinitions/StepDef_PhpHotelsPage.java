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

    @Then("Click the '(.*)' search result")
    public void clickSearchResultOnHotels(String item) {
        Assert.assertTrue("Could not click to " + item + " search result",phpHotelsPage.clickToSearchResultItem(item));
    }

    @Then("Click '(.*)' in the calendar$")
    public void clickToCalendarDay(String date){
        Assert.assertTrue("It was not possible click to "+date,phpHotelsPage.clickToCalendarItem(date));
    }

    @Then("Increase child numbers by (.*)$")
    public void increaseChildNumber(int number) {
        Assert.assertTrue("Could not increase children number",phpHotelsPage.clickToIncreaseItem(number));
    }

    @And("Wait for SEARCH page is loaded$")
    public void waitForPageLoading() {
        Assert.assertTrue("The SEARCH page is not loaded " , waitForPageLoaded());
    }

}
