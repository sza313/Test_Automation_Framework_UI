package selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.DriverUtil;

public class DragAndDropPageObjects extends DriverUtil {

    public DragAndDropPageObjects (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='todrag']//span[contains(text(),'Draggable 1')]")
    protected WebElement draggableElement;

    @FindBy(xpath = "//div[@id='mydropzone']")
    protected WebElement droppableElement;

    @FindBy(xpath = "//div[@id='droppedlist']//span[contains(text(),'Draggable 1')]")
    protected WebElement droppedElement;

}

