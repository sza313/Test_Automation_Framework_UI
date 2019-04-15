package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class PhpTravelPageObjects extends DriverUtil {
    public PhpTravelPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//nav[@class='navbar navbar-default']//li[@id='li_myaccount']/a")
    protected WebElement myAccountItem;

    @FindBy(xpath ="//nav[@class='navbar navbar-default']//li[@id='li_myaccount']/ul/li[1]/a")
    protected WebElement loginSubmenuItem;

    @FindBy(xpath ="//nav[@class='navbar navbar-default']//li[@id='li_myaccount']/ul/li[2]/a")
    protected WebElement signUpSubmenuItem;

}
