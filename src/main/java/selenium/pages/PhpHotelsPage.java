package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public boolean clickToMenuItem(String menuName) {

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

    public boolean clickToSearchResultItem(String pos){

        switch (pos) {
            case "first":
                Assert.assertTrue("Could not click to " + pos, clickToElement(this.searchByResultItem));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + pos);
                return false;
        }

    }

    public boolean clickToIncreaseItem(int number) {
        if(number>=1) {
            Integer timeout = Integer.valueOf(properties.getProperty("timeout"));
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            for (int i = 0; i < number; i++) {
                Assert.assertTrue("Could not increase the item", clickToElement(this.childPlusButton));
                wait.until(ExpectedConditions.elementToBeClickable(this.childPlusButton));
            }
            return true;
        }
            Assert.fail("The number is not suitable to increase Item");
            return false;
    }

    public boolean writeToSimpleFormTextBox(String textBoxName, String text) {
        switch (textBoxName) {
            case "searchBy":
                Assert.assertTrue("Could not write to " + textBoxName + " textbox.", writeIntoTextBox(this.searchByInputItem, text));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + textBoxName + " textbox.");
                return false;
        }
    }

}
