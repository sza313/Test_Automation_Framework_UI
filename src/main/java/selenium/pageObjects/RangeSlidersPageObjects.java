package selenium.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.utils.DriverUtil;

public class RangeSlidersPageObjects extends DriverUtil {
    public RangeSlidersPageObjects() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='slider1']//input[@type='range']")
    protected WebElement topLeftSlider;

    @FindBy(xpath = "//output[@id='range']")
    protected WebElement topLeftSliderOutput;
}
