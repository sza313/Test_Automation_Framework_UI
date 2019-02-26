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

    @FindBy(xpath = "//*[@class='top-menu']//a[contains(text(),'Electronics')]")
    protected WebElement electronicsMenuItem;

    @FindBy(xpath = "//*[@class='top-menu']//a[contains(text(),'Jewelry')]")
    protected WebElement jewelryMenuItem;

    @FindBy(xpath = "//div[@class='sub-category-item']//a[contains(text(),'Camera, photo')]")
    protected WebElement cameraMenuItem;

    @FindBy(xpath = "//div[@class='sub-category-item']//a[contains(text(),'Desktops')]")
    protected WebElement desktopsMenuItem;

    @FindBy(xpath = "//div[@class='sub-category-item']//a[contains(text(),'Cell phones')]")
    protected WebElement cellPhonesMenuItem;

    @FindBy(xpath = "//a[text()='Shopping cart']")
    protected WebElement cart;

    @FindBy(xpath = "//*[@class='page-title']/h1")
    protected WebElement title;

    @FindBy(xpath = "//div[(@class='product-item') and (.//*[text()='Build your own cheap computer'])]//h2[@class='product-title']/a")
    protected WebElement cheapPC;

    @FindBy(xpath = "//div[(@class='product-item') and (.//*[text()='Build your own computer'])]//h2[@class='product-title']/a")
    protected WebElement PC;

    @FindBy(xpath = "//div[(@class='product-item') and (.//*[text()='Build your own expensive computer'])]//h2[@class='product-title']/a")
    protected WebElement expensivePC;

    @FindBy(xpath = "//div[(@class='product-item') and (.//*[text()='Black & White Diamond Heart'])]//h2[@class='product-title']/a")
    protected WebElement blackAndWhite;

    @FindBy(xpath = "//div[(@class='product-item') and (.//*[text()='Create Your Own Jewelry'])]//h2[@class='product-title']/a")
    protected WebElement createYourOwn;

    @FindBy(xpath = "//div[(@class='product-item')]//a[text()='Smartphone']")
    protected WebElement smartPhone;

    @FindBy(xpath = "//input[contains(@id,'add-to-cart-button')]")
    protected WebElement addToCart;

    @FindBy(xpath = "//*[@id='topcartlink']//span[@class='cart-qty']")
    protected WebElement notificationBar;
}
