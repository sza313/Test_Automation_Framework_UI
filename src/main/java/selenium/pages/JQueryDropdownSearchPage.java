package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.JQueryDropdownSearchPageObjects;

public class JQueryDropdownSearchPage extends JQueryDropdownSearchPageObjects {

    public JQueryDropdownSearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean writeIntoFieldAndSelectAutosuggestion (String dropDown, String text) {
        switch (dropDown) {
            case "Dropdown":
                Assert.assertTrue("Could not write to " + dropDown + " dropDown field.", autoSuggestionField(this.selectCountryField, text));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + dropDown);
                return false;
        }
    }

    public boolean validateChosenItemInDropdown(String chosenText) {
        return validateString(this.selectCountryJapan, chosenText);
    }
}
