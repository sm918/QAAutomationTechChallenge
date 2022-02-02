package careers.testbase;

import careers.ReadProperties;
import org.apache.maven.surefire.shade.org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;

public class BaseClass {

    public static WebDriver driver;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    @BeforeSuite
    public void beforeSuite(ITestContext iTestContext) {
        String suitName = iTestContext.getSuite().getName();
        //SUITENAME = "\\ExtentReport.html";
        String extendReportPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator
                + "\\ExtentReport.html" + File.separator;
        extentReports = new ExtentReports(extendReportPath);
    }

    @Parameters("browser")
    @BeforeMethod
    public void initilaizeDriver(@Optional("chrome") String browserName) throws Exception {
       //extentReports = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReport.html");
        extentTest = extentReports.startTest(this.getClass().getSimpleName());
        driver = BrowserDriver.getDriver(browserName);
        extentTest.log(LogStatus.PASS, "Browser Launching...");
        driver.get(ReadProperties.get("url"));
        extentTest.log(LogStatus.PASS, "The User is navigated to Intelycare Application Page");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                String str = result.getThrowable().getCause().toString().replace("<", " ").replace(">", " ");
                extentTest.log(LogStatus.FAIL, StringUtils.substringBefore(str, "(Session info:"));
                extentReports.endTest(extentTest);
                extentReports.flush();
            } catch (NullPointerException e) {
                extentTest.log(LogStatus.FAIL, result.getThrowable());
                extentReports.endTest(extentTest);
                extentReports.flush();
            }
        }
        driver.quit();
        //driver=null;
        extentReports.endTest(extentTest);
        extentReports.flush();
    }
}

