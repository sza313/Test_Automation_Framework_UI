package selenium.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.utils.DriverUtil;

public class CheckboxPageObjects extends DriverUtil {
    public CheckboxPageObjects() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='isAgeSelected']")
    protected WebElement singleCheckbox;

    @FindBy(id = "txtAge")
    protected WebElement successMessageDisplay;
}
