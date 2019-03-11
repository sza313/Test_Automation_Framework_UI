package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class PhpSearchResPageObjects extends DriverUtil {
    public PhpSearchResPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='collapse1']/div[1]/div/div[1]/div/ins")
    protected WebElement starGrade1;

    @FindBy(xpath = "//*[@id='collapse1']/div[1]/div/div[3]/div/ins")
    protected WebElement starGrade2;

    @FindBy(xpath = "//*[@id='collapse1']/div[1]/div/div[5]/div/ins")
    protected WebElement starGrade3;

    @FindBy(xpath = "//*[@id='collapse1']/div[1]/div/div[7]/div/ins")
    protected WebElement starGrade4;

    @FindBy(xpath = "//*[@id='collapse1']/div[1]/div/div[9]/div/ins")
    protected WebElement starGrade5;

    @FindBy(xpath = "//*[@id='sl2']")
    protected WebElement priceRange;

    @FindBy(xpath = "//*[@id='collapse3']/div[1]/div[4]/div/ins")
    protected WebElement propertyHotel;

    @FindBy(xpath = "//*[@id='collapse4']/div[1]/div[2]/div/ins")
    protected WebElement amenitiesAirportTransport;

    @FindBy(xpath = "//*[@id='collapse4']/div[1]/div[12]/div/ins")
    protected WebElement amenitiesRestaurant;

    @FindBy(xpath = "//*[@id='collapse4']/div[1]/div[14]/div/ins")
    protected WebElement amenitiesWiFi;

    @FindBy(xpath = "//*[@id='searchform']")
    protected WebElement searchButton;



}
