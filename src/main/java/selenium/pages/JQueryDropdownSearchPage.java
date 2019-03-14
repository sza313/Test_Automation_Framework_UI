package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.JQueryDropdownSearchPageObjects;

public class JQueryDropdownSearchPage extends JQueryDropdownSearchPageObjects {

    public JQueryDropdownSearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean clickOnSelectCountryField(String dropdown) {
        switch (dropdown) {
            case "Select_country":
                Assert.assertTrue("Could not click on " + dropdown + " dropdown field.", clickToElement(this.selectCountryField));
                return true;
            default:
                Assert.fail("Could not find the requested element: " + dropdown);
                return false;
        }
    }

    public boolean writeCountryInSearchField(String searchField, String country) {
        switch (searchField) {
            case "Search_country":
                Assert.assertTrue("Could not write into " + searchField + " field.", writeIntoTextBox(this.searchField, country));
                return true;
            default:
                Assert.fail("Could not find the requested element: " + searchField);
                return false;
        }
    }

    public boolean selectDropdownListItem(String result) {
        switch (result) {
            case "Result":
                Assert.assertTrue("Could not click on the following country: " + result, clickToElement(resultCountry));
                return true;
            default:
                Assert.fail("Could not find the requested element: " + result);
                return false;
        }
    }

    public boolean validateChosenCountry(String country) {
            return compareString(this.displayedCountry, country);
    }
}

