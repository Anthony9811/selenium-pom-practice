package hovers;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;

public class HoversTests extends BaseTests {
    WebDriver driver;

    @Test
    public void testHoverOnUsers() {
        HoversPage hoversPage = homePage.clickOnHovers();

        for (int i = 0; i < hoversPage.userProfiles.size(); i++) {
            hoversPage.hoverOverUser(i);

            Assert.assertEquals(hoversPage.getUserName(),
                                "name: user" + (i + 1),
                                "The name is incorrect");

            Assert.assertEquals(hoversPage.getUserProfileLink(),
                                "View profile",
                                "The profile link is incorrect or unavailable");
        }
    }
}
