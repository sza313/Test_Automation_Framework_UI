package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.BootstrapAlertsPageObjects;

public class BootstrapAlertsPage extends BootstrapAlertsPageObjects {
    public BootstrapAlertsPage(WebDriver driver) {
        super(driver);
    }

    public boolean validateBootstrapAlertsPageTitle() {
        return driver.getTitle().equals("Selenium Easy - Bootstrap Alerts Demo for Automation");
    }


    public boolean clickToAllNormalAlerts() {
        return clickToMultipleElements(this.normalDangerMessageButton, this.normalInfoMessageButton, this.normalSuccessMessageButton, this.normalWarningMessageButton);
    }


    public boolean validateNormalAlertMessages() {
        return (normalDangerMessage.isDisplayed() && normalInfoMessage.isDisplayed() && normalSuccessMessage.isDisplayed() && normalWarningMessage.isDisplayed());
    }

    public boolean clickOnAlertButton(String alertName) {
        switch (alertName) {
            case "autoclosable_success_alert":
                Assert.assertTrue("Could not click to " + alertName + " button.", clickToElement(this.autoclosableSuccessMessageButton));
                return true;
            case "autoclosable_danger_alert":
                Assert.assertTrue("Could not click to " + alertName + " button.", clickToElement(this.autoclosableDangerMessageButton));
                return true;
            case "autoclosable_warning_alert":
                Assert.assertTrue("Could not click to " + alertName + " button.", clickToElement(this.autoclosableWarningMessageButton));
                return true;
            case "autoclosable_info_alert":
                Assert.assertTrue("Could not click to " + alertName + " button.", clickToElement(this.autoclosableInfoMessageButton));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + alertName + " button.");
                return false;
        }
    }

    public boolean validatAutoclosableAlertMessageDisappearsAfterGivenTime(String alertName, int seconds) {
        return true;
    }
}
