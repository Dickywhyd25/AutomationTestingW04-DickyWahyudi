package com.juaracoding;

import com.juaracoding.DriverSingleton;
import com.juaracoding.utils.Constants;
import com.juaracoding.utils.ScenarioTest;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hook {

    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static ExtentReports reports = new ExtentReports("target/extent-report.html");

    @Before
    public void setup() {
        if (DriverSingleton.getDriver() == null) {
            DriverSingleton.getInstance(Constants.CHROME);
        }
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        ScenarioTest[] tests = ScenarioTest.values();
        extentTest = reports.startTest(tests[Utils.testCount].getScenarioTestName());
        Utils.testCount++;
    }

//    @BeforeStep
//    public void beforeStep() {
//
//        Utils.delay(1);
//    }

    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        String screenshotName = scenario.getName().replace(" ", "_");
        String screenshotPath = Utils.getScreenshot(driver, screenshotName, scenario.isFailed());
        if (scenario.isFailed()) {
            extentTest.log(LogStatus.FAIL, scenario.getName() + "\n" + extentTest.addScreenCapture(screenshotPath));
        } else {
            extentTest.log(LogStatus.PASS, scenario.getName() + "\n" + extentTest.addScreenCapture(screenshotPath));
        }
        Utils.delay(1);
    }

    @After
    public void endScenarioTest() {
        reports.endTest(extentTest);
        reports.flush();
    }

    @AfterAll
    public static void finish() {
        Utils.delay(2);
        DriverSingleton.closeObjectInstance();
    }
}
