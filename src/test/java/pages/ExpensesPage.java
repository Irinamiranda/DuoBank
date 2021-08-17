package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ExpensesPage extends PageBase {

    @FindBy(xpath = "//span[@data-i18n='eCommerce']")
    public WebElement mortgageApplicationLink;

    @FindBy(css = "label[for='expense2']")
    public WebElement checkboxOwn;

    @FindBy(id = "expense1")
    public WebElement checkboxRent;

    @FindBy(id = "firtmortagagetotalpayment")
    public WebElement firstMortgageTotalPayment;

    @FindBy(xpath = "//a[@href='#next']")
    public WebElement nextButton;

    @FindBy(xpath = "//a[@href='#previous']")
    public WebElement previousButton;



}
