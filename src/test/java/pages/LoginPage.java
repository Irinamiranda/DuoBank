package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.CreateDriver;

public class LoginPage extends  PageBase{


    @FindBy(id = "exampleInputEmail1")
    public WebElement useremailField;

    @FindBy(id = "exampleInputPassword1")
    public WebElement passwordField;

    @FindBy(name = "login")
    public WebElement loginButton;

    @FindBy(xpath = "//a[.='Sign up']")
    public WebElement signUpLink;


}
