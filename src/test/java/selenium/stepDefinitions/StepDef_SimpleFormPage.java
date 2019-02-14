package selenium.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import selenium.pages.SimpleFormPage;
import selenium.utils.DriverUtil;

public class StepDef_SimpleFormPage extends DriverUtil {

    private SimpleFormPage simpleFormPage = new SimpleFormPage(driver);

    @When("I write a '(.*)' to the '(.*)' textbox on the simple form page$")
    public void writeToSimpleFormTextBox(String text, String textBoxName) {
        Assert.assertTrue("Could not write to "+textBoxName+" menu", simpleFormPage.writeToSimpleFormTextBox(textBoxName, text));
    }
}
