/*
What i want to have here are fields that represent the elements on the page
and methods to interact with them
*/
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.forgotpassword.ForgotPasswordPage;
import pages.login.LoginPage;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication(){
        clickLink("Form Authentication");
        return new LoginPage(driver);
        /*
        Because the click navigates the user to a new page (the login page), the method returns an instance
        of the LoginPage class. This allows the test script to immediately continue interacting with the
         elements on the login page without needing to manually create a new object.
         */
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public DropdownPage clickOnDropdown() {
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public ForgotPasswordPage clickOnForgotPassword() {
        clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }
}
