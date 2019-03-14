package selenium.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DriverUtil {
    protected static WebDriver driver;
    protected static Properties properties = new Properties();

    public DriverUtil(WebDriver driver) {
        DriverUtil.driver = driver;
    }

    public DriverUtil() {
    }

    /**
     * createNewDriver calls two method to open a browser
     * <p>
     * Params: Do not have any input params.
     */
    protected void createNewDriver() {
        readPropertiesFile();
        chooseBrowser();
    }

    /**
     * chooseBrowser method creates a new webdriver, get data from system argument or config file to get the required browser type.
     * <p>
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
                System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
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
                System.setProperty("webdriver.ie.driver", "./src/main/resources/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
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

    /**
     * readPropertiesFile opens the Config.properties file and save the values
     * <p>
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

    /**
     * cliclToElement method clicks to a webelement
     *
     * @param element: Data came from the Page files, it identifies the target
     * @return with a boolean to get the status of the click
     */
    protected boolean clickToElement(WebElement element) {
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
     * writeRandomAlphabeticString method is writing a random alphabetic string into a textbox
     * Number of characters can be specified by the user.
     * Params:
     * WebElement textBox: unique ID or path to the textbox
     * int length: number of characters to be entered
     */
    public boolean writeRandomAlphabeticString(WebElement textBox, int length) {
        String randomAlphabeticString = RandomStringUtils.randomAlphabetic(length);
        try {
            Log.info("Writing random alphabetic string into the following textbox. ID=" + textBox.getAttribute("id") + " , CLASS=" + textBox.getAttribute("class") + " , NAME=" + textBox.getAttribute("name"));

            textBox.sendKeys(randomAlphabeticString);
        } catch (NoSuchElementException e) {
            Log.error("Could not find the requested textbox.");
            e.printStackTrace();
            return false;
        }
        return randomAlphabeticString.equals(textBox.getAttribute("value"));
    }

    /**
     * writeRandomNumericString method is writing a random numeric string into a textbox
     * Number of characters can be specified by the user.
     * Params:
     * WebElement textBox: unique ID or path to the textbox
     * int length: number of characters to be entered
     */
    public boolean writeRandomNumericString(WebElement textBox, int length) {
        String randomNumericString = RandomStringUtils.randomNumeric(length);
        try {
            Log.info("Writing random numeric string into the following textbox. ID=" + textBox.getAttribute("id") + " , CLASS=" + textBox.getAttribute("class") + " , NAME=" + textBox.getAttribute("name"));
            textBox.sendKeys(randomNumericString);
        } catch (NoSuchElementException e) {
            Log.error("Could not find the requested textbox.");
            e.printStackTrace();
            return false;
        }
        return randomNumericString.equals(textBox.getAttribute("value"));
    }

    /**
     * writeRandomAlphanumericString method is writing a random alphanumberic string into a textbox
     * Number of characters can be specified by the user.
     * Params:
     * WebElement textBox: unique ID or path to the textbox
     * int length: number of characters to be entered
     */
    public boolean writeRandomAlphanumericString(WebElement textBox, int length) {
        String randomAlphanumericString = RandomStringUtils.randomAlphanumeric(length);
        try {
            Log.info("Writing random alphanumeric string into the following textbox. ID=" + textBox.getAttribute("id") + " , CLASS=" + textBox.getAttribute("class") + " , NAME=" + textBox.getAttribute("name"));
            textBox.sendKeys(randomAlphanumericString);
        } catch (NoSuchElementException e) {
            Log.error("Could not find the requested textbox.");
            e.printStackTrace();
            return false;
        }
        return randomAlphanumericString.equals(textBox.getAttribute("value"));
    }

    /**
     * createRandomAlphabeticString method is generating a random alphabetic string.
     * Number of characters can be specified by the user.
     * Params:
     * int length: number of characters to be entered
     */
    protected String createRandomAlphabeticString(int length) {
        String randomAlphabeticString = RandomStringUtils.randomAlphabetic(length);
        return randomAlphabeticString;
    }

    /**
     * createRandomNumericString method is generating a random numeric string.
     * Number of characters can be specified by the user.
     * Params:
     * int length: number of characters to be entered
     */
    protected String createRandomNumericString(int length) {
        String randomNumericString = RandomStringUtils.randomNumeric(length);
        return randomNumericString;
    }

    /**
     * createRandomAlphanumericString method is generating a random alphanumeric string.
     * Number of characters can be specified by the user.
     * Params:
     * int length: number of characters to be entered
     */
    protected String createRandomAlphanumericString(int length) {
        String randomAlphanumericString = RandomStringUtils.randomAlphanumeric(length);
        return randomAlphanumericString;
    }

    /**
     * clearField method is clearing a textbox field by pushing the backspace button
     * until the field is empty
     * Params:
     * WebElement textBox: unique ID or path to the textbox
     */
    protected boolean clearFieldWithBackspace(WebElement textBox) {
        try {
            Log.info("Clearing data from the following textbox with backspace. ID=" + textBox.getAttribute("id") + " , CLASS=" + textBox.getAttribute("class") + " NAME=" + textBox.getAttribute("name"));
            String inputText = textBox.getAttribute("value");
            for (int i = 0; i < inputText.length(); i++) {
                textBox.sendKeys(Keys.BACK_SPACE);
            }
        } catch (NoSuchElementException e) {
            Log.error("Could not find the requested textbox.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * clearDataFromField method is deleting the data from a field
     * Params:
     * WebElement textBox: unique ID or path to the textbox
     */
    protected boolean clearDataFromField(WebElement textBox) {
        try {
            Log.info("Clearing data from the following textbox. ID=" + textBox.getAttribute("id") + " , CLASS=" + textBox.getAttribute("class") + " , NAME=" + textBox.getAttribute("name"));
            textBox.clear();
        } catch (NoSuchElementException e) {
            Log.error("Could not find the requested textbox.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * validateFieldIsEmpty method is checking if the certain textbox is empty
     * Params:
     * WebElement textBox: unique ID or path to the textbox
     */
    protected boolean validateFieldIsEmpty(WebElement textBox) {
        try {
            Log.info("Checking if the following element is empty. ID=" + textBox.getAttribute("id") + " , CLASS=" + textBox.getAttribute("class") + " , NAME=" + textBox.getAttribute("name"));
            textBox.getText().isEmpty();
        } catch (NoSuchElementException e) {
            Log.error("Could not find the requested textbox.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * validateIfSumIsCorrect method is checking if the sum of two numbers entered in textboxes
     * are correctly calculated on a page
     * Params:
     * WebElement number1: unique ID or path to the textbox of the first number
     * WebElement number2: unique ID or path to the textbox of the second number
     * WebElement sum: unique ID or path to the element on page displaying the sum of the numbers
     */
    protected boolean validateIfSumIsCorrect(WebElement number1, WebElement number2, WebElement sum) {
        String number1String = number1.getAttribute("value");
        int number1Int = Integer.parseInt(number1String);
        String number2String = number2.getAttribute("value");
        int number2Int = Integer.parseInt(number2String);
        String displayValueString = sum.getText();
        int displayValue = Integer.parseInt(displayValueString);
        try {
            Log.info("Checking the result of two numbers in the following WebElement. ID=" + sum.getAttribute("id") + " , CLASS=" + sum.getAttribute("class") + " , NAME=" + sum.getAttribute("name"));
            int expectedSum = number1Int + number2Int;
            return expectedSum == displayValue;
        } catch (NoSuchElementException e) {
            Log.error("Could not find the requested WebElement.");
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
        Log.info("Drawing border around the following element. ID=" + element.getAttribute("id") + " , CLASS=" + element.getAttribute("class") + " TEXT=" + element.getText());
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("arguments [0].style.border='solid red'", element);
        }
        return element.getAttribute("style").contains("solid red");
    }

    /**
     * dragAndDropWebelement method is dragging a WebElement and dropping it into another WebElement
     * Params:
     * WebElement draggable: unique ID or path to the element we want to drag
     * WebElement droppable: unique ID or path to the element in which we want to drop the draggable element
     */
    protected boolean dragAndDropWebelement(WebElement draggable, WebElement droppable) {
        try {
            Log.info("Dragging and dropping the following element: ID=" + draggable.getAttribute("id") + " , CLASS=" + draggable.getAttribute("class") + " , NAME=" + draggable.getAttribute("name") + " into element ID= " + droppable.getAttribute("id") + " , CLASS=" + draggable.getAttribute("class") + " , NAME=" + draggable.getAttribute("name"));
            Actions drag = new Actions(driver);
            drag.dragAndDrop(draggable, droppable).build().perform();
        } catch (NoSuchElementException e) {
            Log.error("Could not find the requested elements.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * waitingForElementToBeVisible method is enabling to wait for a certain WebElement
     * for a certain number of seconds
     * Params:
     * WebElement element: unique ID or path to the WebElement we are waiting for to be visible
     * int seconds: number of seconds we are waiting before throwing an exception
     */
    protected boolean waitingForElementToBeVisible(WebElement element, int seconds) {
        try {
            Log.info("Waiting for the following element to be visible: ID=" + element.getAttribute("id") + " , CLASS=" + element.getAttribute("class") + " , NAME=" + element.getAttribute("name"));
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("element")));
        } catch (NoSuchElementException e) {
            Log.error("Could not find the requested element.");
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
