package contextmenu;

import base.BaseTests;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class ContextMenuTests extends BaseTests {
    ContextMenuPage contextMenuPage;

    @Test
    public void testContextMenu() {
        reportLogger = report.createTest("Context Menu Test");

        reportLogger.log(Status.INFO, "Clicking on Context Menu option");
        contextMenuPage = homePage.clickOnContextMenu();

        reportLogger.log(Status.INFO, "Right-clicking on box");
        contextMenuPage.rightClickOnBox();
        reportLogger.log(Status.PASS, "Alert triggered");

        Assert.assertEquals(contextMenuPage.alert_getAlertText(),
                "You selected a context menu",
                "Alert text is incorrect");

        contextMenuPage.alert_clickToAccept();
        reportLogger.log(Status.PASS, "Alert accepted");
    }
}
