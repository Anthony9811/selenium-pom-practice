package navigation;

import base.BaseTests;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.wait.RenderedElementExamplePage;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator() {
        reportLogger = report.createTest("Page Navigation Test");

        reportLogger.log(Status.INFO, "Clicking on Dynamic Loading option");
        reportLogger.log(Status.INFO, "Clicking on Example 1 option");
        homePage.clickOnDynamicLoading().clickOnExampleOne();

        reportLogger.log(Status.INFO, "Going back to Dynamic Loading page");
        getWindowManager().goBack();
        reportLogger.log(Status.PASS, "Went back to Dynamic Loading page");

        reportLogger.log(Status.INFO, "Refreshing page");
        getWindowManager().refreshPage();
        reportLogger.log(Status.PASS, "Page refreshed");

        reportLogger.log(Status.INFO, "Going forward to Example 1 page");
        getWindowManager().goForward();
        reportLogger.log(Status.PASS, "Went forward to Example 1 page");

        reportLogger.log(Status.INFO, "Going back to Google.com");
        getWindowManager().goTo("https://www.google.com");
        reportLogger.log(Status.PASS, "Google.com loaded");
    }

    @Test
    public void testSwitchTab() {
        reportLogger = report.createTest("Switching To A Specific Tab Test");

        reportLogger.log(Status.INFO, "Clicking on Multiple Windows");
        reportLogger.log(Status.INFO, "Clicking on Click Here button");
        homePage.clickOnMultipleWindows().clickHere();

        reportLogger.log(Status.INFO, "Switching to the New Window tab");
        getWindowManager().switchToASpecificTab("New Window");
        reportLogger.log(Status.PASS, "Switched to the New Window tab");
    }

    @Test
    public void testSwitchToDynamicLoadingExampleTwo() {
        reportLogger = report.createTest("Switch To A New Tab Test");
        RenderedElementExamplePage renderedElementExamplePage;

        reportLogger.log(Status.INFO, "Clicking on Dynamic Loading option");
        reportLogger.log(Status.INFO, "Right-clicking on Example 2 option");
        reportLogger.log(Status.INFO, "Entering CTRL + Enter");
        renderedElementExamplePage = homePage.clickOnDynamicLoading().rightClickOnExampleTwo();
        reportLogger.log(Status.PASS, "Opened example 2 in a new tab");

        reportLogger.log(Status.INFO, "Switching to Example 2 tab");
        getWindowManager().switchToANewTab();
        reportLogger.log(Status.PASS, "Switched to Example 2 tab");

        reportLogger.log(Status.INFO, "Checking if start button is displayed");
        Assert.assertTrue(renderedElementExamplePage.isStartButtonPresent(),
                "Start button is not displayed");
        reportLogger.log(Status.PASS, "Start button is displayed");
    }
}