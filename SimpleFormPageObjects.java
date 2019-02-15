package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class SimpleFormPageObjects extends DriverUtil {

    public SimpleFormPageObjects (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-message']")
    protected WebElement enterMessageField;

    @FindBy(xpath = "//button[contains(text(),'Show Message')]")
    protected WebElement showMessageButton;

    @FindBy(xpath = "//span[@id='display']")
    protected WebElement displayedMessage;

}
