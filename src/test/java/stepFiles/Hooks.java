package stepFiles;

import driver.Driver;
import enums.ConfigProperties;
import io.cucumber.java.*;
import reports.ExtentLogger;
import reports.ExtentReportManager;
import utils.PropertyUtils;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Hooks {

    @BeforeAll
    public static void beforeAll() {
        ExtentReportManager.getInstance(); // Start Extent Report
    }

//    public static boolean isReportingEnabled() {
//        return Boolean.parseBoolean(getConfigProperty("reporting.enabled"));
//    }
   
    @AfterAll
    public static void afterAll() 
    {
        ExtentReportManager.flushReports();

        if (Boolean.parseBoolean(PropertyUtils.getConfigProperty(ConfigProperties.REPORTINGENABLED)))
        {
            try {
                File reportFile = new File(System.getProperty("user.dir") + "/target/ExtentReports/ExtentReport.html");
                if (reportFile.exists())
                {
                    java.awt.Desktop.getDesktop().browse(reportFile.toURI());
                } else {
                    System.out.println("Report not found at: " + reportFile.getAbsolutePath());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Reporting is disabled. Not opening the report.");
        }
    }

    @Before
    public void setUp(Scenario scenario) {
        Driver.initDriver();
        ExtentTest test = ExtentReportManager.getInstance().createTest(scenario.getName());
        ExtentLogger.setTest(test);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String base64Screenshot = Driver.getBase64Screenshot();
            ExtentLogger.fail("Scenario Failed: " + scenario.getName(),
                MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } else {
            ExtentLogger.pass("Scenario Passed: " + scenario.getName());
        }
        Driver.quitDriver();
    }
}