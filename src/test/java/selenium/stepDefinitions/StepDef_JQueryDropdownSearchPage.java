package selenium.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import selenium.pages.JQueryDropdownSearchPage;
import selenium.utils.DriverUtil;

public class StepDef_JQueryDropdownSearchPage extends DriverUtil {

    private JQueryDropdownSearchPage jQueryDropdownSearchPage = new JQueryDropdownSearchPage(driver);

    @And("I start to type '(.*)' to the Select country '(.*)' field and hit enter$")
    public void enterCharacters(String text, String dropDown) {
        Assert.assertTrue("Could not write to " + dropDown + " dropdown field", jQueryDropdownSearchPage.writeIntoFieldAndSelectAutosuggestion(dropDown, text));
    }

    @Then("Appropriate '(.*)' is selected in the '(.*)' field$")
    public void appropriateCountryIsSelectedInTheDropdownField(String chosenText, String dropdown) {
        Assert.assertTrue("Could not write to dropdown field", jQueryDropdownSearchPage.validateChosenItemInDropdown(chosenText));
    }
}
