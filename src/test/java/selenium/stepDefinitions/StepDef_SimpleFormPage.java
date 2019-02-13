package selenium.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import selenium.pages.SimpleFormPage;
import selenium.utils.DriverUtil;

public class StepDef_SimpleFormPage extends DriverUtil {

    private SimpleFormPage simpleFormPage = new SimpleFormPage(driver);

    @Given("the simple forms page is open")
    public void openSimpleFormPage() {
        String url;

        if (System.getProperty("url") != null) {
            url = System.getProperty("url");
        } else if (properties.getProperty("url") != null) {
            url = properties.getProperty("url");
        } else {
            url = "https://www.seleniumeasy.com/test/";
        }
        driver.get(url + "basic-first-form-demo.html");
    }

    @When("I write a '(.*)' to the '(.*)' textbox$")
    public void writeToSimpleFormTextBox(String text, String textBoxName) {
        Assert.assertTrue("Could not write to "+textBoxName+" menu", simpleFormPage.writeToSimpleFormTextBox(textBoxName, text));
    }
}
