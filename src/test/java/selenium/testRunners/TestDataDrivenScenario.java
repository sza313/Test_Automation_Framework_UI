package selenium.testRunners;

import cucumber.api.cli.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import selenium.model.UserCredentials;
import selenium.model.converter.CsvToUserCredentialFeatureOutlineConverter;
import selenium.model.generator.UserCredentialsFeatureGenerator;

import java.nio.file.Paths;
import java.util.List;

public class TestDataDrivenScenario {

    @Before
    public void setUp() {
        List<UserCredentials> userCredentials =
                new CsvToUserCredentialFeatureOutlineConverter("src/test/resources/datasource/user-credentials.csv").getUserCredentials();

        UserCredentialsFeatureGenerator featureGenerator = new UserCredentialsFeatureGenerator(userCredentials);
        featureGenerator.generateFeatureFile(
                Paths.get("src/test/resources/datasource/form-filler-feature-outline.template"),
                Paths.get("src/test/resources/features/datadriven/generated-form-filler-outline.feature")
        );
    }

    @Test
    public void testRunCucumber() {
        Assert.assertEquals("There were test failures.", 0,
                Main.run(new String[]{"--threads", "3",
                                "-p", "json:target/test_result/data-driven-test-report.json",
                                "-p", "html:target/test_result/html-result",
                                "-t", "@DataDriven",
                        "-d",
                                "-g", "selenium/stepDefinitions",
                                "src/test/resources/features/datadriven/generated-form-filler-outline.feature"},
                        Thread.currentThread().getContextClassLoader()));
    }
}
