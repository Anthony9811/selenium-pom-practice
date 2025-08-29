package pages.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFramesPage {
    WebDriver driver;
    private By topFrame = By.xpath("//frame[@name='frame-top']");
    private By leftFrame = By.xpath("//frame[@name='frame-left']");
    private By bottomFrame = By.xpath("//frame[@name='frame-bottom']");
    private By frameBody = By.tagName("body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToTopFrame() {
        WebElement nestedTopFrame = driver.findElement(topFrame);
        driver.switchTo().frame(nestedTopFrame);
    }

    public void switchToLeftFrame() {
        WebElement nestedLeftFrame = driver.findElement(leftFrame);
        driver.switchTo().frame(nestedLeftFrame);
    }

    public void switchToBottomFrame() {
        WebElement nestedBottomFrame = driver.findElement(bottomFrame);
        driver.switchTo().frame(nestedBottomFrame);
    }

    public void switchToTheMainArea() {
        driver.switchTo().defaultContent();
    }

    public String getFrameText() {
        return driver.findElement(frameBody).getText();
    }
}
