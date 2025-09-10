package horizontalslider;

import base.BaseTests;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTests extends BaseTests {
    HorizontalSliderPage horizontalSliderPage;

    @Test
    public void testHorizontalSlider() {
        reportLogger = report.createTest("Horizontal Slider Test");

        reportLogger.log(Status.INFO, "Clicking on Horizotal Slider option");
        horizontalSliderPage = homePage.clickOnHorizontalSlider();

        reportLogger.log(Status.INFO, "Moving slider to 4");
        horizontalSliderPage.moveSlider("4");
        reportLogger.log(Status.PASS, "Slider moved to 4");

        Assert.assertEquals(horizontalSliderPage.getCurrentSliderValue(),
                    "4",
                    "Value is incorrect");
    }
}
