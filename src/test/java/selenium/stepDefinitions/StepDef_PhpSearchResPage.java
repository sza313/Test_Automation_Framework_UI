package selenium.stepDefinitions;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import selenium.pages.MainPage;
import selenium.pages.PhpSearchResPage;
import selenium.utils.DriverUtil;

public class StepDef_PhpSearchResPage extends DriverUtil {

    private PhpSearchResPage phpSearchResPage = new PhpSearchResPage(driver);

    @Then("I set the value of the '(.*)' checkbox to '(.*)' on the checkbox page$")
    public void setTheValueOfCheckBox(String checkboxName, String checkboxValueToSet) {
        boolean toCheck = Boolean.valueOf(checkboxValueToSet);
        Assert.assertTrue("Could not set the value of the following checkbox: " + checkboxName, phpSearchResPage.clickCheckbox(checkboxName, toCheck));
    }

}
