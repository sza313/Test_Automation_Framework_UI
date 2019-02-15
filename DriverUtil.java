package selenium.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DriverUtil {
    public static WebDriver driver;
    protected static Properties properties = new Properties();

    public DriverUtil(){

    }

    public DriverUtil(WebDriver driver) {
        DriverUtil.driver = driver;
    }

    protected void createNewDriver() {
        readPropertiesFile();
        chooseBrowser();
    }

    //Choose browser from system property or properties file
    private void chooseBrowser() {

        String browser;

        if (System.getProperty("browser") != null) {
            browser = System.getProperty("browser");
        } else {
            browser = properties.getProperty("browser");
        }

        switch (browser){
            case "firefox":
                //todo
                Log.info("Firefox browser is opening.");
                driver.manage().window().maximize();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                Log.info("Chrome browser is opening.");
                driver.manage().window().maximize();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                Log.info("Chrome browser is opening by default.");
                driver.manage().window().maximize();
                break;
        }

    }

    //Locate and read data from properties file
    private void readPropertiesFile() {
        try {
            InputStream input = new FileInputStream("./config/Config.properties");
            properties.load(input);
        } catch (Exception e) {
            Log.error("Config.properties file not found!");
            e.printStackTrace();
        }
    }

    protected boolean clickToElement(WebElement element){
        try {
            Log.info("Clicking to the following element. ID="+element.getAttribute("id")+" , CLASS="+element.getAttribute("class")+" TEXT="+element.getText());
            element.click();
        }catch (NoSuchElementException e){
            Log.error("Could not find the requested element.");
            e.printStackTrace();
            return false;
        }
        return true;
    }



    /** writeRandomAlphabeticString method is writing a random alphabetic string into a textbox
     * Number of characters can be specified by the user.
     * Params:
     * WebElement textBox: unique ID or path to the textbox
     * int length: number of characters to be entered
     */
    public boolean writeRandomAlphabeticString(WebElement textBox, int length){
        try {
            Log.info("Writing alphabetic string into the following textbox. ID=" + textBox.getAttribute("id") + " , CLASS=" + textBox.getAttribute("class")  + " , NAME=" + textBox.getAttribute("name"));
            textBox.sendKeys(RandomStringUtils.randomAlphabetic(length));
        }
        catch (NoSuchElementException e){
            Log.error("Could not find the requested textbox.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /** writeRandomNumericString method is writing a random numeric string into a textbox
     * Number of characters can be specified by the user.
     * Params:
     * WebElement textBox: unique ID or path to the textbox
     * int length: number of characters to be entered
     */
    public boolean writeRandomNumericString(WebElement textBox, int length){
        try {
            Log.info("Writing numeric string into the following textbox. ID=" + textBox.getAttribute("id") + " , CLASS=" + textBox.getAttribute("class")  + " , NAME=" + textBox.getAttribute("name"));
            textBox.sendKeys(RandomStringUtils.randomNumeric(length));
            }
        catch (NoSuchElementException e){
            Log.error("Could not find the requested textbox.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /** writeRandomAlphanumericString method is writing a random alphanumberic string into a textbox
     * Number of characters can be specified by the user.
     * Params:
     * WebElement textBox: unique ID or path to the textbox
     * int length: number of characters to be entered
     */
    public boolean writeRandomAlphanumericString(WebElement textBox, int length){
        try {
            Log.info("Writing alphanumeric string into the following textbox. ID=" + textBox.getAttribute("id") + " , CLASS=" + textBox.getAttribute("class")  + " , NAME=" + textBox.getAttribute("name"));
            textBox.sendKeys(RandomStringUtils.randomAlphanumeric(length));
        }
        catch (NoSuchElementException e){
            Log.error("Could not find the requested textbox.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /** clearField method is clearing a textbox field by pushing the backspace button
     * until the field is empty
     * Params:
     * WebElement textBox: unique ID or path to the textbox
     */
    protected boolean clearFieldWithBackspace(WebElement textBox){
        try {
            Log.info("Clearing data from the field with backspace. ID=" + textBox.getAttribute("id") + " , CLASS=" + textBox.getAttribute("class")+" NAME=" + textBox.getAttribute("name"));
            String inputText = textBox.getAttribute("value");
            for(int i = 0; i < inputText.length(); i++){
                textBox.sendKeys(Keys.BACK_SPACE);
            }
        }catch (NoSuchElementException e){
            Log.error("Could not find the requested textbox.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /** clearDataFromField method is deleting the data from a field
     * Params:
     * WebElement textBox: unique ID or path to the textbox
     */
    public boolean clearDataFromField(WebElement textBox) {
        try {
            Log.info("Clearing data from the following textbox. ID=" + textBox.getAttribute("id") + " , CLASS=" + textBox.getAttribute("class")  + " , NAME=" + textBox.getAttribute("name"));
            textBox.clear();
        }
        catch (NoSuchElementException e){
            Log.error("Could not find the requested textbox.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /** clickButton method is clicking on a certain button on the page
     * Params:
     * WebElement button: unique ID or path to the button
     */
    public boolean clickButton(WebElement button){
        try {
            Log.info("Writing alphanumeric string into the following textbox. ID=" + button.getAttribute("id") + " , CLASS=" + button.getAttribute("class")  + " , NAME=" + button.getAttribute("name"));
            button.click();
        }
        catch (NoSuchElementException e){
            Log.error("Could not find the requested textbox.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /** validateString method is printing number of digits appearing so that
     * it can be compared to the number specified in the feature
     * Params:
     * WebElement message: unique ID or path to the displayed message
     */
    public boolean validateString(WebElement message){
        try {
            Log.info("Get displayed text from the following element and validate its length. ID=" + message.getAttribute("id") + " , CLASS=" + message.getAttribute("class")  + " , NAME=" + message.getAttribute("name"));
            System.out.println("Number of digits in the displayed text is: " + message.getText().length());
        }
        catch (NoSuchElementException e){
            Log.error("Could not find the requested element.");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /** autoSuggestionField method is writing a text into an
     * autosuggestive field and selects the first option
     * Params:
     * WebElement textBox: unique ID or path to the textbox
     * String text: text entered to which we want to find autosuggestion
     */
    public boolean autoSuggestionField(WebElement textBox, String text) {
            try {
                Log.info("Writing text " + text + " into the following textbox and selecting auto suggestion. ID=" + textBox.getAttribute("id") + " , CLASS=" + textBox.getAttribute("class")  + " , NAME=" + textBox.getAttribute("name"));
                textBox.sendKeys(text);
                textBox.sendKeys(Keys.ENTER);
            }
            catch (NoSuchElementException e){
                Log.error("Could not find the requested textbox.");
                e.printStackTrace();
                return false;
            }
            return true;
    }


    /** dragAndDropWebelement method is dragging a WebElement and dropping it into another WebElement
     * Params:
     * WebElement draggable: unique ID or path to the element we want to drag
     * WebElement droppable: unique ID or path to the element in which we want to drop the draggable element
     */
    public boolean dragAndDropWebelement(WebElement draggable, WebElement droppable) {
        try {
            Log.info("Dragging and dropping the following element: ID=" + draggable.getAttribute("id") + " , CLASS=" + draggable.getAttribute("class")  + " , NAME=" + draggable.getAttribute("name") + " into element ID= " + droppable.getAttribute("id") + " , CLASS=" + draggable.getAttribute("class")  + " , NAME=" + draggable.getAttribute("name"));
            Actions action = new Actions(driver);
            WebElement source = draggable;
            WebElement target = droppable;
            action.dragAndDrop(source, target).build().perform();
        }
        catch (NoSuchElementException e){
            Log.error("Could not find the requested elements.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /** waitingForElementToBeVisible method is enabling to wait for a certain WebElement
     * for a certain number of seconds
     * Params:
     * WebElement element: unique ID or path to the WebElement we are waiting for to be visible
     * int seconds: number of seconds we are waiting before throwing an exception
     */
    public boolean waitingForElementToBeVisible(WebElement element, int seconds) {
        try {
            Log.info("Waiting for the following element to be visible: ID=" + element.getAttribute("id") + " , CLASS=" + element.getAttribute("class")  + " , NAME=" + element.getAttribute("name"));
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("element")));
        }
        catch (NoSuchElementException e){
            Log.error("Could not find the requested element.");
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
