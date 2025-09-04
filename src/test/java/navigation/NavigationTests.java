package navigation;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.wait.RenderedElementExamplePage;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator() {
        homePage.clickOnDynamicLoading().clickOnExampleOne();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://www.google.com");
    }

    @Test
    public void testSwitchTab() {
        homePage.clickOnMultipleWindows().clickHere();
        getWindowManager().switchToASpecificTab("New Window");
    }

    @Test
    public void testSwitchToDynamicLoadingExampleTwo() {
        RenderedElementExamplePage renderedElementExamplePage;
        renderedElementExamplePage = homePage.clickOnDynamicLoading().rightClickOnExampleTwo();
        getWindowManager().switchToANewTab();
        Assert.assertTrue(renderedElementExamplePage.isStartButtonPresent(),
                "Start button is not displayed");
    }
}