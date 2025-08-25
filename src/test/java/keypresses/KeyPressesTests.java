package keypresses;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

public class KeyPressesTests extends BaseTests {
    KeyPressesPage keyPressesPage;

    @Test
    public void testKeyInput() {
        keyPressesPage = homePage.clickOnKeyPresses();
        keyPressesPage.inputKey("" + Keys.SHIFT);
        Assert.assertEquals(keyPressesPage.getEnteredKey(), "You entered: SHIFT");
    }
}
