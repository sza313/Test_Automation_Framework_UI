package selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.pageObjects.FormFillerPageObjects;

public class FormFillerPage extends FormFillerPageObjects {
    private final static Logger LOG = LogManager.getLogger();
    private WebDriver driver;

    public FormFillerPage(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
        LOG.info("Formfiller page initialized.");
    }

    public boolean selectFromRadioButton(String input) {
        if("yes".equalsIgnoreCase(input)) {
            driver.findElements(By.cssSelector("input[type='radio']")).get(0);
        } else {
            driver.findElements(By.cssSelector("input[type='radio']")).get(1);
        }
        return true;
    }
}
