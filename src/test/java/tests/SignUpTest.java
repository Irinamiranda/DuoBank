package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignUpPage;
import utilities.ConfigReader;

public class SignUpTest extends  TestBase{
    @BeforeMethod
    public void setUpSignUpPageMethod(){
        LoginPage loginPage = new LoginPage();
        loginPage.signUpLink.click();
    }
    @Test()
    public void urlCorrectionCheck() {

        SignUpTest signUpTest = new SignUpTest();
        String expectedUrl = "http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/register.php";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

        @Test()
                public void positiveSignIn(){
            SignUpPage signUpPage=new SignUpPage();
            Faker faker=new Faker();
            signUpPage.firstName.sendKeys(faker.address().firstName());
            signUpPage.lastName.sendKeys(faker.address().lastName());
            signUpPage.email.sendKeys(faker.internet().emailAddress());
            signUpPage.password.sendKeys(faker.internet().password());
            signUpPage.signUp.click();
          Assert.assertEquals(driver.getCurrentUrl(),"http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/register.php");
        }
        @Test
    public void negativeSignInTestWithWrongCredentials(){
            SignUpPage signUpPage=new SignUpPage();
            Faker faker=new Faker();
            signUpPage.firstName.sendKeys(faker.address().cityPrefix());
            signUpPage.lastName.sendKeys(faker.number().digit());
            signUpPage.email.sendKeys(faker.address().firstName());
            signUpPage.password.sendKeys(faker.business().creditCardNumber());
            signUpPage.signUp.click();
            Assert.assertFalse(!driver.getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/register.php"));

        }
    }







