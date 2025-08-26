package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class AlertsTests extends BaseTests {
    AlertsPage alertsPage;

    @Test
    public void testAcceptAlert() {
        alertsPage = homePage.clickOnJavascriptAlertsPage();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        Assert.assertEquals(alertsPage.getResultText(),
                "You successfully clicked an alert",
                "Results text is incorrect");
    }

    @Test
    public void testGetTextFromAlert() {
        alertsPage = homePage.clickOnJavascriptAlertsPage();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        Assert.assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
    }

    @Test
    public void testSetInput() {
        alertsPage = homePage.clickOnJavascriptAlertsPage();
        alertsPage.triggerPrompt();
        String text = "Test input";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        Assert.assertEquals(alertsPage.getResultText(),
                "You entered: " + text,
                "Results text incorrect");
    }
}
