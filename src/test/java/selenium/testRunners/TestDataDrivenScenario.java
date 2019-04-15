package selenium.testRunners;

import com.opencsv.CSVReader;
import cucumber.api.cli.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import selenium.model.UserCredentials;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestDataDrivenScenario {

    @Before
    public void setUp() {
        List<UserCredentials> userCredentials = beanBuilderExample("src/test/resources/datasource/user-credentials.csv");
        generateCsvDrivenFeatureFile(userCredentials, "Form filler Feature");
    }

    private void generateCsvDrivenFeatureFile(List<UserCredentials> userCredentials, String s) {
        try {
            List<String> scenarioLines = new ArrayList<>();
            scenarioLines.add("Feature: Form filler according to csv.");
            scenarioLines.add("");
            String scenarioTemplate =
                    new String(Files.readAllBytes(Paths.get("src/test/resources/datasource/data-driven-feature.template")));
            for (int i = 0; i < userCredentials.size(); i++) {
                Integer csvLine = i + 1;
                String scenario = new String(scenarioTemplate);
                scenario = scenario.replaceAll("@csvLine", csvLine.toString());
                scenario = scenario.replaceAll("@firstName", userCredentials.get(i).getFirstName());
                scenario = scenario.replaceAll("@lastName", userCredentials.get(i).getLastName());
                scenario = scenario.replaceAll("@email", userCredentials.get(i).getEmail());
                scenario = scenario.replaceAll("@phone", userCredentials.get(i).getPhone());
                scenario = scenario.replaceAll("@address", userCredentials.get(i).getAddress());
                scenario = scenario.replaceAll("@city", userCredentials.get(i).getCity());
                scenario = scenario.replaceAll("@state", userCredentials.get(i).getState());
                scenario = scenario.replaceAll("@zip", userCredentials.get(i).getZip());
                scenario = scenario.replaceAll("@domain", userCredentials.get(i).getDomain());
                scenario = scenario.replaceAll("@hosting", userCredentials.get(i).getHosting());
                scenario = scenario.replaceAll("@project_description", userCredentials.get(i).getProjectDescription());

                scenarioLines.addAll(Arrays.asList(scenario.split("\r\n")));
                scenarioLines.add("");
            }
            Path tempFeaturePath = Paths.get("src/test/resources/features/datadriven/generated-form-filler.feature");
            Files.delete(tempFeaturePath);
            Files.createFile(tempFeaturePath);
            Files.write(tempFeaturePath, scenarioLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<UserCredentials> beanBuilderExample(String path) {
        List<UserCredentials> userCredentials = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader("src/test/resources/datasource/user-credentials.csv"));
            reader.readNext();
            userCredentials = reader.readAll().stream().map(l -> new UserCredentials(l)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userCredentials;
    }

    @Test
    public void testRunCucumber() {
        Assert.assertEquals("There were test failures.", 0,
                Main.run(new String[]{"--threads", "3",
                                "-p", "json:target/test_result/test-report.json",
                                "-p", "html:target/test_result/html-result",
                                "-t", "@DataDriven",
                                "-g", "selenium/stepDefinitions",
                                "src/test/resources/features/datadriven"},
                        Thread.currentThread().getContextClassLoader()));
    }
}
