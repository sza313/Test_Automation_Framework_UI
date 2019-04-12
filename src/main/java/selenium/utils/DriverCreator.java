package selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverCreator extends DriverUtil {

    private static final Logger LOGGER = LogManager.getLogger();

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

        // Firstly check the system argument browser value and if it is empty then reads from the config file
        if (System.getProperty("browser") != null) {
            browser = System.getProperty("browser");
        } else {
            browser = properties.getProperty("browser");
        }

        // Select the correct browser type, chrome is the default one
        switch (browser) {
        case "firefox":
            System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
            LOGGER.info("Firefox driver is opening.");
            break;
        // TODO: debug this (won't find dropdown element)
        case "IE":
            System.setProperty("webdriver.ie.driver", "./src/main/resources/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            LOGGER.info("IE driver is opening.");
            break;
        default:
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            LOGGER.info("Chrome driver is opening by default.");
            break;
        }
        configureDriver();
    }

    /**
     * driverConfig set up driver related configs
     *
     * Params: Do not have any input params. You can set the timeout in the Config.properties file.
     */
    private void configureDriver() {
        driver.manage()
              .window()
              .maximize();
        driver.manage()
              .timeouts()
              .implicitlyWait(Long.parseLong(properties.getProperty("timeout")), TimeUnit.SECONDS);
        driver.manage()
              .timeouts()
              .pageLoadTimeout(Long.parseLong(properties.getProperty("timeout")), TimeUnit.SECONDS);
    }

    /**
     * readPropertiesFile opens the Config.properties file and save the values
     * <p>
     * Params: Do not have any input params.
     */
    private void readPropertiesFile() {
        try (InputStream input = new FileInputStream("./config/Config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            LOGGER.error("Loading properties into Properties object resulted in IOException!", e);
        }
    }
}
