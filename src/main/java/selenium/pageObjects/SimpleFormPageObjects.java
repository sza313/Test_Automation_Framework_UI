package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class SimpleFormPageObjects extends DriverUtil {
    public SimpleFormPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "user-message")
    protected WebElement messageTextBox;

    @FindBy(xpath = "//form[@id='get-input']//button[text()='Show Message']")
    protected WebElement showMessageButton;

    @FindBy(id = "display")
    protected WebElement userMessageDisplay;
}
