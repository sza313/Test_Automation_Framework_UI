package selenium.pages.seleniumeasy;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.seleniumeasy.RangeSlidersPageObjects;

public class RangeSlidersPage extends RangeSlidersPageObjects {

    public RangeSlidersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void moveSliderToValue(String sliderName, String value) {
        int valueToSet = Integer.valueOf(value);
        switch (sliderName) {
            case "Top_Left_Slider":
                Assert.assertTrue("Could not move the handle of the slider: " + sliderName + " to the requested value.", moveRangeSliderToValue(this.topLeftSlider, valueToSet));
                break;
            default:
                Assert.fail("Could not find the requested item: " + sliderName + " .");
        }
    }

    public void validateSliderOutputValue(String sliderOutputName, String value) {
        int expectedOutputValue = Integer.valueOf(value);
        switch (sliderOutputName) {
            case "Top_Left_Slider_Output":
                int actualOutputValue = Integer.valueOf(this.topLeftSliderOutput.getAttribute("value"));
                Assert.assertTrue(String.format("The actual slider value was different than the expected. Actual: %d, Expected: %d", actualOutputValue, expectedOutputValue),
                        actualOutputValue == expectedOutputValue);
                break;
            default:
                Assert.fail("Could not find the requested item: " + sliderOutputName + " .");
        }
    }

    public void validateRangeSlidersPageTitle() {
        Assert.assertTrue("The page title was incorrect.", comparePageTitle("Selenium Easy - Drag and Drop Range Sliders"));
    }
}
