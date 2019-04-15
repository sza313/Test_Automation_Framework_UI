package selenium.parallel.context;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class CucumberTestContext {
    private final static Logger LOG = LogManager.getLogger();
    private WebDriver webDriver;

    public CucumberTestContext() {
        LOG.info("Context initialized.");
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        SessionId session = ((RemoteWebDriver)webDriver).getSessionId();
        LOG.info("Webdriver set for context with session id - " + session);
    }
}
