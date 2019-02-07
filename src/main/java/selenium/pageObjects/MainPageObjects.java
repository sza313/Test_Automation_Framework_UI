package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class MainPageObjects extends DriverUtil {
    public MainPageObjects (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[contains(text(),'Input Forms')]")
    protected WebElement inputFormsMenuItem;

}
