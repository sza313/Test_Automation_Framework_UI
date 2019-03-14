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

    @FindBy(xpath = "//span[@aria-labelledby='select2-country-container']")
    protected WebElement selectCountryField;

    @FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']//input[@type='search']")
    protected WebElement searchField;

    @FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
    protected WebElement resultCountry;

    @FindBy(xpath = "//span[@id='select2-country-container']")
    protected WebElement displayedCountry;
}
