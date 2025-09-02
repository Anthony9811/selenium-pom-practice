package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTests {

    @Test
    public void tesScrollToTable() {
        homePage.clickOnLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph() {
        homePage.clickOnInfiniteScroll().scrollToParagraph(5);
    }
}
