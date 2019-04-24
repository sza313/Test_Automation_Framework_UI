package selenium.stepDefinitions.seleniumeasy;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import selenium.pages.seleniumeasy.FormFillerPage;
import selenium.parallel.context.CucumberTestContext;

public class FormFillerPageStepDefinition {
    private final static Logger LOG = LogManager.getLogger();
    private FormFillerPage formFillerPage;

    public FormFillerPageStepDefinition(CucumberTestContext testContext) {
        formFillerPage = new FormFillerPage(testContext.getWebDriver());
        LOG.info(" initialized.");
    }

    @When("enter {word} for first name")
    public void enterFirstName(String input) {
        formFillerPage.enterFirstName(input);
    }

    @When("enter {word} for last name")
    public void enterLastName(String input) {
        formFillerPage.enterLastName(input);
    }

    @When("enter {word} for email")
    public void enterEmail(String input) {
        formFillerPage.enterEmail(input);
    }

    @When("enter {word} for phone")
    public void enterPhone(String input) {
        formFillerPage.enterPhoneNumber(input);
    }

    @When("enter {string} for address")
    public void enterAddress(String input) {
        formFillerPage.enterAddress(input);
    }

    @When("enter {string} for city")
    public void enterCity(String input) {
        formFillerPage.enterCity(input);
    }

    @When("select {string} for state")
    public void enterState(String input) {
        formFillerPage.enterState(input);
    }

    @When("enter {word} for zip")
    public void enterZip(String input) {
        formFillerPage.enterZip(input);
    }

    @When("enter {word} for domain")
    public void enterDomain(String input) {
        formFillerPage.enterDomain(input);
    }

    @When("select radiobutton {word} for hosting")
    public void selectHostingRadioButton(String input) {
        formFillerPage.selectRadioButton(input);
    }

    @When("enter {string} for project description")
    public void enterProjectDescription(String input) {
        formFillerPage.enterProjectDescription(input);
    }

    @When("submit form")
    public void submitForm() {
        formFillerPage.submitForm();
    }

    @Then("page is reloaded.")
    public void pageIsLoaded() {
        formFillerPage.validatePageIsReloaded();
    }
}
