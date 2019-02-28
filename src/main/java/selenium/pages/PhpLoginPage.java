package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.PhpLoginPageObjects;

public class PhpLoginPage extends PhpLoginPageObjects {

    public PhpLoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * loginProcess method calls the login method that starts a commom login/password/submit procedure.
     *
     * @param : email represent the user's email address, password is of the user's password
     * @return with a boolean to get the navigation status
     */
    public boolean loginProcess(String email, String password ) {
        Assert.assertTrue("Login process was not successful! ",login(email,password,this.inputEmail,this.inputPassword,this.loginItem));
        return true;
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
