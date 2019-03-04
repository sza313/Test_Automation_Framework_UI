package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.PhpHotelsPageObjects;
import selenium.pageObjects.PhpLoginPageObjects;

public class PhpHotelsPage extends PhpHotelsPageObjects {

    public PhpHotelsPage(WebDriver driver) {
        super(driver);
    }

    /**clickToMenuItem method calls the clickToElement method and gives the target menu element.
     *
     * @param menuName: This identifies the menu name which will be clicked
     * @return with a boolean to get the navigation status
     */
    public boolean clickToMenuItem(String menuName){

        switch (menuName) {
            case "Search by":
                Assert.assertTrue("Could not click to " + menuName, clickToElement(this.searchByItem));
                return true;
            case "Check in":
                Assert.assertTrue("Could not click to "+menuName, clickToElement(this.checkInItem));
                return true;
            case "Check out":
                Assert.assertTrue("Could not click to "+menuName, clickToElement(this.checkOutItem));
                return true;
            case "Adult child":
                Assert.assertTrue("Could not click to "+menuName, clickToElement(this.adultChildItem));
                return true;
            case "SEARCH":
                Assert.assertTrue("Could not click to "+menuName, clickToElement(this.searchButton));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + menuName);
                return false;
        }
    }

    /**clickToCalendarItem method calls the clickToElement method and gives the target menu element.
     *
     * @param date: This identifies the calendar day which will be clicked
     * @return with a boolean to get the navigation status
     */
    public boolean clickToCalendarItem(String date){

        switch (date) {
            case "next Friday":
                Assert.assertTrue("Could not click to " + date, clickToElement(this.nextFridayItem));
                return true;
            case "one week later":
                Assert.assertTrue("Could not click to "+date, clickToElement(this.oneWeekLaterItem));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + date);
                return false;
        }

    }

    public boolean writeToSimpleFormTextBox(String textBoxName, String text) {
        switch (textBoxName) {
            case "searchBy":
                Assert.assertTrue("Could not write to " + textBoxName + " textbox.", writeIntoTextBox(this.searchByItem, text));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBoxName + " textbox.");
                return false;
        }
    }

}
