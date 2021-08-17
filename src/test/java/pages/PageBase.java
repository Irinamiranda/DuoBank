package pages;
import org.openqa.selenium.support.PageFactory;
import utilities.CreateDriver;

public class PageBase {

    public PageBase() {
        PageFactory.initElements(CreateDriver.getDriver(), this);
    }
}
