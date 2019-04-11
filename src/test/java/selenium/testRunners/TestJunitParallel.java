package selenium.testRunners;

import cucumber.api.cli.Main;
import org.junit.Test;

public class TestJunitParallel {

	@Test
	public void test1() {
		Main.main(new String[]{"--threads", "3",
				"-p", "json:target/test_result/test-report.json",
				"-p", "html:target/test_result/html-result",
				"-t","@Sample",
				"-g", "selenium/stepDefinitions",
				"src/test/resources/features/"});
	}

}