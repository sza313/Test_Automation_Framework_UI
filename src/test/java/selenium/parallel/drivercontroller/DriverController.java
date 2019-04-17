package selenium.parallel.drivercontroller;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverController {
    private final static Logger LOG = LogManager.getLogger();
    private WebDriver webDriver = null;

    public DriverController() {
    }

    public void initializeWebDriver(String browserType) {
        LOG.info("Browser type is - " + browserType);
        MutableCapabilities capabilities = getBrowserCapability(browserType);
        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:5050/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            LOG.error("Could not initialize driver.", e);
        }
    }

    private MutableCapabilities getBrowserCapability(String browserType) {
        MutableCapabilities capability = null;
        if ("firefox".equals(browserType)) {
            capability = new FirefoxOptions();
        } else if ("edge".equals(browserType)) {
            capability = new EdgeOptions();
        } else {
            capability = new ChromeOptions();
        }
        return capability;
    }

    public void cleanUpWebDriver() {
        LOG.info("Quitting webdriver.");
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
