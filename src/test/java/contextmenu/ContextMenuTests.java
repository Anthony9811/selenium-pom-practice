package contextmenu;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class ContextMenuTests extends BaseTests {
    ContextMenuPage contextMenuPage;

    @Test
    public void testContextMenu() {
        contextMenuPage = homePage.clickOnContextMenu();
        contextMenuPage.rightClickOnBox();
        Assert.assertEquals(contextMenuPage.alert_getAlertText(),
                "You selected a context menu",
                "Alert text is incorrect");
        contextMenuPage.alert_clickToAccept();
    }
}
