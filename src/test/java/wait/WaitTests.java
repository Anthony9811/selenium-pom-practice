package wait;

import base.BaseTests;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.wait.DynamicLoadingPage;
import pages.wait.HiddenElementExamplePage;
import pages.wait.RenderedElementExamplePage;

public class WaitTests extends BaseTests {
    DynamicLoadingPage dynamicLoadingPage;

    @Test
    public void testWaitUntilHidden() {
        reportLogger = report.createTest("Wait Until Loading Bar Is Hidden Test");

        reportLogger.log(Status.INFO, "Clicking on Dynamic Loading page");
        dynamicLoadingPage = homePage.clickOnDynamicLoading();

        reportLogger.log(Status.INFO, "Clicking on Example 1 option");
        HiddenElementExamplePage hiddenElementExamplePage = dynamicLoadingPage.clickOnExampleOne();

        reportLogger.log(Status.INFO, "Clicking start button");
        hiddenElementExamplePage.clickStart();

        reportLogger.log(Status.INFO, "Waiting for text to load");
        Assert.assertEquals(hiddenElementExamplePage.getLoadedText(),
                "Hello World!",
                "Message is incorrect or not appearing");
        reportLogger.log(Status.PASS, "Hello World! text displayed");
    }

    @Test
    public void testWaitUntilRendered() {
        reportLogger = report.createTest("Wait Until Element Is Rendered Test");

        reportLogger.log(Status.INFO, "Clicking on Dynamic Loading page");
        dynamicLoadingPage = homePage.clickOnDynamicLoading();

        reportLogger.log(Status.INFO, "Clicking on Example 2 option");
        RenderedElementExamplePage renderedElementExamplePage = dynamicLoadingPage.clickOnExampleTwo();

        reportLogger.log(Status.INFO, "Clicking start button");
        renderedElementExamplePage.clickStart();

        reportLogger.log(Status.INFO, "Waiting element to render");
        Assert.assertEquals(renderedElementExamplePage.getLoadedText(),
                "Hello World!",
                "Message is incorrect or not correctly rendered");
        reportLogger.log(Status.PASS, "Hello World! element is rendered");
    }
}
