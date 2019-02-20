package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class RangeSlidersPageObjects extends DriverUtil {
    public RangeSlidersPageObjects(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='slider1']//input[@type='range']")
    protected WebElement topLeftSlider;

    @FindBy(xpath = "//output[@id='range']")
    protected WebElement topLeftSliderOutput;
}
