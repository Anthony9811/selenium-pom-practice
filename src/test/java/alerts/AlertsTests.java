package alerts;

import base.BaseTests;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class AlertsTests extends BaseTests {
    AlertsPage alertsPage;

    @Test
    public void testAcceptAlert() {
        reportLogger = report.createTest("Accept Alert Test");

        reportLogger.log(Status.INFO, "Clicking on JavaScript Alerts OPTION");
        alertsPage = homePage.clickOnJavascriptAlertsPage();

        reportLogger.log(Status.INFO, "Clicking on JS Alert BUTTON");
        alertsPage.triggerAlert();
        reportLogger.log(Status.PASS, "Alert Triggered");

        alertsPage.alert_clickToAccept();
        reportLogger.log(Status.PASS, "Alert Accepted");

        Assert.assertEquals(alertsPage.getResultText(),
                "You successfully clicked an alert",
                "Results text is incorrect");
    }

    @Test
    public void testGetTextFromAlert() {
        reportLogger = report.createTest("Get Text From Alert Test");

        reportLogger.log(Status.INFO, "Clicking on JavaScript Alerts OPTION");
        alertsPage = homePage.clickOnJavascriptAlertsPage();

        reportLogger.log(Status.INFO, "Clicking on JS Confirm BUTTON");
        alertsPage.triggerConfirm();
        reportLogger.log(Status.PASS, "Alert Triggered");

        String text = alertsPage.alert_getText();


        alertsPage.alert_clickToDismiss();reportLogger.log(Status.INFO, "Alert Text Obtained");
        reportLogger.log(Status.PASS, "Alert Dismissed");

        Assert.assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
    }

    @Test
    public void testSetInput() {
        reportLogger = report.createTest("Write On Alert Input Test");

        reportLogger.log(Status.INFO, "Clicking on JavaScript Alerts OPTION");
        alertsPage = homePage.clickOnJavascriptAlertsPage();

        reportLogger.log(Status.INFO, "Clicking on JS Prompt BUTTON");
        alertsPage.triggerPrompt();
        reportLogger.log(Status.PASS, "Alert Triggered");

        reportLogger.log(Status.PASS, "Writing on alert's input field");
        String text = "Test input";
        alertsPage.alert_setInput(text);
        reportLogger.log(Status.PASS, "Entered 'Test input' on alert's input field");

        alertsPage.alert_clickToAccept();
        reportLogger.log(Status.PASS, "Alert Accepted");

        Assert.assertEquals(alertsPage.getResultText(),
                "You entered: " + text,
                "Results text incorrect");
    }
}
