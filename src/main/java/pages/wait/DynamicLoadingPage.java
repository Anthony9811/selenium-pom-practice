package pages.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;
    private By link_ExampleOne = By.xpath("//a[@href='/dynamic_loading/1']");
    private By link_ExampleTwo = By.xpath("//a[@href='/dynamic_loading/2']");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public HiddenElementExamplePage clickOnExampleOne() {
        driver.findElement(link_ExampleOne).click();
        return new HiddenElementExamplePage(driver);
    }

    public RenderedElementExamplePage clickOnExampleTwo() {
        driver.findElement(link_ExampleTwo).click();
        return new RenderedElementExamplePage(driver);
    }


}
