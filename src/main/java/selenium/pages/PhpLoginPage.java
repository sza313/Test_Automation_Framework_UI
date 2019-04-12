package selenium.pages;

import org.junit.Assert;

import selenium.pageObjects.PhpLoginPageObjects;

public class PhpLoginPage extends PhpLoginPageObjects {

    /**
     * login method calls the login method that starts a commom login/password/submit procedure.
     * 
     * @return with a boolean to get the navigation status
     */
    public void enterLoginCredentialAndClickLogin() {
        String username = properties.getProperty("Email_php");
        Assert.assertTrue("Could not write into the email field.", writeIntoTextBox(this.inputEmail, username));
        String password = properties.getProperty("Password_php");
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
