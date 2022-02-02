package careers;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import careers.pages.LoginPage;
import careers.pages.CreateAccountPage;
import careers.testbase.BaseClass;
import careers.pages.BasicInfoPage;

public class SafariCreateAccountTestScript extends BaseClass {

    LoginPage loginpage = new LoginPage();
    CreateAccountPage createaccountPage = new CreateAccountPage();
    BasicInfoPage basicinfopage = new BasicInfoPage();

    //@Parameters({"strEmailAdddress", "strPassword"})
    @Test
    public void verifyBasicInfoScreen() throws Exception {

        extentTest.log(LogStatus.INFO,"Verify Account Creation for new user in Safari Browser");
        //loginpage.LoginPageDriver(BaseClass.driver);
        createaccountPage.CreateAccountPageDriver(BaseClass.driver);
        basicinfopage.BasicInfoDriver(BaseClass.driver);

        createaccountPage.createNewUser(ReadProperties.get("safariemailaddress"), ReadProperties.get("safaripassword"));
        extentTest.log(LogStatus.PASS,"Account is created for new user successfully");

        basicinfopage.enterBasicInfo(ReadProperties.get("sfirstname"), ReadProperties.get("slastname"), ReadProperties.get("mobilenumber"), ReadProperties.get("zipcode"));
        extentTest.log(LogStatus.PASS,"User is navigated to Confirm Phone Screen");

    }
}
