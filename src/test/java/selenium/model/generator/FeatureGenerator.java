package selenium.model.generator;

import java.nio.file.Path;

public interface FeatureGenerator {
    void generateFeatureFile(Path pathToFeatureTemplate, Path pathToFeatureOutput);
}
