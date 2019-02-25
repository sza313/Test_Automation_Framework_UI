package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class JQueryDropdownSearchPageObjects extends DriverUtil {

    public JQueryDropdownSearchPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='country']")
    protected WebElement selectCountryField;

    @FindBy(xpath = "//span[@id='select2-country-container']")
    protected WebElement selectCountryJapan;
}
