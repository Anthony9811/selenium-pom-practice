package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {
    WebDriver driver;
    private By inputField = By.id("target");
    private By enteredText = By.id("result");

    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputKey(String text) {
        driver.findElement(inputField).sendKeys(text);
    }

    public String getEnteredKey () {
        return driver.findElement(enteredText).getText();
    }
}
