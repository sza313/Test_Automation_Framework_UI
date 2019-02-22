package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class DemoPageObjects extends DriverUtil{
    public DemoPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@class='top-menu']//a[contains(text(),'Computers')]")
    protected WebElement computersMenuItem;

    @FindBy(xpath = "//div[@class='sub-category-item']//a[contains(text(),'Desktops')]")
    protected WebElement desktopsMenuItem;

    @FindBy(id = "topcartlink")
    protected WebElement cart;

    @FindBy(xpath = "//*[@class='page-title']/h1")
    protected WebElement title;

    @FindBy(xpath = "//div[(@class='product-item') and (.//*[text()='Build your own cheap computer'])]//input")
    protected WebElement cheapPC;

    @FindBy(xpath = "//div[(@class='product-item') and (.//*[text()='Build your own computer'])]//input")
    protected WebElement PC;

    @FindBy(xpath = "//div[(@class='product-item') and (.//*[text()='Build your own expensive computer'])]//input")
    protected WebElement expensivePC;

    @FindBy(xpath = "//input[contains(@id,'add-to-cart-button')]")
    protected WebElement addToCart;

    @FindBy(xpath = "//*[@id='bar-notification']//p")
    protected WebElement notificationBar;
}
