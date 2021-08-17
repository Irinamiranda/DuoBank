package tests;

import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CreditReportPage;
import pages.EmploymentAndIncomePage;
import pages.ExpensesPage;
import pages.PersonalInformationPage;
import utilities.CustomListener;
import utilities.MethodsWithValidCredentials;

import java.util.function.Function;

@Listeners(CustomListener.class)
public class CreditReportTests extends TestBase{
    @Test (groups = {"smoke"})
    public void positiveAnswerforCreditReport() throws Exception{
        MethodsWithValidCredentials.login();
        MethodsWithValidCredentials.clickMortgageAppLink();
        MethodsWithValidCredentials.fillPreApprovalDetailsPage();

        PersonalInformationPage personalInformationPage = new PersonalInformationPage();
        MethodsWithValidCredentials.fillPersonalInfoPage(personalInformationPage);
        personalInformationPage.nextButton.click();
        ExpensesPage expensesPage = new ExpensesPage();

        expensesPage.checkboxOwn.click();
        expensesPage.firstMortgageTotalPayment.sendKeys("500000");
        expensesPage.nextButton.click();
        EmploymentAndIncomePage employmentAndIncomePage = new EmploymentAndIncomePage();
        MethodsWithValidCredentials.fillEmploymentAndIncomeForm(employmentAndIncomePage);
        employmentAndIncomePage.nextButton.click();
        CreditReportPage creditReportPage=new CreditReportPage();
        if (!creditReportPage.yesCheckBox.isSelected()){
            creditReportPage.yesCheckBox.click();
        }
        creditReportPage.nextButton.click();

        Assert.assertTrue(driver.getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/mortagage.php"));

    }
    @Test (groups = {"smoke"})
    public void negativeAnswerforCreditReport() throws  Exception{
        MethodsWithValidCredentials.login();
        MethodsWithValidCredentials.clickMortgageAppLink();
        MethodsWithValidCredentials.fillPreApprovalDetailsPage();

        PersonalInformationPage personalInformationPage = new PersonalInformationPage();
        MethodsWithValidCredentials.fillPersonalInfoPage(personalInformationPage);
        personalInformationPage.nextButton.click();
        ExpensesPage expensesPage = new ExpensesPage();

        expensesPage.checkboxOwn.click();
        expensesPage.firstMortgageTotalPayment.sendKeys("500000");
        expensesPage.nextButton.click();
        EmploymentAndIncomePage employmentAndIncomePage = new EmploymentAndIncomePage();
        MethodsWithValidCredentials.fillEmploymentAndIncomeForm(employmentAndIncomePage);
        employmentAndIncomePage.nextButton.click();
        CreditReportPage creditReportPage=new CreditReportPage();
        creditReportPage.nextButton.click();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/mortagage.php"));
    }



}
