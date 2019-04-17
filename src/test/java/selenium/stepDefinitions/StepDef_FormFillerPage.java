package selenium.stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import selenium.pages.FormFillerPage;
import selenium.parallel.context.CucumberTestContext;

public class StepDef_FormFillerPage {
    private final static Logger LOG = LogManager.getLogger();
    private FormFillerPage formFillerPage;

    public StepDef_FormFillerPage(CucumberTestContext testContext) {
        formFillerPage = new FormFillerPage(testContext.getWebDriver());
        LOG.info(" initialized.");
    }

    @When("enter {word} for first name")
    public void enterFirstName(String input) {

        Assert.assertTrue("Unable to write first name field.", formFillerPage.writeIntoTextBox(formFillerPage.getFirstNameTextField(), input));
    }

    @When("enter {word} for last name")
    public void enterLastName(String input) {

        Assert.assertTrue("Unable to write last name field.", formFillerPage.writeIntoTextBox(formFillerPage.getLastNameTextField(), input));
    }

    @When("enter {word} for email")
    public void enterEmail(String input) {

        Assert.assertTrue("Unable to write email field.", formFillerPage.writeIntoTextBox(formFillerPage.getEmailTextField(), input));
    }

    @When("enter {word} for phone")
    public void enterPhone(String input) {

        Assert.assertTrue("Unable to write phone field.", formFillerPage.writeIntoTextBox(formFillerPage.getPhoneTextField(), input));
    }

    @When("enter {string} for address")
    public void enterAddress(String input) {

        Assert.assertTrue("Unable to write address field.", formFillerPage.writeIntoTextBox(formFillerPage.getAddressTextField(), input));
    }

    @When("enter {string} for city")
    public void enterCity(String input) {

        Assert.assertTrue("Unable to write city field.", formFillerPage.writeIntoTextBox(formFillerPage.getCityTextField(), input));
    }

    @When("select {string} for state")
    public void enterState(String input) {

        Assert.assertTrue("Unable to write state field.", formFillerPage.selectFromDropDown(formFillerPage.getStateSelect(), input));
    }

    @When("enter {word} for zip")
    public void enterZip(String input) {

        Assert.assertTrue("Unable to write city field.", formFillerPage.writeIntoTextBox(formFillerPage.getZipTextField(), input));
    }

    @When("enter {word} for domain")
    public void enterDomain(String input) {

        Assert.assertTrue("Unable to write domain field.", formFillerPage.writeIntoTextBox(formFillerPage.getWebsiteTextField(), input));
    }

    @When("select radiobutton {word} for hosting")
    public void selectHostingRadioButton(String input) {

        Assert.assertTrue("Unable to select domain radio button.", formFillerPage.selectFromRadioButton(input));
    }

    @When("enter {string} for project description")
    public void enterProjectDescription(String input) {
        Assert.assertTrue("Unable to write project description field.", formFillerPage.writeIntoTextBox(formFillerPage.getProjectDescriptionTextArea(), input));

    }

    @When("submit form")
    public void submitFOrm() {
        Assert.assertTrue("Unable to write project description field.", formFillerPage.clickToElement(formFillerPage.getSubmitButton()));
    }

    @Then("page is reloaded.")
    public void pageIsLoaded() {
        Assert.assertTrue("Page is not relaoaded.", formFillerPage.getFirstNameTextField().getText().isEmpty());
    }
}
