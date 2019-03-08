package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.pageObjects.BootstrapDatePickerPageObjects;
import selenium.utils.Log;

public class BootstrapDatePickerPage extends BootstrapDatePickerPageObjects {
    public BootstrapDatePickerPage(WebDriver driver) {
        super(driver);
    }

    public boolean validateBootstrapDatePickerPageTitle() {
        return driver.getTitle().equals("Selenium Easy - Best Demo website for Bootstrap Date picker");
    }


    public boolean clickOnSelectDate(String datePickerName) {
        switch (datePickerName) {
            case "Start_Date":
                Assert.assertTrue("Could not click to " + datePickerName + " input field.", clickToElement(this.startDateInputField));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + datePickerName + " input field.");
                return false;
        }
    }


    public boolean validateCorrectDateAppears(String dateString) {
        return dateString.equals(startDateInputField.getAttribute("value"));
    }


    public boolean selectStartDateFromDropdown(String dateString) {
        String dayToSet = dateString.split(" ")[0];
        String monthToSet = dateString.split(" ")[1];
        int yearToSet = Integer.parseInt(dateString.split(" ")[2]);

        String currentlySetMonth = monthSwitcher.getText().split(" ")[0];
        int currentlySetYear = Integer.parseInt(monthSwitcher.getText().split(" ")[1]);
        int currentDecade = currentlySetYear / 10 * 10;
        if (currentlySetYear != yearToSet) {
            clickToElement(monthSwitcher);
            clickToElementWithJS(yearSwitcher);

            int decadeDifference = Math.abs((yearToSet - currentDecade) / 10);
            if (currentDecade + 10 < yearToSet) {
                for (int i = 0; i < decadeDifference; i++) {
                    clickToElement(nextDecadeArrow);
                }
            }
            if (currentDecade > yearToSet) {
                for (int i = 0; i < decadeDifference + 1; i++) {
                    clickToElement(previousDecadeArrow);
                }
            }

            for (WebElement year : this.yearList) {
                if (Integer.parseInt(year.getText()) == (yearToSet)) {
                    clickToElement(year);
                    break;
                }
            }
            selectMonth(monthToSet);
        }
        if (!currentlySetMonth.startsWith(monthToSet) && currentlySetYear == yearToSet) {
            clickToElement(monthSwitcher);
            selectMonth(monthToSet);
        }

        for (WebElement day : this.dayList) {
            if (day.getText().equals(dayToSet)) {
                if (day.getAttribute("class").equals("disabled disabled-date day")) {
                    Log.error("The requested day is disabled.");
                    return false;
                }
                clickToElement(day);
                break;
            }
        }
        clickToElement(textElement_To);
        return true;
    }

    public void selectMonth(String monthToSet) {
        for (WebElement month : this.monthList) {
            if (month.getText().startsWith(monthToSet)) {
                clickToElement(month);
                break;
            }
        }
    }
}
