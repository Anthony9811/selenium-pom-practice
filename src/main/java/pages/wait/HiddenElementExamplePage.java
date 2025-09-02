package pages.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HiddenElementExamplePage {
    WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator = By.id("loading");
    private By loadedText = By.cssSelector("#finish h4");
    private WebDriverWait wait;

    public HiddenElementExamplePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickStart() {
        driver.findElement(startButton).click();
        WebElement loadingBar = driver.findElement(loadingIndicator);
        wait.until(ExpectedConditions.invisibilityOf(loadingBar));
    }

    public String getLoadedText() {
        return driver.findElement(loadedText).getText();
    }
}
