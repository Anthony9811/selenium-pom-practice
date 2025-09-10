package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.nio.file.Files;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.ExtentManager;
import utils.ScreenshotHelper;
import utils.WindowManager;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    protected ExtentReports report;
    protected ExtentTest reportLogger;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        goToHomePage();
        initializeReport();
        homePage = new HomePage(driver);
    }

    @BeforeSuite
    public void initializeReport() {
        report = ExtentManager.getInstance();
        try {
            cleanOldScreenshots();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        Path reportDirectory = Paths.get(System.getProperty("user.dir"), "test-output");
        Path screenshotFile = Paths.get(screenshotPath);

        String relativePath = reportDirectory.relativize(screenshotFile).toString();
        reportLogger.addScreenCaptureFromPath(relativePath);
    }

    private void cleanOldScreenshots() throws IOException {
        Path screenshotsRoot = Paths.get(System.getProperty("user.dir"), "test-output", "screenshots");

        if (Files.exists(screenshotsRoot)) {
            // Walks through every file and folder under the screenshots directory
            try (Stream<Path> allPaths = Files.walk(screenshotsRoot)) {
                allPaths
                        .filter(path -> path.equals(screenshotsRoot)) // Ignores the root folder
                        .sorted(Comparator.comparingInt(Path::getNameCount).reversed()) // Sort so that the deepest files/folders are deleted first
                        .forEach(currentPath -> { // Deletes each file or folder
                            try {
                                Files.deleteIfExists(currentPath);
                            } catch (IOException e) {
                                System.err.println("Could not delete: " + currentPath + " -> " + e.getMessage());
                            }
                        });
                }
            }
    }
}
