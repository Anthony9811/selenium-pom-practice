package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    private By paragraphs = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * It scrolls until the paragraph specified is in view
     * @param paragraphNumber is 1-based
     */
    public void scrollToParagraph(int paragraphNumber) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
        while (getNumberOfParagraphsPresent() < paragraphNumber) {
            javaScriptExecutor.executeScript(script);
        }
    }

    private int getNumberOfParagraphsPresent() {
        return driver.findElements(paragraphs).size();
    }
}
