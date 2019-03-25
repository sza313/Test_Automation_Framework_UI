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

    @FindBy(xpath = "//*[@id='s2id_autogen8']/a/span[1]")
    protected WebElement searchByItem;

    @FindBy(xpath = "//*[@id='select2-drop']/div/input")
    protected WebElement searchByInputItem;

    @FindBy(xpath = "//ul[@class='select2-results']//span[@class='select2-match']")
    protected WebElement searchByResultItem;

    @FindBy(xpath = "//*[@id='dpd1']/div/input")
    protected WebElement checkInItem;

    @FindBy(xpath = "//*[@id='dpd2']/div/input")
    protected WebElement checkOutItem;

    @FindBy(xpath = "//div[@id='hotels']//input[@id='travellersInput']")
    protected WebElement adultChildItem;

    @FindBy(xpath = "//*[@id='hotels']/form/div[5]/button")
    protected WebElement searchButton;

    @FindBy(xpath = "/html/body/div[9]/div[1]/table/thead/tr[1]/th[3]")
    protected WebElement nextMonthItem1;

    @FindBy(xpath = "/html/body/div[9]/div[1]/table/tbody/tr[2]/td[6]")
    protected WebElement nextFridayItem;

    @FindBy(xpath = "/html/body/div[9]/div[1]/table/tbody/tr[3]/td[7]")
    protected WebElement nextSaturdayItem;

    @FindBy(xpath = "/html/body/div[10]/div[1]/table/thead/tr[1]/th[3]")
    protected WebElement nextMonthItem2;

    @FindBy(xpath = "/html/body/div[10]/div[1]/table/tbody/tr[3]/td[6]")
    protected WebElement oneWeekLaterItem;

    @FindBy(xpath = "/html/body/div[10]/div[1]/table/tbody/tr[4]/td[1]")
    protected WebElement oneDayLaterItem;

    @FindBy(xpath = "//*[@id='childPlusBtn']")
    protected WebElement childPlusButton;

    @FindBy(xpath = "//*[@id='childMinusBtn']")
    protected WebElement childMinusButton;

}
