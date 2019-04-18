package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.utils.DriverUtil;

public class CheckboxPageObjects extends DriverUtil {
    public CheckboxPageObjects(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@id='isAgeSelected']")
    protected WebElement singleCheckbox;

    @FindBy(id = "txtAge")
    protected WebElement successMessageDisplay;
}
