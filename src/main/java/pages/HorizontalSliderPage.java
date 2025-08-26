package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    WebDriver driver;
    private By slider = By.xpath("//div/input[@value='0']");
    private By sliderValue = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveSlider(String targetValue) {
        while (!getCurrentSliderValue().equals(targetValue)) {
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getCurrentSliderValue() {
        return driver.findElement(sliderValue).getText();
    }


}
