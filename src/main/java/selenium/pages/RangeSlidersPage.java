package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.RangeSlidersPageObjects;

public class RangeSlidersPage extends RangeSlidersPageObjects {
    public RangeSlidersPage(WebDriver driver) {
        super(driver);
    }

    public boolean moveSliderToValue(String sliderName, String value) {
        int valueToSet = Integer.valueOf(value);
        switch (sliderName) {
            case "Top_Left_Slider":
                Assert.assertTrue("Could not move the handle of the slider: "+sliderName+" to the requested value.", moveRangeSliderToValue(this.topLeftSlider, valueToSet));
                return true;
            default:
                Assert.fail("Could not find the requested item: " +sliderName+ " .");
                return false;
        }
    }

    public boolean validateSliderOutputValue(String sliderOutputName, String value) {
        int expectedOutputValue = Integer.valueOf(value);
        switch (sliderOutputName) {
            case "Top_Left_Slider_Output":
                int actualOutputValue = Integer.valueOf(this.topLeftSliderOutput.getAttribute("value"));
                return actualOutputValue==expectedOutputValue;
            default:
                Assert.fail("Could not find the requested item: " +sliderOutputName+ " .");
                return false;
        }
    }
}
