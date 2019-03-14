package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class PhpTesting2HotelPageObjects extends DriverUtil {
    public PhpTesting2HotelPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='ROOMS']/div/table/tbody/tr[1]/td/div[2]/div[2]/div/div[3]/div/label/div")
    protected WebElement selectStandardRoom;

    @FindBy(xpath = "//*[@id='ROOMS']/div/button")
    protected WebElement bookNow;

}
