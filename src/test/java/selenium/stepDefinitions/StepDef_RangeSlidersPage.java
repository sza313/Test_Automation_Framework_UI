package selenium.stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.pages.RangeSlidersPage;

public class StepDef_RangeSlidersPage {

    private RangeSlidersPage rangeSlidersPage = new RangeSlidersPage();

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
