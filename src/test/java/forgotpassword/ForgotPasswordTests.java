package forgotpassword;

import base.BaseTests;
import static org.testng.Assert.*;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pages.forgotpassword.EmailSentPage;
import pages.forgotpassword.ForgotPasswordPage;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testPasswordRecovery(){
        reportLogger = report.createTest("Password Recovery Test");

        reportLogger.log(Status.INFO, "Clicking on Forgot Password Option");
        ForgotPasswordPage forgotPasswordPage = homePage.clickOnForgotPassword();

        reportLogger.log(Status.INFO, "Inputting email");
        forgotPasswordPage.setEmail("tau@example.com");
        reportLogger.log(Status.PASS, "Entered email: tau@example.com");

        reportLogger.log(Status.INFO, "Clicking on Retrieve Password button");
        EmailSentPage confirmationMessagePage = forgotPasswordPage.clickRetrievePasswordButton();
        reportLogger.log(Status.PASS, "Clicked on Retrieve Password Button");

        assertTrue(confirmationMessagePage.getConfirmationMessage().contains("Internal Server Error"),
                   "Confirmation message is incorrect");
    }
}
