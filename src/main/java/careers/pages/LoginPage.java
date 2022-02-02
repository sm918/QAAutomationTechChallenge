package careers.pages;

import careers.testbase.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.WebElement;

public class LoginPage {

    Logger log = LogManager.getLogger(String.valueOf(LoginPage.class));
    WebDriver driver;

    @FindBy(xpath = "//h5[@class='centeredTxt']/Span[text()[contains(., 'Log In')]]")
    WebElement linkLogIn;
    //Locating web element for email address
    @FindBy(xpath = "//input[@type='email']")
    WebElement emailAddressLogIn;
    //Locating web element for password
    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordLogIn;
    @FindBy(xpath = "//button[text()[contains(., 'Log In')]]")
    WebElement btnLogIn;

    public void LoginPageDriver(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginToIC(String strEmailAddress, String strPassword) throws Exception {

       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        waitVisibility(driver, linkLogIn, 10);
        linkLogIn.click();
        emailAddressLogIn.sendKeys(strEmailAddress);
        passwordLogIn.sendKeys(strPassword);
        btnLogIn.click();
        //log.info("User logged in Successfully");
        BaseClass.extentTest.log(LogStatus.PASS, "Login Button is Clicked");
    }

    public void waitVisibility(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            log.error("Exception is occurred. ", e.getMessage());
            Assert.assertFalse(false, "Failed the test - " + e.getMessage());
        }
    }

}