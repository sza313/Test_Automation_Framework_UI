package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.pageObjects.PhpLoginPageObjects;

public class PhpLoginPage extends PhpLoginPageObjects {

    public PhpLoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * login method calls the login method that starts a commom login/password/submit procedure.
     * @return with a boolean to get the navigation status
     */
    public boolean login( ) {
        Assert.assertTrue("Could not clear the username field.",clearTextBox(this.inputEmail));
        Assert.assertTrue("Could not clear the password field.",clearTextBox(this.inputPassword));

        String username = properties.getProperty("Email_php");
        Assert.assertTrue("Could not write into the email field.",writeIntoTextBox(this.inputEmail,username));
        String password = properties.getProperty("Password_php");
        Assert.assertTrue("Could not write into the email field.",writeIntoTextBox(this.inputPassword,password));

        return clickToElement(this.loginItem);
    }

    /**
     * validatePageLoading method calls the waitForPageLoaded method for waiting the new page loading.
     * @return with a boolean to get the navigation status
     */
    public boolean validatePageLoading() {
        return waitForPageLoaded();
    }


}
