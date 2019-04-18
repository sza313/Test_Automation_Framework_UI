package selenium.utils;

import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.Optional;

public class DriverUtil {

    public static Properties properties = new Properties();
    public WebDriver driver;

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String COULD_NOT_FIND_THE_REQUESTED_ELEMENT = "Could not find the requested element.";

    public DriverUtil(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks to a {@link WebElement}.
     *
     * @param element the {@link WebElement} to click
     * @return True, if the click was successful
     */
    protected boolean clickToElement(WebElement element) {
        try {
            LOGGER.info("Clicking to the following element. NAME=" + getAttributeOrEmptyString(element, "name"));
            clickElement(element);
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
        return true;
    }

    /**
     * Draws a red border around the clicked {@link WebElement}.
     * 
     * @param element the {@link WebElement} to click
     * @return True, if the click was successful
     */
    protected boolean clickToElementWithVisualization(WebElement element) {
        try {
            LOGGER.info("Clicking to the following element with visualization. NAME=" + getAttributeOrEmptyString(element, "name"));
            drawBorder(element);
            clickElement(element);
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
        return true;
    }

    /**
     * Clicks to a {@link WebElement} using JavaScript.
     * 
     * @param element the {@link WebElement} to click
     * @return True, if the click was successful
     */
    protected boolean clickToElementWithJS(WebElement element) {
        try {
            LOGGER.info("Clicking with javascript to the following element: NAME=" + getAttributeOrEmptyString(element, "name"));
            executeScript("arguments[0].click();", element);
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
        return true;
    }

    /**
     * Clicks all {@link WebElement}s in a list
     *
     * @param elements the list of {@link WebElement}s to click
     * @return True, if the clicks were successful
     */
    protected boolean clickToMultipleElements(List<WebElement> elements) {
        try {
            LOGGER.info("Clicking to multiple elements: ");
            elements.forEach(this::clickToElement);
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
        return true;
    }

    /**
     * Draws a red border around the clicked {@link WebElement}s.
     * 
     * @param elements the {@link WebElement}s to click
     * @return True, if the click was successful
     */
    protected boolean clickToMultipleElementsWithVisualization(List<WebElement> elements) {
        try {
            LOGGER.info("Clicking with visualization to multiple elements: ");
            elements.forEach(this::clickToElementWithVisualization);
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
        return true;
    }

    /**
     * Writes a string into text box {@link WebElement}.
     * 
     * @param textBox the text box {@link WebElement}
     * @param text the string to insert
     * @return True, if the insertion of text was successful
     */
    protected boolean writeIntoTextBox(WebElement textBox, String text) {
        try {
            LOGGER.info("Writing text '" + text + "' into the following textbox: NAME=" + getAttributeOrEmptyString(textBox, "name"));
            scrollToElementWithJS(textBox);
            clearTextBox(textBox);
            textBox.sendKeys(text);
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
        return compareString(textBox, text);
    }

    /**
     * Clear the input of a {@link WebElement} using Selenium's clear() method.
     * 
     * @param element {@link WebElement} to clear
     * @return True, if the clearance was successful
     */
    protected boolean clearTextBox(WebElement element) {
        try {
            LOGGER.info("Clear the following element: NAME=" + getAttributeOrEmptyString(element, "name"));
            element.clear();
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
        return true;
    }

    /**
     * Clear the input of a {@link WebElement} using BackSpace keys.
     * 
     * @param textBox {@link WebElement} to clear
     * @return True, if the clearance was successful
     */
    protected boolean clearFieldWithBackspace(WebElement textBox) {
        try {
            LOGGER.info("Clearing data from the following textbox with backspace. NAME=" + getAttributeOrEmptyString(textBox, "name"));
            String inputText = getAttributeOrEmptyString(textBox, "value");
            for (int i = 0; i < inputText.length(); i++) {
                textBox.sendKeys(Keys.BACK_SPACE);
            }
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
        return true;
    }

    /**
     * Compares a string to the text of a {@link WebElement}.
     * 
     * @param elementWithText {@link WebElement} to compare the text to
     * @param expectedText expected text
     * @return True, if the texts are equal
     */
    protected boolean compareString(WebElement elementWithText, String expectedText) {
        try {
            LOGGER.info("Comparing text '" + expectedText + "' with the text of the following element: NAME=" + getAttributeOrEmptyString(elementWithText, "name"));
            String actualText;
            if (elementWithText.getText()
                               .isEmpty()) {
                actualText = getAttributeOrEmptyString(elementWithText, "value");
            } else {
                actualText = elementWithText.getText();
            }
            return actualText.equals(expectedText);
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
    }

    /**
     * Write random alphabetic string into text box {@link WebElement}.
     * 
     * @param textBox {@link WebElement} to write text into
     * @param length length of the random string to generate
     * @return True if the text is successfully written into the {@link WebElement}
     */
    public boolean writeRandomAlphabeticString(WebElement textBox, int length) {
        String randomAlphabeticString = createRandomAlphabeticString(length);
        return writeIntoTextBox(textBox, randomAlphabeticString);
    }

    /**
     * Write random numeric string into text box {@link WebElement}.
     * 
     * @param textBox {@link WebElement} to write text into
     * @param length length of the random string to generate
     * @return True if the text is successfully written into the {@link WebElement}
     */
    public boolean writeRandomNumericString(WebElement textBox, int length) {
        String randomNumericString = createRandomNumericString(length);
        return writeIntoTextBox(textBox, randomNumericString);
    }

    /**
     * Write random alphanumeric string into text box {@link WebElement}.
     * 
     * @param textBox {@link WebElement} to write text into
     * @param length length of the random string to generate
     * @return True if the text is successfully written into the {@link WebElement}
     */
    public boolean writeRandomAlphanumericString(WebElement textBox, int length) {
        String randomAlphanumericString = createRandomAlphanumericString(length);
        return writeIntoTextBox(textBox, randomAlphanumericString);
    }

    /**
     * Create random alphabetic string of given length.
     * 
     * @param length length of the string to generate
     * @return Generated string
     */
    protected String createRandomAlphabeticString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    /**
     * Create random numeric string of given length.
     * 
     * @param length length of the string to generate
     * @return Generated string
     */
    protected String createRandomNumericString(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    /**
     * Create random alphanumeric string of given length.
     * 
     * @param length length of the string to generate
     * @return Generated string
     */
    protected String createRandomAlphanumericString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    /**
     * Checks if the certain text box {@link WebElement} is empty.
     * 
     * @param textBox {@link WebElement} to check
     * @return True, if the {@link WebElement} is empty
     */
    protected boolean validateFieldIsEmpty(WebElement textBox) {
        try {
            LOGGER.info("Checking if the following element is empty. NAME=" + getAttributeOrEmptyString(textBox, "name"));
            return textBox.getText()
                          .isEmpty();
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
    }

    /**
     * Checks whether the sum of two numbers entered in text boxes are correctly calculated on a page.
     * 
     * @param number1 first number's {@link WebElement}
     * @param number2 second number's {@link WebElement}
     * @param sum sum's {@link WebElement}
     * @return True, if the addition was correct
     */
    protected boolean validateIfSumIsCorrect(WebElement number1, WebElement number2, WebElement sum) {
        int number1Int = Integer.parseInt(getAttributeOrEmptyString(number1, "value"));
        int number2Int = Integer.parseInt(getAttributeOrEmptyString(number2, "value"));
        int displayValue = Integer.parseInt(sum.getText());
        try {
            LOGGER.info("Checking the result of two numbers in the following WebElement. NAME=" + getAttributeOrEmptyString(sum, "name"));
            int expectedSum = number1Int + number2Int;
            return expectedSum == displayValue;
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
    }

    /**
     * Sets the value of a checkbox to a required one.
     * 
     * @param checkbox the checkbox {@link WebElement} to set
     * @param checkboxValueToSet boolean value to set in the checkbox
     * @return result of comparison of actual and expected values
     */
    protected boolean setCheckboxValue(WebElement checkbox, boolean checkboxValueToSet) {
        try {
            LOGGER.info("Setting to " + checkboxValueToSet + " the value of the following checkbox: NAME=" + getAttributeOrEmptyString(checkbox, "name"));
            if (checkboxValueToSet != checkbox.isSelected()) {
                clickElement(checkbox);
            }
            return checkboxValueToSet == checkbox.isSelected();
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
    }

    public boolean selectFromDropDown(WebElement element, String input) {
        try {
            Select stateDropDown = new Select(element);
            stateDropDown.selectByVisibleText(input);
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
        return true;
    }

    /**
     * Slides the handle of a range slider to a required value.
     * 
     * @param rangeSlider range slider {@link WebElement}
     * @param valueToSet value to set on slider
     * @return True, if the value could have been set
     */
    protected boolean moveRangeSliderToValue(WebElement rangeSlider, int valueToSet) {
        try {
            int minValue = Integer.valueOf(getAttributeOrEmptyString(rangeSlider, "min"));
            int maxValue = Integer.valueOf(getAttributeOrEmptyString(rangeSlider, "max"));
            LOGGER.info(String.format("Setting to '%d' the value of the following range slider: NAME=%s, MIN=%s, MAX=%s", valueToSet, getAttributeOrEmptyString(rangeSlider, "name"), minValue,
                                      maxValue));
            if (valueToSet < minValue || valueToSet > maxValue) {
                LOGGER.error(String.format("The requested value is out of range. Min: %d, Max: %d, Expected: %d", minValue, maxValue, valueToSet));
                return false;
            } else {
                int initialValue = Integer.valueOf(getAttributeOrEmptyString(rangeSlider, "value"));
                int difference = Math.abs(initialValue - valueToSet);
                if (initialValue < valueToSet) {
                    for (int i = 0; i < difference; i++) {
                        rangeSlider.sendKeys(Keys.ARROW_RIGHT);
                    }
                } else if (valueToSet < initialValue) {
                    for (int i = 0; i < difference; i++) {
                        rangeSlider.sendKeys(Keys.ARROW_LEFT);
                    }
                }
            }
            return Integer.valueOf(getAttributeOrEmptyString(rangeSlider, "value")) == valueToSet;
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
    }

    /**
     * Draws a red border around the found element.
     * 
     * @param element {@link WebElement} to draw the red border around
     * @return True, if the element has been successfully bordered
     */
    public boolean drawBorder(WebElement element) {
        try {
            LOGGER.info("Drawing border around the following element. NAME=" + getAttributeOrEmptyString(element, "name"));
            executeScript("arguments [0].style.border='solid red'", element);
            return getAttributeOrEmptyString(element, "style").contains("solid red");
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
    }

    /**
     * Scrolls to element with JavaScript.
     * 
     * @param element {@link WebElement} to scroll to
     * @return True, if the scrolling was successful.
     */
    protected boolean scrollToElementWithJS(WebElement element) {
        try {
            LOGGER.info("Scrolling to the following element: NAME=" + getAttributeOrEmptyString(element, "name"));
            executeScript("arguments[0].scrollIntoView();", element);
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
        return true;
    }

    /**
     * Scrolls to element with JavaScript with offset.
     * 
     * @param element {@link WebElement} to scroll to
     * @param xOffset offset on the x axis
     * @param yOffset offset on the y axis
     * @return True, if the scrolling was successful.
     */
    protected boolean scrollToElementWithOffset(WebElement element, int xOffset, int yOffset) {
        try {
            scrollToElementWithJS(element);
            LOGGER.info("Scrolling with offset: X=" + xOffset + "px, Y=" + yOffset + "px");
            executeScript("window.scrollBy(arguments[0],arguments[1]);", xOffset, yOffset);
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
        return true;
    }

    /**
     * Compares the page title with the expected text.
     * 
     * @param expectedTitle expexted title
     * @return True, if the title equals the expected text.
     */
    protected boolean comparePageTitle(String expectedTitle) {
        return driver.getTitle()
                     .equals(expectedTitle);
    }

    protected boolean selectFromRadioButton(List<WebElement> webElements, String input) {
        try {
            if ("yes".equalsIgnoreCase(input)) {
                webElements.get(0)
                           .click();
                ;
            } else {
                webElements.get(1)
                           .click();
            }
        } catch (NoSuchElementException e) {
            LOGGER.error(COULD_NOT_FIND_THE_REQUESTED_ELEMENT, e);
            return false;
        }
        return true;
    }

    private String executeScript(String script, Object... objects) {
        return (String) ((JavascriptExecutor) driver).executeScript(script, objects);
    }

    private void clickElement(WebElement element) {
        scrollToElementWithJS(element);
        element.click();
    }

    private String getAttributeOrEmptyString(WebElement elementWithText, String attribute) {
        Optional<String> attributeValue = Optional.of(elementWithText.getAttribute(attribute));
        if (!attributeValue.isPresent()) {
            LOGGER.error(String.format("'%s' attribute does not exist for element: '%s'", attribute, elementWithText));
        }
        return attributeValue.or("");
    }
}
