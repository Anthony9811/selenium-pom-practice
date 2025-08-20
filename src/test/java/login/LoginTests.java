package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.login.LoginPage;
import pages.login.SecureAreaPage;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {

    /*
    This will run after the setUp from BaseTests
     */
    @Test
    public void testSuccessfulLogin() {
        /*
        I'm basically saying that in order to go to the login page
        i first need to click the form authentication button, so
        from now on all the following actions will happen in the
        login page
         */
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");

        /*
        I'm moving to the secure area page to check if the message is showing
        and since i need to login before doing that, this is what should be done.
        All actions will happen in the secure area page from now on
         */
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"),
                    "Alert text is incorrect");
    }
}
