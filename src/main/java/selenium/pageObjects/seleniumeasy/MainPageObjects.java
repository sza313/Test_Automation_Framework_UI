package selenium.pageObjects.seleniumeasy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class MainPageObjects extends DriverUtil {
    public MainPageObjects(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[contains(text(),'Input Forms')]")
    protected WebElement inputFormsMenuItem;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[contains(text(),'Date pickers')]")
    protected WebElement datePickersMenuItem;

    @FindBy(xpath = "//ul[contains(@class, 'navbar-nav')]//a[contains(text(),'Progress Bars')]")
    protected WebElement progressBarsMenuItem;

    @FindBy(xpath = "//a[text()='Simple Form Demo']")
    protected WebElement simpleFormDemoSubmenuItem;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[contains(text(),'JQuery Select dropdown')]")
    protected WebElement jQueryDropDownSubmenuItem;

    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/li[4]/a[1]")
    protected WebElement othersMenuItem;

    @FindBy(xpath = "//a[text()='Drag and Drop']")
    protected WebElement dragAndDropSubmenuItem;
    @FindBy(xpath = "//a[text()='Checkbox Demo']")
    protected WebElement checkboxDemoSubmenuItem;

    @FindBy(xpath = "//a[text()='Drag & Drop Sliders']")
    protected WebElement dragAndDropSlidersSubmenuItem;

    @FindBy(xpath = "//a[text()='Bootstrap Date Picker']")
    protected WebElement bootstrapDatePickerSubmenuItem;

    @FindBy(id = "site-name")
    protected WebElement siteName;

    @FindBy(xpath = "//h4[text()='Tutorials Menu']")
    protected WebElement tutorialsMenuTitle;
}
