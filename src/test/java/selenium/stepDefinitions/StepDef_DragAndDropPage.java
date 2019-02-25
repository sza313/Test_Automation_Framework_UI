package selenium.stepDefinitions;

import cucumber.api.java.en.And;
import org.junit.Assert;
import selenium.pages.DragAndDropPage;
import selenium.utils.DriverUtil;

public class StepDef_DragAndDropPage extends DriverUtil {

    private DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);

    @And("Drag '(.*)' element into droppable")
    public void dragAndDropElement(String draggable) {
        Assert.assertTrue("Could not drag " + draggable, dragAndDropPage.dragAndDrop(draggable));
    }

    @And("Waiting for '(.*)' is visible after (\\d+) seconds under the Dropped Item List")
    public void waitForDroppedElement(String dropped, int seconds) {
        Assert.assertTrue(dropped + " did not appear in Dropped Item List.", dragAndDropPage.waitForDroppedElementToBeVisible(dropped, seconds));
    }
}
