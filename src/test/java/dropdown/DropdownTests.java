package dropdown;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTests extends BaseTests {
    DropdownPage dropdownPage;

    @BeforeClass
    public void navigateToDropdownPage() {
        // This method runs AFTER BaseTests.setUp() but BEFORE any @Test methods.
        // It uses the 'homePage' object that was initialized in the base class.
        dropdownPage = homePage.clickOnDropdown();
    }

    @DataProvider(name = "dropdownOptions")
    private Object[][] getDropdownOptions() {
        return new Object[][] {
                {"Option 1"},
                {"Option 2"}
        };
    }

    @Test(dataProvider = "dropdownOptions")
    public void testDropdownSelection(String optionText) {
        dropdownPage.selectOptionByText(optionText);
        String selectedOption = dropdownPage.getSelectedOptionText();
        Assert.assertEquals(selectedOption, optionText, "The selected option is different than "+ optionText);
        /*
        This was my initial approach before doing some research:

        DropdownPage dropdownPage = homePage.clickOnDropdown();
        dropdownPage.selectOptionByText("Option 1");

        selectedOption = dropdownPage.getSelectedOptionText();
        Assert.assertEquals(selectedOption,"Option 1","The selected option is not Option 1");

        dropdownPage.selectOptionByText("Option 2");
        selectedOption = dropdownPage.getSelectedOptionText();
        Assert.assertEquals(selectedOption,"Option 2","The selected option is not Option 2");
        */
    }
}
