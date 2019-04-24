package selenium.pageObjects.seleniumeasy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

import java.util.List;

public class BootstrapDatePickerPageObjects extends DriverUtil {
    public BootstrapDatePickerPageObjects(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[@id='datepicker']//input[1]")
    protected WebElement startDateInputField;

    @FindBy(xpath = "//div[@class='datepicker-days']//td[contains(@class, 'day')]")
    protected List<WebElement> dayList;

    @FindBy(xpath = "//div[@class='datepicker-days']//tbody")
    protected WebElement daysTable;

    @FindBy(xpath = "//div[@class='datepicker-days']//th[@class='datepicker-switch']")
    protected WebElement monthSwitcher;

    @FindBy(xpath = "//div[@class='datepicker-months']//th[@class='datepicker-switch']")
    protected WebElement yearSwitcher;

    @FindBy(xpath = "//div[@class='datepicker-months']//td/span[contains(@class,'month')]")
    protected List<WebElement> monthList;

    @FindBy(xpath = "//div[@class='datepicker-months']//tbody")
    protected WebElement monthsTable;

    @FindBy(xpath = "//div[@class='datepicker-years']//td/span[contains(@class,'year')]")
    protected List<WebElement> yearList;

    @FindBy(xpath = "//div[@class='datepicker-years']//tbody")
    protected WebElement yearsTable;

    @FindBy(xpath = "//div[@class='datepicker-years']//th[@class='prev']")
    protected WebElement previousDecadeArrow;

    @FindBy(xpath = "//div[@class='datepicker-years']//th[@class='next']")
    protected WebElement nextDecadeArrow;

    @FindBy(xpath = "//div[@id='datepicker']//span[text()='To']")
    protected WebElement textElement_To;
}
