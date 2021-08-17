package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.CustomListener;

@Listeners(CustomListener.class)
@Test (groups = {"smoke"})
public class LoginTests extends TestBase {

    @Test (enabled = false)
    public void login(String useremail, String pass){

        LoginPage loginPage = new LoginPage();
        loginPage.useremailField.sendKeys(useremail);
        loginPage.passwordField.sendKeys(pass);
        loginPage.loginButton.click();
    }


    @Test
    public void appHealthCheck(){

        Assert.assertTrue(driver.getCurrentUrl().equals(ConfigReader.getProperty("url")));

    }

    @Test (groups = {"smoke"})
    public void loginpositive(){

        login(ConfigReader.getProperty("username1"), ConfigReader.getProperty("password1"));

        Assert.assertTrue(driver.getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/dashboard.php"));

    }

    @Test (groups = {"smoke"})
    public void loginNegativeWithWrongUseremail(){

        login(ConfigReader.getProperty("username2"), ConfigReader.getProperty("password1"));

        Assert.assertFalse(driver.getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/dashboard.php"));

    }

    @Test (groups = {"smoke"})
    public void loginNegativeWithWrongPassword(){

        login(ConfigReader.getProperty("username1"), ConfigReader.getProperty("password2"));

        Assert.assertFalse(driver.getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/dashboard.php"));

    }

    @Test (groups = {"smoke"})
    public void goToSignUpLink(){
        LoginPage loginPage = new LoginPage();
        loginPage.signUpLink.click();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/register.php"));
    }

}
