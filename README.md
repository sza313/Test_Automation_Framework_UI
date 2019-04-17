#Accenture DATC - UI Test Automation framework

## Setting up Selenium grid
Downlod the following binaries to the same folder:
- selenium standalone: https://www.seleniumhq.org/download/
- chromedriver: https://chromedriver.storage.googleapis.com/index.html?path=73.0.3683.68/ (chromedriver 74 is not yet compatible, please check back later)
- gheckodriver: https://github.com/mozilla/geckodriver/releases
- edgedriver: https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/ (needs windows 10, rel 17134)

## Run in IDE
Right click the class C:\accenture\frameworks\Test_Automation_Framework_UI\src\test\java\selenium\testRunners\TestJunitParallel.java and run ad JUnit test.

## Run with maven
mvn -Dtest=TestJunitParallel clean test -f pom.xml