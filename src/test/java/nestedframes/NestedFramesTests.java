package nestedframes;

import base.BaseTests;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.frames.FramesPage;
import pages.frames.NestedFramesPage;

public class NestedFramesTests extends BaseTests {
    FramesPage framesPage;

    @Test
    public void testNestedFrames() {
        reportLogger = report.createTest("Nested Frames Test");
        String leftFrameBodyText, bottomFrameBodyText;

        reportLogger.log(Status.INFO, "Clicking on Frames option");
        framesPage = homePage.clickOnFrames();

        reportLogger.log(Status.INFO, "Clicking on Nested Frames option");
        NestedFramesPage nestedFramesPage = framesPage.clickOnNestedFrames();

        reportLogger.log(Status.INFO, "Obtaining left frame text");
        nestedFramesPage.switchToTopFrame();
        nestedFramesPage.switchToLeftFrame();
        leftFrameBodyText = nestedFramesPage.getFrameText();

        reportLogger.log(Status.INFO, "Verifying left frame text");
        Assert.assertEquals(leftFrameBodyText, "LEFT", "The texts don't match");
        reportLogger.log(Status.PASS, "Left frame text obtained");

        nestedFramesPage.switchToTheMainArea();

        reportLogger.log(Status.INFO, "Obtaining bottom frame text");
        nestedFramesPage.switchToBottomFrame();
        bottomFrameBodyText = nestedFramesPage.getFrameText();

        reportLogger.log(Status.INFO, "Verifying bottom frame text");
        Assert.assertEquals(bottomFrameBodyText, "BOTTOM", "The texts don't match");
        reportLogger.log(Status.PASS, "Bottom frame text obtained");

        nestedFramesPage.switchToTheMainArea();

    }
}
