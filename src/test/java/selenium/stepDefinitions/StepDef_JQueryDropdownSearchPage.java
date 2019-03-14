package selenium.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import selenium.pages.JQueryDropdownSearchPage;
import selenium.utils.DriverUtil;

public class StepDef_JQueryDropdownSearchPage extends DriverUtil {

    private JQueryDropdownSearchPage jQueryDropdownSearchPage = new JQueryDropdownSearchPage(driver);

    @And("Click to '(.*)' dropdown field$")
    public void clickToSelectCountryDropdownField(String dropdownField) {
        Assert.assertTrue("Could not click to " + dropdownField + " field.", jQueryDropdownSearchPage.clickOnSelectCountryField(dropdownField));
    }

    @And("Write a '(.*)' into '(.*)' field$")
    public void writeACountryIntoSearchCountryField(String country, String searchField) {
        Assert.assertTrue("Could not write into " + searchField + " field.", jQueryDropdownSearchPage.writeCountryInSearchField(searchField, country));
    }

    @And("Click on '(.*)'$")
    public void clickOnResult(String result) {
        Assert.assertTrue("Could not select from " + result + " dropdown list.", jQueryDropdownSearchPage.selectDropdownListItem(result));
    }

    @Then("The correct '(.*)' is selected in the list$")
    public void validateIfCorrectCountryIsSelected(String country) {
        Assert.assertTrue("Could not select from " + country + " dropdown list.", jQueryDropdownSearchPage.validateChosenCountry(country));
    }
}
