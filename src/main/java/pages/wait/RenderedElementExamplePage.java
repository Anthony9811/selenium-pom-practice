package pages.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RenderedElementExamplePage {
    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadedText = By.cssSelector("#finish h4");
    private WebDriverWait wait;

    public RenderedElementExamplePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean checkIfTextIsVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(loadedText));
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void clickStart() {
        driver.findElement(startButton).click();
        checkIfTextIsVisible();
    }

    public String getLoadedText() {
        return driver.findElement(loadedText).getText();
    }
}
