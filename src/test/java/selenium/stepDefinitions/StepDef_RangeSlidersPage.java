package selenium.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.pages.RangeSlidersPage;
import selenium.parallel.context.CucumberTestContext;

public class StepDef_RangeSlidersPage {
    private final static Logger LOG = LogManager.getLogger();
    private RangeSlidersPage rangeSlidersPage;

    public StepDef_RangeSlidersPage(CucumberTestContext testContext) {
        rangeSlidersPage = new RangeSlidersPage(testContext.getWebDriver());
        LOG.info("initialized.");
    }

    @When("I set the value of the '(.*)' to '(.*)' on the range slider page")
    public void moveSlider(String sliderName, String value) {
        rangeSlidersPage.moveSliderToValue(sliderName, value);
    }

    @Then("The value displayed on the '(.*)' is '(.*)' on the range slider page")
    public void validateSliderOutputValue(String sliderOutputName, String value) {
        rangeSlidersPage.validateSliderOutputValue(sliderOutputName, value);
    }

    @Then("The range sliders page opens")
    public void validateRangeSlidersPageOpens() {
        rangeSlidersPage.validateRangeSlidersPageTitle();
    }
}
