package selenium.stepDefinitions;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import selenium.pages.MainPage;
import selenium.pages.PhpSearchResPage;
import selenium.utils.DriverUtil;

public class StepDef_PhpSearchResPage extends DriverUtil {

    private PhpSearchResPage phpSearchResPage = new PhpSearchResPage(driver);

    @Then("I set the value of the '(.*)' section's '(.*)' checkbox to '(.*)' on the Search Result page$")
    public void setTheValueOfCheckBox(String sectionName ,String checkboxName, String checkboxValueToSet) {
        boolean toCheck = Boolean.valueOf(checkboxValueToSet);
        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, phpSearchResPage.clickCheckbox(sectionName,checkboxName, toCheck));
    }

    @Then("I set the value of the '(.*)' to '(.*)' on the Search Result page$")
    public void setSliderToValue(String sliderName ,String value) {
        Assert.assertTrue("Could not move the handle of the slider: " + sliderName + " to the requested value", phpSearchResPage.moveSliderToValue(sliderName, value));
    }

    @Then("Click to '(.*)' item$")
    public void clickToItem(String itemName) {
        Assert.assertTrue("Could not click to " + itemName + " item", phpSearchResPage.clickToItem(itemName));
    }

}
