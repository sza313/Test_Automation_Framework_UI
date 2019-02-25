package selenium.stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import selenium.pages.RangeSlidersPage;
import selenium.utils.DriverUtil;

public class StepDef_RangeSlidersPage extends DriverUtil {

    private RangeSlidersPage rangeSlidersPage = new RangeSlidersPage(driver);

    @When("I set the value of the '(.*)' to '(.*)' on the range slider page")
    public void moveSlider(String sliderName, String value) {
        Assert.assertTrue("Could not move the handle of the slider: " + sliderName + " to the requested value", rangeSlidersPage.moveSliderToValue(sliderName, value));
    }

    @Then("The value displayed on the '(.*)' is '(.*)' on the range slider page")
    public void validateSliderOutputValue(String sliderOutputName, String value) {
        Assert.assertTrue("The value on the slider output '" + sliderOutputName + "' is incorrect", rangeSlidersPage.validateSliderOutputValue(sliderOutputName, value));
    }

    @Then("The range sliders page opens")
    public void validateRangeSlidersPageOpens() {
        Assert.assertTrue("The title of the page is not correct.", rangeSlidersPage.validateRangeSlidersPageTitle());
    }
}
