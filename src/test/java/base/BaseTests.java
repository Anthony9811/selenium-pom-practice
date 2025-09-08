package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.ExtentManager;
import utils.ScreenshotHelper;
import utils.WindowManager;


public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    protected ExtentReports report;
    protected ExtentTest reportLogger;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        goToHomePage();

        homePage = new HomePage(driver);
    }

    @BeforeSuite
    public void initializeReport() {
        report = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void goToHomePage() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void recordTestResult(ITestResult testResult) {
        reportLogger = report.createTest(testResult.getName());
        switch (testResult.getStatus()) {
            case ITestResult.FAILURE:
                reportLogger.log(Status.FAIL, "Test Failed: " + testResult.getThrowable());
                attachScreenshot(testResult.getName());
                break;

            case ITestResult.SUCCESS:
                reportLogger.log(Status.PASS, "Test Passed");
                attachScreenshot(testResult.getName());
                break;

            case ITestResult.SKIP:
                reportLogger.log(Status.SKIP, "Test Skipped: " + testResult.getThrowable());
                break;
        }
    }

    @AfterSuite
    public void flushReport() {
        report.flush();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private void attachScreenshot(String testName) {
        String screenshotPath = ScreenshotHelper.takeAScreenshot(driver, testName);
        reportLogger.addScreenCaptureFromPath(screenshotPath);
    }
}
