package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ExpensesPage;
import pages.PersonalInformationPage;
import utilities.CustomListener;
import utilities.MethodsWithValidCredentials;

import java.util.function.Function;

@Listeners(CustomListener.class)
public class    ExpensesTests extends TestBase {

    @Test (groups = {"smoke"})
    public void fillExpensesFormTest() throws Exception {

        MethodsWithValidCredentials.login();
        MethodsWithValidCredentials.clickMortgageAppLink();
        MethodsWithValidCredentials.fillPreApprovalDetailsPage();
        PersonalInformationPage page = new PersonalInformationPage();
        MethodsWithValidCredentials.fillPersonalInfoPage(page);
        page.nextButton.click();
        ExpensesPage expensesPage = new ExpensesPage();

        expensesPage.checkboxOwn.click();
        expensesPage.firstMortgageTotalPayment.sendKeys("500000");
        expensesPage.nextButton.click();

        Assert.assertTrue(driver.getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/mortagage.php"));
    }


}
