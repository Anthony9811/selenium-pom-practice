package login;

import base.BaseTests;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pages.login.LoginPage;
import pages.login.SecureAreaPage;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() {
        reportLogger = report.createTest("Successful Login Test");

        reportLogger.log(Status.INFO, "Clicking on Form Authentication option");
        LoginPage loginPage = homePage.clickFormAuthentication();

        reportLogger.log(Status.INFO, "Writing username");
        loginPage.setUsername("tomsmith");
        reportLogger.log(Status.PASS, "Username entered");

        reportLogger.log(Status.INFO, "Writing password");
        loginPage.setPassword("SuperSecretPassword!");
        reportLogger.log(Status.PASS, "Password entered");

        reportLogger.log(Status.INFO, "Clicking Login button");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        reportLogger.log(Status.PASS, "Logged in successfully");

        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"),
                    "Alert text is incorrect");
    }
}
