package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.DragAndDropPageObjects;

public class DragAndDropPage extends DragAndDropPageObjects {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public boolean dragAndDrop (String draggable) {
        switch (draggable) {
            case "Draggable_item":
        Assert.assertTrue("Could not drag " + draggable, dragAndDropWebelement(this.draggableElement, this.droppableElement));
            return true;
        default:
            Assert.fail("Could not find the requested item: " + draggable);
            return false;
        }
    }

    public boolean waitForDroppedElementToBeVisible (String dropped, int seconds) {
        switch (dropped) {
            case "Dropped_item":
                Assert.assertTrue("Could not find " + dropped + " element after " + seconds + " seconds", waitingForElementToBeVisible(this.droppedElement, seconds));
                return true;
            default:
                Assert.fail("Could not find the requested item: " + dropped);
                return false;
        }
    }
}
