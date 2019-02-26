package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.DemoPageObjects;
import selenium.utils.Log;

public class DemoPage extends DemoPageObjects{
    public DemoPage(WebDriver driver){super(driver);}

    public boolean clickToMenu(String menuName){
        switch (menuName){
            case "Computers":
                Log.info("Clicking to the Computers menu item.");
                return clickToElement(this.computersMenuItem);
            case "Electronics":
                Log.info("Clicking to the Electronics item.");
                return clickToElement(this.electronicsMenuItem);
            case "Jewelry":
                Log.info("Clicking to the Jewelry menu item.");
                return clickToElement(this.jewelryMenuItem);
            case "Cart":
                Log.info("Clicking to the cart menu item.");
                scrollToElement(this.cart);
                return clickToElement(this.cart);
            default:
                Log.error("Could not click to the "+menuName+" menu item.");
                return false;
        }
    }

    public boolean clickToSubmenu(String submenuName){
        switch (submenuName){
            case "Desktops":
                Log.info("Clicking to the Desktops menu item.");
                return clickToElement(this.desktopsMenuItem);
            case "Camera":
                Log.info("Clicking to the Camera menu item.");
                return clickToElement(this.cameraMenuItem);
            case "Cell phones":
                Log.info("Clicking to the Cell phones menu item.");
                return clickToElement(this.cellPhonesMenuItem);
            case "":
                Log.info("Do not need to select submenu.");
                return true;
            default:
                Log.error("Could not click to the "+submenuName+" submenu item.");
                return false;
        }
    }

    public boolean userIsOnTheRightPage(String title) {
        Log.info("Checking the page title text.");
        return compareString(this.title,title);
    }

    public boolean addToCart() {
        Log.info("Adding to the cart.");
        return clickToElement(this.addToCart);
    }

    public boolean selectProduct(String productName) {
        switch (productName){
            case "Build your own cheap computer":
                Log.info("Selecting the following product: "+productName);
                return clickToElement(this.cheapPC);
            case "Build your own computer":
                Log.info("Selecting the following product: "+productName);
                return clickToElement(this.PC);
            case "Build your own expensive computer":
                Log.info("Selecting the following product: "+productName);
                return clickToElement(this.expensivePC);
            case "Black and White Diamond Heart":
                Log.info("Selecting the following product: "+productName);
                return clickToElement(this.blackAndWhite);
            case "Create Your Own Jewelry":
                Log.info("Selecting the following product: "+productName);
                 clickToElement(this.createYourOwn);
                 writeIntoTextBox(driver.findElement(By.id("product_attribute_71_10_16")),"20");
            case "Smartphone":
                Log.info("Selecting the following product: "+productName);
                return clickToElement(this.smartPhone);
            default:
                Log.error("Could not find the following product: "+productName);
                return false;
        }

    }

    public boolean isAddedToCart(String number) {
        Log.info("Check the notification text");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return compareString(this.notificationBar,"("+number+")");
    }
}
