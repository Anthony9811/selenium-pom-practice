package keypresses;

import base.BaseTests;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

public class KeyPressesTests extends BaseTests {
    KeyPressesPage keyPressesPage;

    @Test
    public void testKeyInput() {
        reportLogger = report.createTest("Key Input Test");

        reportLogger.log(Status.INFO, "Clicking on Key Presses option");
        keyPressesPage = homePage.clickOnKeyPresses();

        reportLogger.log(Status.INFO, "Pressing SHIFT key");
        keyPressesPage.inputKey("" + Keys.SHIFT);
        reportLogger.log(Status.PASS, "SHIFT key pressed");

        Assert.assertEquals(keyPressesPage.getEnteredKey(), "You entered: SHIFT");
    }
}
