package careers.pages;

import careers.testbase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import com.relevantcodes.extentreports.LogStatus;

public class BasicInfoPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@type = 'text' and @name='firstName']")
    WebElement textboxFirstName;
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement textboxLastName;
    @FindBy(xpath = "//input[@name='mobile']")
    WebElement textboxMobileNumber;
    @FindBy(xpath = "//input[@ng-model = 'user.profile.zip']")
    WebElement textboxZipCode;
    @FindBy(xpath = "//md-radio-group/md-radio-button[@value='CNA']")
    WebElement radiobtnQualificationTypeCNA;
    @FindBy(xpath = "//md-radio-group/md-radio-button[@value='CNA']/div[@class='md-label']")
    WebElement radiobtnQualificationSelectedValue;
    @FindBy(xpath = "//div/md-checkbox[@aria-label ='Weekday Checkbox']")
    WebElement checkboxWeekdayShift;
    @FindBy(xpath = "//div/md-checkbox[@aria-label ='Weekday Checkbox']/div[@class='md-label']")
    WebElement checkboxShiftSelectedValue;
    @FindBy(xpath = "//md-input-container/md-radio-group/md-radio-button[@value='6_Months']/div[@class='md-container md-ink-ripple']")
    WebElement radiobtnWorkExperience;
    @FindBy(xpath = "//md-radio-button[@value='6_Months']/div[@class='md-label']")
    WebElement radiobtnWorkExperienceSelectedValue;
    @FindBy(xpath = "//md-input-container/md-checkbox/div[@class='md-container md-ink-ripple']")
    WebElement checkboxTermsOfService;
    @FindBy(xpath = "//button/span[text()[contains(., 'Continue')]]")
    WebElement btnContinue;
    @FindBy(xpath = "//*[text()[contains(., 'Confirm Phone')]]")
    WebElement labelConfirmPhone;
    @FindBy(xpath = "//button/span[text()[contains(., 'Continue')]]")
    WebElement btnConfirmPhoneContinue;

    public void BasicInfoDriver(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterBasicInfo(String strFirstName, String strLastName, String strMobileNumber, String strZipCode) throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(btnContinue.isDisplayed());
        Assert.assertFalse(!btnContinue.isEnabled());
        BaseClass.extentTest.log(LogStatus.PASS, "Continue Button is grayed out");
        textboxFirstName.sendKeys(strFirstName);
        BaseClass.extentTest.log(LogStatus.PASS, "First Name entered is: " + strFirstName);
        textboxLastName.sendKeys(strLastName);
        BaseClass.extentTest.log(LogStatus.PASS, "Last Name entered is: " + strLastName);
        textboxMobileNumber.sendKeys(strMobileNumber);
        BaseClass.extentTest.log(LogStatus.PASS, "Mobile Number entered is: " + strMobileNumber);
        textboxZipCode.sendKeys(strZipCode);
        BaseClass.extentTest.log(LogStatus.PASS, "Zip Code entered is: " + strZipCode);
        radiobtnQualificationTypeCNA.click();
        BaseClass.extentTest.log(LogStatus.PASS, "Qualification Type " + getQualificationType()  + " is Selected ");
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("window.scrollBy(907, 626)", "");
        checkboxWeekdayShift.click();
        BaseClass.extentTest.log(LogStatus.PASS, "Qualification Type " + getShifts()  + " is Selected ");
        radiobtnWorkExperience.click();
        BaseClass.extentTest.log(LogStatus.PASS, "Qualification Type " + getWorkExperience()  + " is Selected ");
        Assert.assertTrue(checkboxTermsOfService.isDisplayed());
        checkboxTermsOfService.click();
        BaseClass.extentTest.log(LogStatus.PASS, "Terms Of Service checkbox is checked");
        Assert.assertTrue(btnContinue.isEnabled());
        BaseClass.extentTest.log(LogStatus.PASS, "Continue Button is enabled after entering the basic Info");
        btnContinue.click();
        BaseClass.extentTest.log(LogStatus.PASS, "Continue Button is Clicked");
        Assert.assertTrue(labelConfirmPhone.isDisplayed());
        Assert.assertFalse(!btnConfirmPhoneContinue.isEnabled());
    }

    public String getQualificationType() {
        return radiobtnQualificationSelectedValue.getText();
    }

    public String getWorkExperience() {
        return radiobtnWorkExperienceSelectedValue.getText();
    }

    public String getShifts() {
        return checkboxShiftSelectedValue.getText();
    }

}
