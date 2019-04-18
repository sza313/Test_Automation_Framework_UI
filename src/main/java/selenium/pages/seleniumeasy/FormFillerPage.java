package selenium.pages.seleniumeasy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import selenium.pageObjects.seleniumeasy.FormFillerPageObjects;

public class FormFillerPage extends FormFillerPageObjects {
    private final static Logger LOG = LogManager.getLogger();

    public FormFillerPage(WebDriver webDriver) {
        super(webDriver);
        LOG.info("Formfiller page initialized.");
    }

    public void enterFirstName(String input) {
        Assert.assertTrue("Unable to write first name field.", writeIntoTextBox(getFirstNameTextField(), input));
    }

    public void enterLastName(String input) {
        Assert.assertTrue("Unable to write last name field.", writeIntoTextBox(getLastNameTextField(), input));
    }

    public void enterEmail(String input) {
        Assert.assertTrue("Unable to write email field.", writeIntoTextBox(getEmailTextField(), input));
    }

    public void enterPhoneNumber(String input) {
        Assert.assertTrue("Unable to write phone field.", writeIntoTextBox(getPhoneTextField(), input));
    }

    public void enterAddress(String input) {
        Assert.assertTrue("Unable to write address field.", writeIntoTextBox(getAddressTextField(), input));
    }

    public void enterCity(String input) {
        Assert.assertTrue("Unable to write city field.", writeIntoTextBox(getCityTextField(), input));
    }

    public void enterState(String input) {
        Assert.assertTrue("Unable to write state field.", selectFromDropDown(getStateSelect(), input));
    }

    public void enterZip(String input) {
        Assert.assertTrue("Unable to write zip field.", writeIntoTextBox(getZipTextField(), input));
    }

    public void enterDomain(String input) {
        Assert.assertTrue("Unable to write domain field.", writeIntoTextBox(getWebsiteTextField(), input));
    }

    public void selectRadioButton(String input) {
        Assert.assertTrue("Unable to select domain radio button.", selectFromRadioButton(getRadioButtons(), input));
    }

    public void enterProjectDescription(String input) {
        Assert.assertTrue("Unable to write project description field.", writeIntoTextBox(getProjectDescriptionTextArea(), input));
    }

    public void submitForm() {
        Assert.assertTrue("Unable to write project description field.", clickToElement(getSubmitButton()));
    }

    public void validatePageIsReloaded() {
        Assert.assertTrue("Page is not relaoaded.", getFirstNameTextField().getText()
                                                                           .isEmpty());
    }

}
