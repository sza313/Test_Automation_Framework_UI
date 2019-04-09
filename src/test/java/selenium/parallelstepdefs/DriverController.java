package selenium.parallelstepdefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverController {
    private final static Logger LOG = LogManager.getLogger();
    private WebDriver webDriver = null;

    public DriverController() {
    }

    public void initializeWebDriver(String browserType) {
        LOG.info("Browser type is - " + browserType);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.merge(DesiredCapabilities.chrome());
        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:5050/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            LOG.error("Could not initialize driver.");
            e.printStackTrace();
        }
    }

    public void cleanUpWebDriver() {
        LOG.info("Quitting webdriver.");
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
