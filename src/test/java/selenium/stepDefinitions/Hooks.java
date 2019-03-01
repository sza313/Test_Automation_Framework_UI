package selenium.stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import selenium.utils.DriverUtil;
import selenium.utils.Log;

import java.util.concurrent.TimeUnit;

public class Hooks extends DriverUtil {

    @Before
    public void beforeScenario(){
        Log.startLog();
        createNewDriver();
    }

    @After
    public void afterScenario(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        Log.endLog();
        driver.quit();
    }
}
