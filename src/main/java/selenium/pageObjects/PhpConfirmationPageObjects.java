package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class PhpConfirmationPageObjects extends DriverUtil {
    public PhpConfirmationPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='body-section']/div/div[1]/div/div[1]/div/div[4]/button")
    protected WebElement confirmThisBooking;

    @FindBy(xpath = "//*[@id='invoiceTable']/tbody/tr[2]/td/div[1]/table/tbody/tr/td/div[3]")
    protected WebElement invoiceElement;

    @FindBy(xpath = "//*[@id='body-section']/div[1]/div[2]/div[2]/center/button[2]")
    protected WebElement payNowElement;

    @FindBy(xpath = "//*[@id='invoiceTable']/tbody/tr[4]/td/table/tbody/tr[2]/td/table[1]/tbody/tr[3]/td[1]")
    protected WebElement invoiceRoomElement;

}
