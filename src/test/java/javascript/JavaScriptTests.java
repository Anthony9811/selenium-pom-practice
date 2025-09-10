package javascript;

import base.BaseTests;
import com.aventstack.extentreports.Status;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class JavaScriptTests extends BaseTests {

    @Test
    public void tesScrollToTable() {
        reportLogger = report.createTest("Scroll To Table Test");

        reportLogger.log(Status.INFO, "Clicking on Large & Deep DOM option");
        homePage.clickOnLargeAndDeepDom().scrollToTable();
        reportLogger.log(Status.INFO, "Scrolling to table");
        reportLogger.log(Status.PASS, "Table is in view");

    }

    @Test
    public void testScrollToFifthParagraph() {
        reportLogger = report.createTest("Scroll To A Paragraph Test");

        reportLogger.log(Status.INFO, "Clicking on Infinite Scroll");

        reportLogger.log(Status.INFO, "Scrolling to paragraph 5");
        homePage.clickOnInfiniteScroll().scrollToParagraph(5);
        reportLogger.log(Status.PASS, "Paragraph 5 is in view");
    }
}
