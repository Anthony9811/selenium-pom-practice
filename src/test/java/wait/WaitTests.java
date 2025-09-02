package wait;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.wait.DynamicLoadingPage;
import pages.wait.HiddenElementExamplePage;
import pages.wait.RenderedElementExamplePage;

public class WaitTests extends BaseTests {
    DynamicLoadingPage dynamicLoadingPage;

    @Test
    public void testWaitUntilHidden() {
        dynamicLoadingPage = homePage.clickOnDynamicLoading();
        HiddenElementExamplePage hiddenElementExamplePage = dynamicLoadingPage.clickOnExampleOne();
        hiddenElementExamplePage.clickStart();
        Assert.assertEquals(hiddenElementExamplePage.getLoadedText(),
                "Hello World!",
                "Message is incorrect or not appearing");
    }

    @Test
    public void testWaitUntilRendered() {
        dynamicLoadingPage = homePage.clickOnDynamicLoading();
        RenderedElementExamplePage renderedElementExamplePage = dynamicLoadingPage.clickOnExampleTwo();
        renderedElementExamplePage.clickStart();
        Assert.assertEquals(renderedElementExamplePage.getLoadedText(),
                "Hello World!",
                "Message is incorrect or not correctly rendered");
    }
}
