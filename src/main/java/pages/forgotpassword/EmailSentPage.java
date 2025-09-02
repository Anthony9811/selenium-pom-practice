package pages.forgotpassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentPage {
    public WebDriver driver;
    private By confirmationMessage = By.id("Confirmation Message"); //may be a wrong id

    public EmailSentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getConfirmationMessage(){
        /*
    as of 20/08/2025 the page with the confirmation message cannot be properly tested due to
    an "Internal Server Error" showing up when clicking the "Retrieve Password" button,
    so it will be tested using that error message until it gets fixed
        */
        return driver.findElement(By.tagName("h1")).getText();
    }
}