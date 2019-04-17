package selenium.model.generator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import selenium.model.UserCredentials;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class UserCredentialsFeatureGenerator implements FeatureGenerator {
    private final static Logger LOG = LogManager.getLogger();
    private final List<UserCredentials> userCredentials;

    public UserCredentialsFeatureGenerator(List<UserCredentials> userCredentials) {
        this.userCredentials = userCredentials;
    }

    @Override
    public void generateFeatureFile(Path pathToFeatureTemplate, Path pathToFeatureOutput) {
        try {
            generateCsvDrivenFeatureOutlineFile(pathToFeatureTemplate, pathToFeatureOutput);
        } catch (IOException e) {
            LOG.error("Cannot generate output feature file.", e);
        }
    }

    private void generateCsvDrivenFeatureOutlineFile(Path pathToFeatureTemplate, Path pathToFeatureOutput)
            throws IOException {
        Files.delete(pathToFeatureOutput);
        Files.createFile(pathToFeatureOutput);

        List<String> templateLines = Files.readAllLines(pathToFeatureTemplate);
        userCredentials.forEach(l -> templateLines.add("\t\t\t" + l.toString()));

        Files.write(pathToFeatureOutput, templateLines);
    }

}
