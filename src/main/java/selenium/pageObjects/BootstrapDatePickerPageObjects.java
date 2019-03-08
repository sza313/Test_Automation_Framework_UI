package selenium.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.utils.DriverUtil;

public class BootstrapDatePickerPageObjects extends DriverUtil {
    public BootstrapDatePickerPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='datepicker']//input[1]")
    protected WebElement startDateInputField;

    @FindAll({
            @FindBy(xpath = "//div[@class='datepicker-days']//td[@class='day']"),
            @FindBy(xpath = "//div[@class='datepicker-days']//td[@class='disabled disabled-date day']")
    })
    protected List<WebElement> dayList;

    @FindBy(xpath = "//div[@class='datepicker-days']//th[@class='datepicker-switch']")
    protected WebElement monthSwitcher;

    @FindBy(xpath = "//div[@class='datepicker-months']//th[@class='datepicker-switch']")
    protected WebElement yearSwitcher;

    @FindBy(xpath = "//div[@class='datepicker-months']//td/span[contains(@class,'month')]")
    protected List<WebElement> monthList;

    @FindBy(xpath = "//div[@class='datepicker-years']//td/span[contains(@class,'year')]")
    protected List<WebElement> yearList;

    @FindBy(xpath = "//div[@class='datepicker-years']//th[@class='prev']")
    protected WebElement previousDecadeArrow;

    @FindBy(xpath = "//div[@class='datepicker-years']//th[@class='next']")
    protected WebElement nextDecadeArrow;

    @FindBy(xpath = "//div[@id='datepicker']//span[text()='To']")
    protected WebElement textElement_To;
}
