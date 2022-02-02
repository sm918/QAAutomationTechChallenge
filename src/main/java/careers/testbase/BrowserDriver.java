
package careers.testbase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class BrowserDriver {

    public static WebDriver driver;
    public static final String ChromeDriverPath = "src/main/resources/chromedriver.exe";
    public static final String FirefoxDriverPath = "src/main/resources/geckodriver.exe";
    public static final String SafariDriverPath = "/usr/bin/safaridriver";

    public static void setDriver(WebDriver driver) {
        BrowserDriver.driver = driver;
    }

    public static WebDriver getDriver(String browser) {

        String os = System.getProperty("os.name");
        if(os.startsWith("Windows")) {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
                driver = new ChromeDriver(options);
                Reporter.log("Chrome Browser is launching");
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", FirefoxDriverPath);
                driver = new FirefoxDriver();
                Reporter.log("Firefox Browser is launching");
            } else if (browser.equalsIgnoreCase("safari")) {
                driver = new SafariDriver();
            } else {
                throw new UnsupportedOperationException("Browser " + browser + " is not supported by Windows Operating System! Please update the framework to support the unsupported browser.");
            }
        } else if(os.startsWith("mac")) {
            if (browser.equalsIgnoreCase("safari")) {
                driver = new SafariDriver();
                Reporter.log("Safari Browser is launching");
            } else {
                throw new UnsupportedOperationException("Browser " + browser + " is not supported by Windows Operating System! Please update the framework to support the unsupported browser.");
            }
        }
        Capabilities newCapabilities = ((HasCapabilities) driver).getCapabilities();
        String browserName = newCapabilities.getBrowserName();
        String browserVersion = newCapabilities.getBrowserVersion();

        Reporter.log("Driver is created. Browser is " + browserName + ". Browser Version is " + browserVersion );
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeBrowser() {
        driver.close();
        Reporter.log("Browser is closed", true);
    }

}
