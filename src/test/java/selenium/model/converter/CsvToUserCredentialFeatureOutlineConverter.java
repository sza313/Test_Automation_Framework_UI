package selenium.model.converter;

import com.opencsv.CSVReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import selenium.model.UserCredentials;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CsvToUserCredentialFeatureOutlineConverter {
    private final Logger LOG = LogManager.getLogger(getClass());
    private List<UserCredentials> userCredentials;

    public CsvToUserCredentialFeatureOutlineConverter(String csvLocation) {
        this.userCredentials = beanBuilderExample(csvLocation);
    }

    private List<UserCredentials> beanBuilderExample(String path) {
        Optional<List<UserCredentials>> userCredentials = Optional.empty();
        try (FileReader fileReader = new FileReader(path)) {
            CSVReader reader = new CSVReader(fileReader);
            reader.readNext();
            userCredentials = Optional.of(reader.readAll().stream().map(l -> new UserCredentials(l)).collect(Collectors.toList()));
        } catch (IOException e) {
            LOG.error("Cannot read from " + path, e);
        }
        return userCredentials.orElse(Collections.emptyList());
    }

    public List<UserCredentials> getUserCredentials() {
        return userCredentials;
    }
}
