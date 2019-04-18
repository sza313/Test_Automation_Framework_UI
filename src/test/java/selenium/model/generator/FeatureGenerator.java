package selenium.model.generator;

import java.nio.file.Path;
import java.util.List;

public interface FeatureGenerator {
    void generateFeatureFile(Path pathToFeatureTemplate, Path pathToFeatureOutput);
}
