package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.CreateDriver;
import utilities.SeleniumUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    protected static ExtentReports reporter;
    protected static ExtentSparkReporter htmlReporter;
    protected static ExtentTest logger;

    @BeforeSuite
    public void setUpReport(){
        reporter = new ExtentReports();
        String path = System.getProperty("user.dir") + "/test-output/testReports/index.html";
        htmlReporter = new ExtentSparkReporter(path);
        htmlReporter.config().setReportName("DuoBank automation tests");
        reporter.attachReporter(htmlReporter);

        //config.settings
        reporter.setSystemInfo("Tester", "IS");
        reporter.setSystemInfo("Environment", "Test_Env");
        reporter.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
    }


    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setupMethod(@Optional String browser) {

        driver = CreateDriver.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {
        if(result.getStatus()== ITestResult.FAILURE){
            SeleniumUtils.takeScreenshot("failedTest.png");
        }
        CreateDriver.quitDriver();
    }

    @AfterSuite
    public  void tearDownReport(){
        reporter.flush();
    }

    public static void selectDropDownValueByValue (WebElement element, String Value ) throws Exception {
        Select dropdown = new Select((element));
        dropdown.selectByVisibleText(Value);


    }
}