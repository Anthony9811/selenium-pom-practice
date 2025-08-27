package modal;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ModalPage;

public class ModalTests extends BaseTests {
    ModalPage modalPage;

    @Test
    public void testModalWindow() {
        modalPage = homePage.clickOnModalPage();
        String modalTitle = "This is a modal window";
        String modalBody = "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker).";
        Assert.assertEquals(modalPage.getModalTitle(), modalTitle.toUpperCase(), "The modal title is incorrect");
        Assert.assertEquals(modalPage.getModalBodyText(), modalBody, "The modal body is incorrect");

    }
}
