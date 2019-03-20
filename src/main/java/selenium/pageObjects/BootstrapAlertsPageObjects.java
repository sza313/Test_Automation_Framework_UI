package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class BootstrapAlertsPageObjects extends DriverUtil {
    public BootstrapAlertsPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="normal-btn-success")
    protected WebElement normalSuccessMessageButton;

    @FindBy(id="normal-btn-warning")
    protected WebElement normalWarningMessageButton;

    @FindBy(id="normal-btn-danger")
    protected WebElement normalDangerMessageButton;

    @FindBy(id="normal-btn-info")
    protected WebElement normalInfoMessageButton;

    @FindBy(xpath="//div[contains(@class, 'alert-normal-success')]")
    protected WebElement normalSuccessMessage;

    @FindBy(xpath="//div[contains(@class, 'alert-normal-success')]")
    protected WebElement normalWarningMessage;

    @FindBy(xpath="//div[contains(@class, 'alert-normal-success')]")
    protected WebElement normalDangerMessage;

    @FindBy(xpath="//div[contains(@class, 'alert-normal-success')]")
    protected WebElement normalInfoMessage;

    @FindBy(id="autoclosable-btn-success")
    protected WebElement autoclosableSuccessMessageButton;

    @FindBy(id="autoclosable-btn-warning")
    protected WebElement autoclosableWarningMessageButton;

    @FindBy(id="autoclosable-btn-danger")
    protected WebElement autoclosableDangerMessageButton;

    @FindBy(id="autoclosable-btn-info")
    protected WebElement autoclosableInfoMessageButton;

    @FindBy(xpath="//div[contains(@class, 'alert-autocloseable-success')]")
    protected WebElement autoclosableSuccessMessage;

    @FindBy(xpath="//div[contains(@class, 'alert-autocloseable-warning')]")
    protected WebElement autoclosableWarningMessage;

    @FindBy(xpath="//div[contains(@class, 'alert-autocloseable-danger')]")
    protected WebElement autoclosableDangerMessage;

    @FindBy(xpath="//div[contains(@class, 'alert-autocloseable-info')]")
    protected WebElement autoclosableInfoMessage;
}
