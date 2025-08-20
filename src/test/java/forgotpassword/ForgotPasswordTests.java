package forgotpassword;

import base.BaseTests;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.forgotpassword.EmailSentPage;
import pages.forgotpassword.ForgotPasswordPage;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testPasswordRecovery(){
        ForgotPasswordPage forgotPasswordPage = homePage.clickOnForgotPassword();
        forgotPasswordPage.setEmail("tau@example.com");
        EmailSentPage confirmationMessagePage = forgotPasswordPage.clickRetrievePasswordButton();

        assertTrue(confirmationMessagePage.getConfirmationMessage().contains("Internal Server Error"),
                   "Confirmation message is incorrect");
    }
}
