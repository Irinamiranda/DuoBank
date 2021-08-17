package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import tests.ExpensesTests;
import tests.TestBase;

public class MethodsWithValidCredentials {

    public static void login(){
        LoginPage loginPage = new LoginPage();
        loginPage.useremailField.sendKeys(ConfigReader.getProperty("username1"));
        loginPage.passwordField.sendKeys(ConfigReader.getProperty("password1"));
        loginPage.loginButton.click();
    }

    public static void clickMortgageAppLink(){
        PreApprovalDetailsPage preApprovalDetailsPage = new PreApprovalDetailsPage();
        preApprovalDetailsPage.mortgageApplicationLink.click();


    }

    public static void fillPreApprovalDetailsPage() throws Exception {

        PreApprovalDetailsPage preApprovalDetailsPage = new PreApprovalDetailsPage();
        preApprovalDetailsPage.realtorInfo.sendKeys(ConfigReader.getProperty("realtorInfo"));
        preApprovalDetailsPage.loanOfficerCheckBox.click();
        preApprovalDetailsPage.estimatePurchasePrice.sendKeys(ConfigReader.getProperty("purchasePrice"));
        preApprovalDetailsPage.downPayment.sendKeys(ConfigReader.getProperty("downPayment"));
        TestBase.selectDropDownValueByValue(preApprovalDetailsPage.downPaymentSource, ConfigReader.getProperty("downPaymentSource"));
        preApprovalDetailsPage.nextButton.click();
    }

    public static void fillPersonalInfoPage(PersonalInformationPage page){
        page.firstName.sendKeys("Matt");
        page.middleName.sendKeys("R");
        page.lastName.sendKeys("Young");
        page.email.sendKeys("abc123@gmail.com");
        page.dob.sendKeys("11171986");
        page.ssn.sendKeys("123563434");

        Select s = new Select(page.sex);
        s.selectByValue("Married");

        page.cellPhoneNo.sendKeys("1234566767");
        page.homePhoneNo.sendKeys("3457670987");

    }
    public static void fillEmploymentAndIncomeForm(EmploymentAndIncomePage page) {

        page.employerName1.sendKeys("n/a");
        page.grossMonthlyIncome.sendKeys("5000");
        page.monthlyBonuses.sendKeys("500");
        page.monthlyDividents.sendKeys("1000");

    }



}
