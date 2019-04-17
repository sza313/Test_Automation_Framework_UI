package selenium.pages;

import java.time.LocalDate;
import java.time.YearMonth;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.time.format.DateTimeFormatter.ofPattern;
import static java.time.format.TextStyle.SHORT;
import static java.util.Locale.getDefault;

import selenium.pageObjects.BootstrapDatePickerPageObjects;

public class BootstrapDatePickerPage extends BootstrapDatePickerPageObjects {

    private static final String MONTH_YEAR_PATTERN = "MMMM uuuu";
    private static final String DAY_MONTH_YEAR_PATTERN = "d MMM uuuu";
    private static final String MONTH_OR_YEAR = "//span[text() = '%s']";
    private static final String DAY = "//td[text() = '%s']";

    public BootstrapDatePickerPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void validateBootstrapDatePickerPageTitle(String title) {
        Assert.assertTrue("Page title is not as expected.", comparePageTitle(title));
    }

    public void clickOnSelectDate(String datePickerName) {
        switch (datePickerName) {
        case "Start_Date":
            Assert.assertTrue("Could not click to " + datePickerName + " input field.", clickToElement(this.startDateInputField));
            break;
        default:
            Assert.fail("Could not find the requested item: " + datePickerName + " input field.");
        }
    }

    public void validateCorrectDateAppears(String dateString) {
        Assert.assertTrue("The correct date '" + dateString + "' did not appear", dateString.equals(startDateInputField.getAttribute("value")));
    }

    public void selectStartDateFromDropdown(String dateString) {
        LocalDate dateToSet = LocalDate.parse(dateString, ofPattern(DAY_MONTH_YEAR_PATTERN));
        int dayToSet = dateToSet.getDayOfMonth();
        String monthToSet = dateToSet.getMonth()
                                     .getDisplayName(SHORT, getDefault());
        int yearToSet = dateToSet.getYear();

        YearMonth currentlySetYearMonth = YearMonth.parse(monthSwitcher.getText(), ofPattern(MONTH_YEAR_PATTERN));
        int currentlySetYear = currentlySetYearMonth.getYear();
        String currentlySetMonth = currentlySetYearMonth.getMonth()
                                                        .getDisplayName(SHORT, getDefault());
        if (currentlySetYear != yearToSet) {
            Assert.assertTrue("Clicking the month switcher was unsuccessful", clickToElement(monthSwitcher));
            Assert.assertTrue("Clicking the year switcher was unsuccessful", clickToElement(yearSwitcher));
            selectYear(currentlySetYear, yearToSet);
            selectMonth(monthToSet);
        } else if (!currentlySetMonth.equals(monthToSet)) {
            Assert.assertTrue("Clicking the month switcher was unsuccessful", clickToElement(monthSwitcher));
            selectMonth(monthToSet);
        }
        selectDay(dayToSet);
    }

    private void selectYear(int currentlySetYear, int yearToSet) {
        int currentDecade = currentlySetYear / 10;
        int decadeToSet = yearToSet / 10;

        int decadeDifference = Math.abs(decadeToSet - currentDecade);
        if (currentDecade < decadeToSet) {
            for (int i = 0; i < decadeDifference; i++) {
                Assert.assertTrue("Clicking the next decade arrow was unsuccessful", clickToElement(nextDecadeArrow));
            }
        } else if (currentDecade > decadeToSet) {
            for (int i = 0; i < decadeDifference; i++) {
                Assert.assertTrue("Selecting the previous decade arrow was unsuccessful", clickToElement(previousDecadeArrow));
            }
        }
        WebElement year = yearsTable.findElement(By.xpath(String.format(MONTH_OR_YEAR, yearToSet)));
        Assert.assertTrue("Selecting the year was unsuccessful", clickToElement(year));
    }

    private void selectMonth(String monthToSet) {
        WebElement month = monthsTable.findElement(By.xpath(String.format(MONTH_OR_YEAR, monthToSet)));
        Assert.assertTrue("Selecting the month was unsuccessful", clickToElement(month));
    }

    private void selectDay(int dayToSet) {
        WebElement day = daysTable.findElement(By.xpath(String.format(DAY, dayToSet)));
        if (day.getAttribute("class")
               .equals("disabled disabled-date day")) {
            Assert.fail("The requested day is disabled.");
        }
        Assert.assertTrue("Selecting the day was unsuccessful", clickToElement(day));
        Assert.assertTrue("Closing date selection was unsuccessful", clickToElement(textElement_To));
    }
}
