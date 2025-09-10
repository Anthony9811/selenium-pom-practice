package modal;

import base.BaseTests;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ModalPage;

public class ModalTests extends BaseTests {
    ModalPage modalPage;

    @Test
    public void testModalWindow() {
        reportLogger = report.createTest("Modal Window Test");

        reportLogger.log(Status.INFO, "Clicking on Modal option");
        modalPage = homePage.clickOnModalPage();

        reportLogger.log(Status.INFO, "Obtaining modal title");
        String modalTitle = "This is a modal window";
        reportLogger.log(Status.PASS, "Modal title Obtained");

        reportLogger.log(Status.INFO, "Obtaining modal body text");
        String modalBody = "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker).";
        reportLogger.log(Status.PASS, "Modal body text obtained");

        Assert.assertEquals(modalPage.getModalTitle(), modalTitle.toUpperCase(), "The modal title is incorrect");
        Assert.assertEquals(modalPage.getModalBodyText(), modalBody, "The modal body is incorrect");

    }
}
