package selenium.pages.phptravels;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import selenium.pageObjects.phptravels.PhpLoginPageObjects;

public class PhpLoginPage extends PhpLoginPageObjects {

    public PhpLoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * login method calls the login method that starts a commom login/password/submit procedure.
     * 
     * @return with a boolean to get the navigation status
     */
    public void enterLoginCredentialAndClickLogin() {
        String username = getProperties().getProperty("Email_php");
        Assert.assertTrue("Could not write into the email field.", writeIntoTextBox(this.inputEmail, username));
        String password = getProperties().getProperty("Password_php");
        Assert.assertTrue("Could not write into the password field.", writeIntoTextBox(this.inputPassword, password));

        Assert.assertTrue("The login process was not successful", clickToElement(this.loginItem));
    }

    /**
     * validatePageLoading method calls the waitForPageLoaded method for waiting the new page loading.
     * 
     * @return with a boolean to get the navigation status
     */
    public void validatePageLoading() {
        Assert.assertTrue("The My Account page is not loaded ", waitForPageToLoad());
    }

}
