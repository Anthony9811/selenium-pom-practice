package horizontalslider;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTests extends BaseTests {
    HorizontalSliderPage horizontalSliderPage;

    @Test
    public void testHorizontalSlider() {
        horizontalSliderPage = homePage.clickOnHorizontalSlider();
        horizontalSliderPage.moveSlider("4");
        Assert.assertEquals(horizontalSliderPage.getCurrentSliderValue(),
                    "4",
                    "Value is incorrect");
    }
}
