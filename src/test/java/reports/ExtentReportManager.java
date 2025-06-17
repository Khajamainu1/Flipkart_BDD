package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // Singleton instance of ExtentReports
    public static ExtentReports getInstance() {
        if (extentReports == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReports/ExtentReport.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(reporter);
            
        }
        return extentReports;
    }

    // Set test to ThreadLocal
    public static void setExtentTest(ExtentTest test) {
        extentTest.set(test);
    }

    // Get current ThreadLocal test
    public static ExtentTest getExtentTest() {
        return extentTest.get();
    }

    // Flush reports at the end
    public static void flushReports() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}