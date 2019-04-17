package selenium.testRunners;

import org.junit.Assert;
import org.junit.Test;

import cucumber.api.cli.Main;

public class TestJunitParallel {

    @Test
    public void testFeautures() {
        Assert.assertEquals("There were test failures.", 0,
                            Main.run(new String[] { "--threads", "3", "-p", "json:target/test_result/test-report.json", "-p", "html:target/test_result/html-result", "-t", "@Sample", "-g",
                                    "selenium/stepDefinitions", "src/test/resources/features/basic" }, Thread.currentThread()
                                                                                                             .getContextClassLoader()));
    }

}