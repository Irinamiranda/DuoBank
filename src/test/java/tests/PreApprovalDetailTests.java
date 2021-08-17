package tests;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PreApprovalDetailsPage;
import pages.PreApprovalDetailsPage;
import utilities.ConfigReader;
import utilities.CustomListener;
import utilities.MethodsWithValidCredentials;

@Listeners(CustomListener.class)
public class PreApprovalDetailTests extends  TestBase {

    @Test (groups = {"smoke"})
    public void fillPreApprovalPageTest() throws Exception {
        MethodsWithValidCredentials.login();
        MethodsWithValidCredentials.clickMortgageAppLink();
        MethodsWithValidCredentials.fillPreApprovalDetailsPage();


        Assert.assertTrue(driver.getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/mortagage.php"));


    }
}