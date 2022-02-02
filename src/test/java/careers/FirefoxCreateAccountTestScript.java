package careers;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import careers.pages.CreateAccountPage;
import careers.testbase.BaseClass;
import careers.pages.BasicInfoPage;

public class FirefoxCreateAccountTestScript extends BaseClass {

    CreateAccountPage createaccountPage = new CreateAccountPage();
    BasicInfoPage basicinfopage = new BasicInfoPage();

    @Test
    public void verifyBasicInfoScreen() throws Exception {

        extentTest.log(LogStatus.INFO,"Verify Account Creation for new user in Firefox Browser");
        //loginpage.LoginPageDriver(BaseClass.driver);
        createaccountPage.CreateAccountPageDriver(BaseClass.driver);
        basicinfopage.BasicInfoDriver(BaseClass.driver);

        createaccountPage.createNewUser(ReadProperties.get("femailaddress"), ReadProperties.get("fpassword"));
        extentTest.log(LogStatus.PASS,"Account is created for new user successfully");

        basicinfopage.enterBasicInfo(ReadProperties.get("ffirstname"), ReadProperties.get("flastname"), ReadProperties.get("mobilenumber"), ReadProperties.get("zipcode"));
        extentTest.log(LogStatus.PASS,"User is navigated to Confirm Phone Screen");


    }
}
