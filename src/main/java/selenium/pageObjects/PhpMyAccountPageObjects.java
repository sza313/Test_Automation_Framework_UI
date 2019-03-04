package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class PhpMyAccountPageObjects extends DriverUtil {
    public PhpMyAccountPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='nav navbar-nav go-right']/li[1]/a")
    protected WebElement homeItem;

    @FindBy(xpath = "//ul[@class='nav navbar-nav go-right']/li[2]/a/span")
    protected WebElement hotelsItem;

    @FindBy(xpath = "//ul[@class='nav navbar-nav go-right']/li[3]/a/span")
    protected WebElement flightsItem;

    @FindBy(xpath = "//ul[@class='nav navbar-nav go-right']/li[4]/a/span")
    protected WebElement toursItem;

    @FindBy(xpath = "//ul[@class='nav navbar-nav go-right']/li[5]/a/span")
    protected WebElement carsItem;

    @FindBy(xpath = "//ul[@class='nav navbar-nav go-right']/li[6]/a/span")
    protected WebElement visaItem;

}
