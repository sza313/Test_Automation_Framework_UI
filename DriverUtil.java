package selenium.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

    // clearField method is clearing a textbox field by pushing the backspace button until the field is empty

    protected boolean clearField(WebElement textBox, String text){
        try {
            Log.info("Clearing data from the field with backspace. ID=" + textBox.getAttribute("id") + " , CLASS=" + textBox.getAttribute("class")+" NAME=" + textBox.getAttribute("name"));
            WebElement myBox = driver.findElement(By.id("name"));
            myBox.sendKeys(text);
            String inputText = driver.findElement(By.id("name")).getAttribute("value");
            for(int i = 0; i < inputText.length(); i++){
                myBox.sendKeys(Keys.BACK_SPACE);
            }
        }catch (NoSuchElementException e){
            Log.error("Could not find the requested textbox.");
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
