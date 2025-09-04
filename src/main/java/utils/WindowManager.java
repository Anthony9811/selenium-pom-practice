package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void refreshPage() {
        navigate.refresh();
    }

    public void goTo(String url) {
        navigate.to(url);
    }

    public Set<String> getAllWindowHandles() {
        return driver.getWindowHandles();
    }

    public void switchToASpecificTab(String tabTitle) {
        getAllWindowHandles();
        for (String handle : getAllWindowHandles()) {
            driver.switchTo().window(handle);
            if(tabTitle.equals(driver.getTitle())){
                break;
            }
        }
    }

    public void switchToANewTab() {
        Set<String> windows = getAllWindowHandles();
        windows.forEach(driver.switchTo()::window);
    }
}
