package nestedframes;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.frames.FramesPage;
import pages.frames.NestedFramesPage;

public class NestedFramesTests extends BaseTests {
    FramesPage framesPage;

    @Test
    public void testNestedFrames() {
        String leftFrameBodyText, bottomFrameBodyText;

        framesPage = homePage.clickOnFrames();

        NestedFramesPage nestedFramesPage = framesPage.clickOnNestedFrames();
        nestedFramesPage.switchToTopFrame();
        nestedFramesPage.switchToLeftFrame();
        leftFrameBodyText = nestedFramesPage.getFrameText();
        Assert.assertEquals(leftFrameBodyText, "LEFT", "The texts don't match");
        nestedFramesPage.switchToTheMainArea();

        nestedFramesPage.switchToBottomFrame();
        bottomFrameBodyText = nestedFramesPage.getFrameText();
        Assert.assertEquals(bottomFrameBodyText, "BOTTOM", "The texts don't match");
        nestedFramesPage.switchToTheMainArea();

    }
}
