package selenium.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DriverUtil {
    protected static WebDriver driver;
    protected static Properties properties = new Properties();

    public DriverUtil(){

    }

    public DriverUtil(WebDriver driver) {
        DriverUtil.driver = driver;
    }


    /**createNewDriver calls two method to open a browser
     *
     * Params: Do not have any input params.
     */
    protected void createNewDriver() {
        readPropertiesFile();
        chooseBrowser();
    }

    /** chooseBrowser method creates a new webdriver, get data from system argument or config file to get the required browser type.
     *
     * Params: Do not have any input params.
     */
    private void chooseBrowser() {

        String browser;

        //Firstly check the system argument browser value and if it is empty than reads from the config file
        if (System.getProperty("browser") != null) {
            browser = System.getProperty("browser");
        } else {
            browser = properties.getProperty("browser");
        }

        //Select the correct browser type, chrome is the default one
        switch (browser){
            case "firefox":
                System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
                driver= new FirefoxDriver();
                Log.info("Firefox driver is opening.");
                driver.manage().window().maximize();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                Log.info("Chrome browser is opening.");
                driver.manage().window().maximize();
                break;
        //TODO: debug this (won't find dropdown element)
            case "IE":
                System.setProperty("webdriver.ie.driver","./src/main/resources/IEDriverServer.exe");
                driver= new InternetExplorerDriver();
                Log.info("IE driver is opening.");
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

    /**readPropertiesFile opens the Config.properties file and save the values
     *
     * Params: Do not have any input params.
     */
    private void readPropertiesFile() {
        try {
            InputStream input = new FileInputStream("./config/Config.properties");
            properties.load(input);
        } catch (Exception e) {
            Log.error("Config.properties file not found!");
            e.printStackTrace();
        }
    }

    /**cliclToElement method clicks to a webelement
     *
     * @param element: Data came from the Page files, it identifies the target
     * @return with a boolean to get the status of the click
     */

    protected boolean clickToElement(WebElement element){
        try {
            Log.info("Clicking to the following element. ID="+element.getAttribute("id")+" , CLASS="+element.getAttribute("class")+" NAME="+element.getAttribute("name"));
            element.click();
        }catch (NoSuchElementException e){
            Log.error("Could not find the requested element.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Draws a red border around the found element.
    //Params:
    //WebElement element:unique identifier of the element
     public boolean drawBorder(WebElement element) {
         Log.info("Drawing border around the following element. ID="+element.getAttribute("id")+" , CLASS="+element.getAttribute("class")+" TEXT="+element.getText());
         if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor)driver).executeScript("arguments [0].style.border='solid red'",element);
        }
        return element.getAttribute("style").contains("solid red");
    }
}
