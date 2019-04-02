package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class PhpLoginPageObjects  extends DriverUtil {
    public PhpLoginPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/input[@name='username']")
    protected WebElement inputEmail;

    @FindBy(xpath = "//div/input[@name='password']")
    protected WebElement inputPassword;

    @FindBy(xpath = "//*[@id='loginfrm']/button")
    protected WebElement loginItem;

}
