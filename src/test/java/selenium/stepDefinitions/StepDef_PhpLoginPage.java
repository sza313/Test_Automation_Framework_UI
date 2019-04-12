package selenium.stepDefinitions;

import cucumber.api.java.en.When;
import selenium.pages.PhpLoginPage;

public class StepDef_PhpLoginPage {
    private PhpLoginPage phpLoginPage = new PhpLoginPage();

    @When("Login to the PhpTravels page$")
    public void loginToPhpTravelPage() {
        phpLoginPage.enterLoginCredentialAndClickLogin();
    }

    @When("Wait for My Account page is loaded$")
    public void waitForPageLoading() {
        phpLoginPage.validatePageLoading();
    }

}
