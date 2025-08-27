package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalPage {
    WebDriver driver;
    private By modalWindow = By.className("modal");
    private By modalTitle = By.cssSelector("div[class='modal-title'] h3");
    private By modalBody = By.xpath("//div[@class='modal-body']//p[1]");
    private By closeButton = By.className("modal-footer");
    private WebDriverWait wait;

    public ModalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isModalDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(modalWindow));
            return true;
        } catch (org.openqa.selenium.TimeoutException e){
            return false;
        }
    }

    public String getModalTitle() {
        isModalDisplayed();
        return driver.findElement(modalTitle).getText();
    }

    public String getModalBodyText() {
        isModalDisplayed();
        return driver.findElement(modalBody).getText();
    }

    public void closeModalWindow() {
        isModalDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
    }
}
