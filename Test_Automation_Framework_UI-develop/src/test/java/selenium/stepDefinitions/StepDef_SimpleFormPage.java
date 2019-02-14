package selenium.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import selenium.pages.SimpleFormPage;
import selenium.utils.DriverUtil;

public class StepDef_SimpleFormPage extends DriverUtil {

    private SimpleFormPage simpleFormPage = new SimpleFormPage(driver);

    @Given("Open SimpleForm Page")
    public void openSimpleFormPage() {
        String simpleFormUrl;

        if (System.getProperty("url") != null) {
            simpleFormUrl = System.getProperty("url");
        } else if (properties.getProperty("url") != null) {
            simpleFormUrl = properties.getProperty("url");
        } else {
            simpleFormUrl = "https://www.seleniumeasy.com/test/basic-first-form-demo.html/";
        }
        driver.get(simpleFormUrl);
    }

    @When("I write to textbox '(.*)' '(.*)' characters$")
    public void writeRandomAlphabeticStringIntoTheTextbox(String textBox, int chars) {
        Assert.assertTrue("Could not write to "+ textBox +" field", simpleFormPage.writeRandomAlphabeticStringToMessageField(textBox, 20));
    }

    @When("I write to textbox '(.*)' '(.*)' characters$")
    public void writeRandomNumericStringIntoTheTextbox(String textBox, int chars) {
        Assert.assertTrue("Could not write to "+ textBox +" field", simpleFormPage.writeRandomNumericStringToMessageField(textBox, 20));
    }

    @When("I write to textbox '(.*)' '(.*)' characters$")
    public void writeRandomAlphanumericStringIntoTheTextbox(String textBox, int chars) {
        Assert.assertTrue("Could not write to "+ textBox +" field", simpleFormPage.writeRandomAlphanumericStringToMessageField(textBox, 20));
    }

    @And("Click Show Message button")
    public void clickShowMessageButton(String button) {
    }

    @When("Using method to remove the text with backspace")
    public void usingMethodToRemoveTheTextWithBackspace() {
    }
}
