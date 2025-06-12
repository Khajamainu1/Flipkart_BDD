package reports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Media;

public class ExtentLogger {
	
	public static void setTest(ExtentTest test) {
	    ExtentReportManager.setExtentTest(test);
	}

    public static void pass(String message) {
        ExtentReportManager.getExtentTest().pass(message);
    }

    public static void fail(String message, Media media) {
        ExtentReportManager.getExtentTest().fail(message, media);
    }

    public static void info(String message) {
        ExtentReportManager.getExtentTest().info(message);
    }

    public static void skip(String message) {
        ExtentReportManager.getExtentTest().skip(message);
    }
}