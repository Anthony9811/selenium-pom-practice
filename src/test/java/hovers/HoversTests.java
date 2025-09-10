package hovers;

import base.BaseTests;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;

public class HoversTests extends BaseTests {

    @Test
    public void testHoverOnUsers() {
        reportLogger = report.createTest("Hover Over Users Test");

        reportLogger.log(Status.INFO, "Clicking on Hovers option");
        HoversPage hoversPage = homePage.clickOnHovers();

        for (int i = 0; i < hoversPage.userProfiles.size(); i++) {
            reportLogger.log(Status.INFO, "Hovering over user " + i);
            hoversPage.hoverOverUser(i);
            reportLogger.log(Status.PASS, "Mouse hovered over user " + i);

            Assert.assertEquals(hoversPage.getUserName(),
                                "name: user" + (i + 1),
                                "The name is incorrect");

            Assert.assertEquals(hoversPage.getUserProfileLink(),
                                "View profile",
                                "The profile link is incorrect or unavailable");
        }
    }
}
