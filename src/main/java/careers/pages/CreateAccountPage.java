package careers.pages;

import careers.testbase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;

public class CreateAccountPage {

    WebDriver driver;

    //Locating WebElements for Create Account Page
    //Email Address locator
    @FindBy(xpath = "//input[@type='email']")
    WebElement textboxEmailAddress;
    //Password locator
    @FindBy(xpath = "//input[@type='password']")
    WebElement textboxPassword;
    //Locating web element for Create Account button
    @FindBy(xpath = "//button[text()[contains(., 'Create Account')]]")
    WebElement btnCreateAccount;
    @FindBy(xpath = "//span[text()[contains(.,  'Email Taken')]]")
    WebElement labelEmailExists;

    public void CreateAccountPageDriver(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //method to create new user
    public void createNewUser(String strEmailAddress, String strPassword) throws Exception {

        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertTrue(textboxEmailAddress.isDisplayed());
        textboxEmailAddress.sendKeys(strEmailAddress);
        BaseClass.extentTest.log(LogStatus.PASS, "Email Address entered is: " + strEmailAddress);
        textboxPassword.sendKeys(strPassword);
        BaseClass.extentTest.log(LogStatus.PASS, "Password is entered");
        Assert.assertTrue(btnCreateAccount.isDisplayed());
        btnCreateAccount.click();
        BaseClass.extentTest.log(LogStatus.PASS, "Create Account Button is Clicked");
    }

}
