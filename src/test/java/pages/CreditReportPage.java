package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditReportPage extends PageBase{
    @FindBy(xpath="//label[@for='creditreport1']")
    public WebElement yesCheckBox;
    @FindBy(xpath="//label[@for='creditreport2']")
    public WebElement noCheckBox;
    @FindBy(xpath="(//a[@class='btn btn-light-primary'])[2]")
    public WebElement nextButton;
}
