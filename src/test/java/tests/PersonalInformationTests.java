package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PersonalInformationPage;
import pages.PreApprovalDetailsPage;
import utilities.ConfigReader;
import utilities.CustomListener;
import utilities.MethodsWithValidCredentials;

@Listeners(CustomListener.class)
public class PersonalInformationTests extends PreApprovalDetailTests{

      @Test(groups = {"smoke"})
      public void fillPersonalInfoPageTest() throws Exception {
            MethodsWithValidCredentials.login();
            MethodsWithValidCredentials.clickMortgageAppLink();
            MethodsWithValidCredentials.fillPreApprovalDetailsPage();

            PersonalInformationPage personalInformationPage = new PersonalInformationPage();
            MethodsWithValidCredentials.fillPersonalInfoPage(personalInformationPage);
            personalInformationPage.nextButton.click();


            Assert.assertTrue(driver.getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/mortagage.php"));

    }


}



