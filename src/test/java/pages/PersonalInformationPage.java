package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.PreApprovalDetailTests;

public class PersonalInformationPage extends PageBase {

    @FindBy(xpath = "(//span[@class='menu-item'])[1]")
    public WebElement mortgageApplicationLink;

    @FindBy (id = "b_firstName")
    public WebElement firstName;

    @FindBy (id = "b_middleName")
    public WebElement middleName;

    @FindBy (id = "b_lastName")
    public WebElement lastName;

    @FindBy (id = "b_email")
    public WebElement email;

    @FindBy (id ="b_dob")
    public WebElement dob;

    @FindBy (id = "b_ssn")
    public WebElement ssn;

    @FindBy (xpath = "//select[@id='b_marital']")
    public WebElement sex;

    @FindBy (id = "b_cell")
    public WebElement cellPhoneNo;

    @FindBy (id = "b_home")
    public WebElement homePhoneNo;

    @FindBy (xpath = "//a[@href='#next']")
    public WebElement nextButton;






}
