package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    /*
    It works like this: it will first call the setUp method
    Then any method that has the @Test annotation
    Then calls the method that has the @AfterClass
     */
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        goToHomePage();

        homePage = new HomePage(driver);
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
    public void recordFailure(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
        }
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }
}
