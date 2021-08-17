package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.LoginTests;

public class PreApprovalDetailsPage extends PageBase {



    @FindBy(xpath = "//span[@data-i18n='eCommerce']")
    public WebElement mortgageApplicationLink;

    @FindBy(id = "realtorinfo")
    public WebElement realtorInfo;

    @FindBy(xpath = "//input[@name='loan_officer_status']//parent::div/label[text()='No']")
    public WebElement loanOfficerCheckBox;

    @FindBy(name = "est_purchase_price")
    public WebElement estimatePurchasePrice;

    @FindBy(id = "downpayment")
    public WebElement downPayment;

    @FindBy(name = "src_down_payment")
    public WebElement downPaymentSource;

    @FindBy ( xpath = "//a[@href='#next']")
     public WebElement nextButton;







}
