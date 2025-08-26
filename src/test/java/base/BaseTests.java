package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;

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
        System.setProperty("webdriver.chrome.driver","C:/Users/ajort/Downloads/chromedriver-win64/chromedriver.exe");
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
}
