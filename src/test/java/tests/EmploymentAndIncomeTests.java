package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.EmploymentAndIncomePage;
import pages.ExpensesPage;
import pages.PersonalInformationPage;
import utilities.CustomListener;
import utilities.MethodsWithValidCredentials;

@Listeners(CustomListener.class)
public class EmploymentAndIncomeTests extends TestBase {



    @Test (groups = {"smoke"})
    public void assertTotalIncomeTest() throws Exception{
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

        Assert.assertTrue(employmentAndIncomePage.totalIncome.getText().contains("6500 $"));

    }

    @Test (groups = {"smoke"})
    public void fillEmploymentAndIncomeFormTest() throws Exception{
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

        Assert.assertTrue(driver.getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/mortagage.php"));

    }

}
