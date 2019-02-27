package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.PhpLoginPageObjects;

public class PhpLoginPage extends PhpLoginPageObjects {

    public PhpLoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * clearLoginElement method calls the clearTextBox method and gives the target menu element.
     *
     * @param loginElement: This identifies the text box which will be cleared
     * @return with a boolean to get the navigation status
     */
    public boolean clearLoginElement(String loginElement) {

        switch (loginElement) {
            case "Email":
                Assert.assertTrue("Could not click to " + loginElement, clearTextBox(this.inputEmail));
                return true;
            case "Password":
                Assert.assertTrue("Could not click to " + loginElement, clearTextBox(this.inputPassword));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + loginElement);
                return false;
        }

    }

    /**
     * sendLoginText method calls the writeIntoTextBox method to write login text to the loginElement.
     *
     * @param loginElement: This identifies the text box which will be cleared
     * @param text:         This should be read from property file
     * @return with a boolean to get the navigation status
     */
    public boolean sendLoginText(String loginElement, String text) {

        switch (loginElement) {
            case "Email":
                Assert.assertTrue("Could not click to " + loginElement, writeIntoTextBox(this.inputEmail, text));
                return true;
            case "Password":
                Assert.assertTrue("Could not click to " + loginElement, writeIntoTextBox(this.inputPassword, text));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + loginElement);
                return false;
        }

    }

    /**
     * clickLoginItem method calls the clickToElement method and gives the target login element.
     *
     * @param login: This identifies the element which will be clicked
     * @return with a boolean to get the navigation status
     */
    public boolean clickLoginItem(String login) {

        switch (login) {
            case "Login":
                Assert.assertTrue("Could not click to " + login, clickToElement(this.loginItem));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + login);
                return false;
        }
    }

    /**
     * validatePageLoading method calls the waitForPageLoaded method for waiting the new page loading.
     * @param
     * @return with a boolean to get the navigation status
     */
    public boolean validatePageLoading() throws Throwable{
        return waitForPageLoaded();
    }


}
