package selenium.testRunners;

import cucumber.api.cli.Main;
import org.junit.Test;

public class JunitParallel {

	@Test
	public void test1() {
		Main.main(new String[]{"--threads", "3",
				"-p", "json:target/test_result/test-report.json",
				"-p", "html:target/test_result/html-result",
				"-g", "selenium/parallelstepdefs",
				"src/test/resources/features/multithreaded.feature"});
	}

}