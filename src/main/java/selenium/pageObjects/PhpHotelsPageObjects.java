package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class PhpHotelsPageObjects extends DriverUtil {
    public PhpHotelsPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='select2-drop']/div/input")
    protected WebElement searchByItem;

    @FindBy(xpath = "//*[@id='dpd1']/div/input")
    protected WebElement checkInItem;

    @FindBy(xpath = "//*[@id='dpd2']/div/input")
    protected WebElement checkOutItem;

    @FindBy(xpath = "//*[@id='travellersInput']")
    protected WebElement adultChildItem;

    @FindBy(xpath = "//*[@id='hotels']/form/div[5]/button")
    protected WebElement searchButton;

    @FindBy(xpath = "/html/body/div[9]/div[1]/table/tbody/tr[2]/td[6]")
    protected WebElement nextFridayItem;

    @FindBy(xpath = "/html/body/div[10]/div[1]/table/tbody/tr[3]/td[6]")
    protected WebElement oneWeekLaterItem;

    @FindBy(xpath = "//*[@id='childPlusBtn']")
    protected WebElement childPlusButton;

    @FindBy(xpath = "//*[@id='childMinusBtn']")
    protected WebElement childMinusButton;

}
