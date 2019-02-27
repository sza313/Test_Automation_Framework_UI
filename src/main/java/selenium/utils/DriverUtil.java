package selenium.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;



public class DriverUtil {
    protected static WebDriver driver;
    protected static Properties properties = new Properties();

    public DriverUtil() {

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
        switch (browser) {
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
            Log.info("Clicking to the following element. ID=" + element.getAttribute("id") + " , CLASS=" + element.getAttribute("class") + ", NAME=" + element.getAttribute("name"));
            element.click();
        } catch (NoSuchElementException e) {
            Log.error("Could not find the requested element.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Writes a string into an input field. String can be specified by the tester.
     * Params:
     * WebElement textBox: unique ID or path to the textbox
     * String text: text to be entered to the textbox
     */
    protected boolean writeIntoTextBox(WebElement textBox, String text) {
        try {
            Log.info("Writing text '" + text + "' into the following textbox: ID=" + textBox.getAttribute("id") + " , CLASS=" + textBox.getAttribute("class") + " , NAME=" + textBox.getAttribute("name"));
            textBox.sendKeys(text);
        } catch (NoSuchElementException e) {
            Log.error("Could not find the requested textbox.");
            e.printStackTrace();
            return false;
        }
        return text.equals(textBox.getAttribute("value"));
    }

    /**
     * Clear the input field.
     * Params:
     * WebElement textBox: unique ID or path to the textbox
     */
    protected boolean clearTextBox(WebElement textBox) {
        try {
            Log.info("Clear the following textbox: ID=" + textBox.getAttribute("id") + " , CLASS=" + textBox.getAttribute("class") + " , NAME=" + textBox.getAttribute("name"));
            textBox.clear();
        } catch (NoSuchElementException e) {
            Log.error("Could not find the requested textbox.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Compares a string to the text of a webelement. Returns true if the two strings are the same.
     * Params:
     * WebElement elementWithText: unique ID or path to a webelement that has text
     * String expectedText: the string to be compared to the text of the webelement
     */
    protected boolean compareString(WebElement elementWithText, String expectedText) {
        try {
            Log.info("Comparing text '" + expectedText + "' with the text of the following element: ID=" + elementWithText.getAttribute("id") + " , CLASS=" + elementWithText.getAttribute("class") + " , TEXT=" + elementWithText.getText());
            String actualText;
            if (elementWithText.getText() == null || elementWithText.getText().isEmpty()) {
                actualText = elementWithText.getAttribute("value");
            } else {
                actualText = elementWithText.getText();
            }
            return actualText.equals(expectedText);
        } catch (NoSuchElementException e) {
            Log.error("Could not find the requested element.");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Sets the value of a checkbox to a required one. The value can be specified by the tester.
     * Params:
     * WebElement checkbox: unique ID or path to the checkbox
     * boolean checkboxValueToSet: the value we want to set the checkbox to
     */
    protected boolean setCheckboxValue(WebElement checkbox, boolean checkboxValueToSet) {
        try {
            Log.info("Setting to " + checkboxValueToSet + " the value of the following checkbox: ID=" + checkbox.getAttribute("id") + " , CLASS=" + checkbox.getAttribute("class") + " , VALUE=" + checkbox.getAttribute("value"));
            if (checkboxValueToSet != checkbox.isSelected()) {
                checkbox.click();
            }
        } catch (NoSuchElementException e) {
            Log.error("Could not find the requested checkbox.");
            e.printStackTrace();
            return false;
        }
        return checkboxValueToSet == checkbox.isSelected();
    }

    /**
     * Slides the handle of a range slider to a required value. The value can be specified by the tester.
     * Params:
     * WebElement rangeSlider: unique ID or path to the range slider
     * int valueToSet: the value we want to slide the handle to
     */
    protected boolean moveRangeSliderToValue(WebElement rangeSlider, int valueToSet) {
        try {
            Log.info("Setting to " + valueToSet + " the value of the following range slider: ID=" + rangeSlider.getAttribute("id") + " , CLASS=" + rangeSlider.getAttribute("class") + " , NAME=" + rangeSlider.getAttribute("name") + " , MIN=" + rangeSlider.getAttribute("min") + " , MAX=" + rangeSlider.getAttribute("max"));
            int minValue = Integer.valueOf(rangeSlider.getAttribute("min"));
            int maxValue = Integer.valueOf(rangeSlider.getAttribute("max"));
            if (valueToSet < minValue || valueToSet > maxValue) {
                throw new IllegalArgumentException();
            } else {
                int initialValue = Integer.valueOf(rangeSlider.getAttribute("value"));
                if (initialValue < valueToSet) {
                    for (int i = 0; i < valueToSet - initialValue; i++) {
                        rangeSlider.sendKeys(Keys.ARROW_RIGHT);
                    }
                } else {
                    for (int i = 0; i < initialValue - valueToSet; i++) {
                        rangeSlider.sendKeys(Keys.ARROW_LEFT);
                    }
                }
            }
        } catch (NoSuchElementException e) {
            Log.error("Could not find the requested range slider.");
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException ex) {
            Log.error("The requested value is out of range.");
            ex.printStackTrace();
            return false;
        }
        return Integer.valueOf(rangeSlider.getAttribute("value")) == valueToSet;
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

    /**
     * waitForPageLoaded method waits until the new page completely loaded.
     * @param
     * @return with a boolean to get the navigation status
     */
    public boolean waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation =(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                }
            });
        try {
            Thread.sleep(1500); //Wait for starting to load the new page
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(expectation);
            return true;
        } catch (Throwable error) {
            return false;
        }

    }


}
