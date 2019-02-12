package selenium.utils;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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
