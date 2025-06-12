package driver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import com.automation.enums.ConfigProperties;
//import com.automation.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import enums.ConfigProperties;
import utils.PropertyUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {

    private Driver() {
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver() {
        String browserType = PropertyUtils.getConfigProperty(ConfigProperties.BROWSER);
        String runMode = PropertyUtils.getConfigProperty(ConfigProperties.RUNMODE);  //remote  //local

        if (browserType == null || browserType.isEmpty()) {
            throw new IllegalArgumentException("Browser type is not specified in the properties file.");
        }

        if (driver.get() == null) {
            if (runMode.equalsIgnoreCase("remote")) {
                driver.set(initRemoteDriver(browserType));
            } else {
                switch (browserType.toLowerCase()) {
                    case "chrome":
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--disable-notifications");
                        chromeOptions.addArguments("--start-maximized");
                        driver.set(new ChromeDriver(chromeOptions));
                        break;
                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--disable-notifications");
                        firefoxOptions.addArguments("--start-maximized");
                        driver.set(new FirefoxDriver(firefoxOptions));
                        break;
                    case "edge":
                        EdgeOptions edgeOptions = new EdgeOptions();
                        edgeOptions.addArguments("--start-maximized");
                        driver.set(new EdgeDriver(edgeOptions));
                        break;
                    default:
                        throw new IllegalArgumentException("Browser type not supported: " + browserType);
                }
            }
        }

        WebDriver driverInstance = driver.get();
        if (driverInstance != null) {
            driverInstance.get(PropertyUtils.getConfigProperty(ConfigProperties.URL));
//            driverInstance.manage().window().maximize();
            driverInstance.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driverInstance;
    }

    private static WebDriver initRemoteDriver(String browserType) {
        try {
            RemoteWebDriver driver;
            switch (browserType.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setCapability("browserName", "chrome");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setCapability("browserName", "firefox");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.setCapability("browserName", "edge");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), edgeOptions);
                    break;
                default:
                    throw new IllegalArgumentException("Browser type not supported: " + browserType);
            }
            System.out.println("Remote WebDriver created successfully for: " + browserType);
            return driver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Malformed URL for the RemoteWebDriver hub");
        }
        
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
    
    
    public static String getBase64Screenshot() {
    	return ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.BASE64);
    }
}