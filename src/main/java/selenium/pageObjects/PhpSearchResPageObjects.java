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

    @FindBy(xpath = "//*[@class='rating']/div[1]/div/ins")
    protected WebElement starGrade1;

    @FindBy(xpath = "//*[@class='rating']/div[3]/div/ins")
    protected WebElement starGrade2;

    @FindBy(xpath = "//*[@class='rating']/div[5]/div/ins")
    protected WebElement starGrade3;

    @FindBy(xpath = "//*[@class='rating']/div[7]/div/ins")
    protected WebElement starGrade4;

    @FindBy(xpath = "//*[@class='rating']/div[9]/div/ins")
    protected WebElement starGrade5;

    @FindBy(xpath = "//*[@id='collapse2']/div/div/div[1]/div[2]")
    protected WebElement leftPricericeRange;

    @FindBy(xpath = "//*[@id='collapse2']/div/div/div[1]/div[3]")
    protected WebElement rightPricericeRange;

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

    @FindBy(xpath = "//*[@id='body-section']/div[5]/div/div[3]/div[1]/div/table/tbody/tr[8]/td/div[3]/a/button\n")
    protected WebElement testing2Hotel;


}
