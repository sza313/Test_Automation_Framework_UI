package selenium.model.converter;

import com.opencsv.CSVReader;
import selenium.model.UserCredentials;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvToUserCredentialFeatureOutlineConverter {
    List<UserCredentials> userCredentials;
    public CsvToUserCredentialFeatureOutlineConverter(String csvLocation) {
           this.userCredentials = beanBuilderExample(csvLocation);
    }

    private List<UserCredentials> beanBuilderExample(String path) {
        List<UserCredentials> userCredentials = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(path));
            reader.readNext();
            userCredentials = reader.readAll().stream().map(l -> new UserCredentials(l)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userCredentials;
    }

    public List<UserCredentials> getUserCredentials() {
        return userCredentials;
    }
}
